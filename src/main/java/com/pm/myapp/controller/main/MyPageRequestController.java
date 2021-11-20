package com.pm.myapp.controller.main;


import com.pm.myapp.aws.AwsUpload;
import com.pm.myapp.service.main.ProfileService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Log4j2
@NoArgsConstructor

@RequestMapping("/users/{id}")
@RestController
public class MyPageRequestController {

    @Setter(onMethod_ = @Autowired)
    private ProfileService service;

    @Setter(onMethod_ = @Autowired)
    private AwsUpload awsUpload;

    // 프로필 수정
    @PostMapping("/edit-profile")
    public Map<String, String> editProfile(
            @RequestParam("email") String email,
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


        Map<String, Object> profile = new HashMap<>();

        // 랜덤값 형성 및 aws에 파일 업로드
        UUID uuid = UUID.randomUUID(); // 랜덤값

        if (fileLocation != null) {
            imageUrl = awsUpload.fileUpload(fileLocation, imagePath, uuid);
        }

        profile.put("email", email);
        profile.put("nickname", nickname);
        profile.put("fileLocation", imageUrl); // 파일 이름 주소

        boolean result = this.service.editProfile(profile);
        log.info("\t + result : {}", result);

        Map<String, String> data = new HashMap<>();
        if (!imageUrl.equals("")) {
            data.put("fileLocation", imageUrl);
        }
        data.put("nickname", nickname);

        return data;

    } // editProfile

    // 이메일 수정
    @PostMapping("/editEmail")
    public void editEmail() {
        log.debug("editEmail() invoked.");

    } // editEmail

    // 비밀번호 수정
    @PostMapping("/editPassword")
    public void editPassword() {
        log.debug("editPassword() invoked.");

    } // editPassword

    // 회원 탈퇴
    @PostMapping("/withdrawal")
    public void withdrawal() {
        log.debug("withdrawal() invoked.");

    } // withdrawal

} // end class
