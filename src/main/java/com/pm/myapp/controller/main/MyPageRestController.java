package com.pm.myapp.controller.main;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pm.myapp.aws.AwsUpload;
import com.pm.myapp.controller.join.LoginController;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.service.main.UserService;
import com.pm.myapp.service.partyfm.MyPartyService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Log4j2
@NoArgsConstructor

@RequestMapping("/my/profile")
@RestController
public class MyPageRestController {

    @Setter(onMethod_ = @Autowired)
    private UserService userService;

    @Setter(onMethod_ = @Autowired)
    private MyPartyService myPartyService;

    @Setter(onMethod_ = @Autowired)
    private AwsUpload awsUpload;

    // 파티 탈퇴
    @DeleteMapping("/withdrawal-party")
    public Map<String, Boolean> withdrawalParty(
            @RequestBody String json
    ) {
        log.debug("withdrawalParty() invoked.");
        log.info("json: {}", json);

        JsonElement element = JsonParser.parseString(json);

        log.info("element: {}", element);

        String email = element.getAsJsonObject().get("email").getAsString();
        Integer partyCode = element.getAsJsonObject().get("partyCode").getAsInt();

        boolean result = this.myPartyService.doQuit(email, partyCode);

        Map<String, Boolean> data = new HashMap<>();
        data.put("result", result);

        return data;
    } // withdrawalParty

    // 프로필 수정
    @PostMapping("/edit-profile")
    public Map<String, String> editProfile(
            HttpServletRequest request, // 세션 업데이트를 위함
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "nickname", required = false) String nickname,
            @RequestParam(value = "fileLocation", required = false) MultipartFile fileLocation
    ) throws IOException {
        log.debug("editProfile() invoked.");

        // log.info("DTO: {}", dto);
        log.info("email: {}", email);
        log.info("nickname: {}", nickname);
        log.info("fileLocation: {}", fileLocation);

        String imagePath = "image/" + email;
        String imageUrl = "";

        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(LoginController.authKey);

        Map<String, Object> profile = new HashMap<>();

        // 랜덤값 형성 및 aws에 파일 업로드
        UUID uuid = UUID.randomUUID(); // 랜덤값

        if (fileLocation != null) {
            imageUrl = awsUpload.fileUpload(fileLocation, imagePath, uuid);
        }

        profile.put("email", email);
        profile.put("nickname", nickname);
        profile.put("fileLocation", imageUrl); // 파일 이름 주소

        boolean result = this.userService.editProfile(profile);
        log.info("\t + result : {}", result);

        Map<String, String> data = new HashMap<>();
        if (!imageUrl.equals("")) {
            data.put("fileLocation", imageUrl);
            user.setUserPic(imageUrl); // 세션 스코프 프로필 이미지 경로 재설정
        }
        data.put("nickname", nickname);
        user.setNickname(nickname);

        return data;

    } // editProfile

    // 회원 탈퇴
    @PatchMapping("/withdrawal")
    public Map<String, Boolean> deleteAccount(HttpServletRequest request) {
        log.debug("deleteAccount() invoked.");

        HttpSession session = request.getSession();
        Map<String, Boolean> data = new HashMap<>();

        UserDTO dto = (UserDTO) session.getAttribute(LoginController.authKey);

        log.info("session: {}", session);
        log.info("dto: {}", dto);

        boolean result = this.userService.withdrawal(dto.getEmail());
        data.put("result", result);

        // 로그아웃
        session.invalidate();
        request.getSession(true);

        return data;
    } // deleteAccount

} // end class
