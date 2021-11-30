package com.pm.myapp.controller.board;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pm.myapp.aws.AwsUpload;
import com.pm.myapp.controller.join.LoginController;
import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PageDTO;
import com.pm.myapp.domain.ReplyCriteria;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.domain.board.BoardSearchListDTO;
import com.pm.myapp.domain.board.HeartDTO;
import com.pm.myapp.domain.board.PartyPhotoDTO;
import com.pm.myapp.domain.board.PartyPhotoReDTO;
import com.pm.myapp.service.board.PartyPhotoService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Log4j2
@NoArgsConstructor

@RequestMapping("/partyphoto")
@Controller
public class PartyPhotoController {

    @Setter(onMethod_ = {@Autowired})
    private PartyPhotoService service;

    @Setter(onMethod_ = {@Autowired})
    private AwsUpload awsUpload;

    // 포토 갤러리 목록 - 검색 포함
    @GetMapping("/list")
    public void getPhotoBoardList(
            @ModelAttribute("ldto") BoardSearchListDTO ldto,
            @ModelAttribute("cri") Criteria cri,
            Model model) {
        Integer partyCode = ldto.getPartyCode();
        String searchWord = ldto.getSearchWord();
        Integer option = ldto.getOption();

        log.debug("getPhotoBoardList({}, {}, {}, {}) invoked.", partyCode, searchWord, option, cri);

        // 포토 갤러리는 페이지당 글이 9개
        cri.setAmount(9);

        // 글 목록 불러오기
        List<PartyPhotoDTO> list = this.service.getPartyPhotoList(partyCode, searchWord, option, cri);
        log.info("\t+ list : {}", list);
        model.addAttribute("__LIST__", list);

        // 총 게시물 수 구하기
        Integer totalAmount = this.service.getTotalPartyPhotoList(partyCode, searchWord, option);
        log.info("\t+ totalAmount : {}", totalAmount);

        // 글 페이지네이션 처리
        PageDTO pageDTO = new PageDTO(cri, totalAmount);
        model.addAttribute("pageMaker", pageDTO);

        // 파티 코드 강제 주입
        model.addAttribute("partyCode", partyCode);

    } // getPhotoBoardList

    // 포토 갤러리 상세보기
    @GetMapping("/detail")
    public void getPhotoBoardDetail(
            HttpServletRequest req,
            @ModelAttribute("ldto") BoardSearchListDTO ldto,
            @ModelAttribute("prefer") Integer prefer,
            @ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            Model model) {
        Integer partyCode = ldto.getPartyCode();

        log.debug("getPhotoBoardDetail({}, {}, {}, {}) invoked.", partyCode, prefer, cri, recri);

        // 읽기번호 증가
        boolean readOk = this.service.readPhotoBoard(prefer, partyCode);
        if (readOk) {
            log.info("{}번 파티 포토게시판 {}번 글 읽기 성공", partyCode, prefer);
        } // if

        // 갤러리 글 상세내용 불러오기
        PartyPhotoDTO detail = this.service.getPhotoBoardDetail(prefer, partyCode);
        log.info("\t+ detail : {}", detail);
        model.addAttribute("__DETAIL__", detail);

        // 갤러리 사진 불러오기
        List<String> photo = this.service.getPhotoAddress(prefer, partyCode);
        log.info("\t+ photo : {}", photo);
        model.addAttribute("__PHOTO__", photo);

        // 댓글 목록 불러오기
        List<PartyPhotoReDTO> replyList = this.service.getPhotoReplyList(prefer, partyCode, recri);
        log.info("\t+ replyList : {}", replyList);
        model.addAttribute("__COMMENT__", replyList);

        // 총 댓글 개수 구하기
        Integer totalAmount = this.service.getTotalPhotoReplyList(prefer, partyCode);
        log.info("\t+ totalAmount : {}", totalAmount);

        // 댓글 페이지네이션 처리
        PageDTO pageDTO = new PageDTO(recri, totalAmount);
        model.addAttribute("replyPageMaker", pageDTO);

        // 로그인한 유저의 이메일 불러오기
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO) session.getAttribute(LoginController.authKey);
        String email = user.getEmail();

        // 내 좋아요 불러오기
        // 로그인 중이라면 좋아요 눌렀는지 아닌지 표시
        // 아니라면 아닌체로 표시
        if (email != null) {
            Integer myHeart = this.service.getMyPartyPhotoHeart(prefer, partyCode, email);
            log.info("\t+ myHeart : {}", myHeart);
            model.addAttribute("__MYHEART__", myHeart);
        } else {
            model.addAttribute("__MYHEART__", 0);
        } // if-else

        // 총 좋아요 개수 불러오기
        Integer totalHeart = this.service.getTotalPartyPhotoHeart(prefer, partyCode);
        log.info("\t+ totalHeart : {}", totalHeart);
        model.addAttribute("__TOTALHEART__", totalHeart);

        // 파티 코드 강제 주입
        model.addAttribute("partyCode", partyCode);

    } // getPhotoBoardDetail

    // 포토 갤러리 작성 - view
    @GetMapping("/writeview")
    public void writePhotoBoardView(
            @ModelAttribute("ldto") BoardSearchListDTO ldto,
            @ModelAttribute("cri") Criteria cri,
            Model model
    ) {
        log.debug("writePhotoBoardView() invoked.");
        Integer partyCode = ldto.getPartyCode();
        // 파티 코드 강제 주입
        model.addAttribute("partyCode", partyCode);

    } // writePhotoBoardView

    // 포토 갤러리 작성
    @PostMapping("/write")
    public String writePhotoBoard(
            @ModelAttribute("cri") Criteria cri,
            PartyPhotoDTO dto,
            MultipartFile[] images,
            RedirectAttributes rtts
    ) throws IOException {
        log.debug("writePhotoBoard({}) invoked.", dto);

        // 글 내용 업로드
        Integer newRefer = this.service.writePartyPhoto(dto);
        log.info("\t+ newRefer : {}", newRefer);

        int partyCode = dto.getPartycode();

        // 사진 업로드
        // 파티코드와 날짜 합쳐서 새로운 폴더 준비
        String imagePath = "image/photogallery/" + partyCode + "/" + newRefer + "/";
        log.debug("\t+ imagePath : {}", imagePath);

        for (MultipartFile image : images) {

            String originalName = image.getOriginalFilename(); // 파일의 원래 이름
            if (originalName != "" && originalName != null) {

                // 랜덤값 형성 및 aws에 파일 업로드
                UUID uuid = UUID.randomUUID(); // 랜덤값
                String imageUrl = awsUpload.fileUpload(image, imagePath, uuid);
                log.info("\t+ imageUrl : {}", imageUrl);


                String newName = uuid + "_" + image.getOriginalFilename();

                // DB에 이미지 정보 저장하기					// HashMap을 이용하여 DTO 처럼 사용할 예정
                // Mapper.xml 에 갔을 때 key를 입력하면 value 값이 들어감
                // value의 타입이 object인건 value의 타입이 모두 같은것이 아니기 때문
                Map<String, Object> imageInfo = new HashMap<String, Object>();
                imageInfo.put("oldFilename", originalName); // 기존 파일 이름
                imageInfo.put("newFilename", newName); // 새로운 파일 이름
                imageInfo.put("fileLocation", imageUrl); // 파일 이름 주소					imageInfo.put("partyCode", partyCode);
                imageInfo.put("prefer", newRefer);
                imageInfo.put("partyCode", partyCode);

                boolean result = this.service.registerImages(imageInfo);
                log.info("\t + result : {}", result);

            } // if

        } // for


        rtts.addAttribute("partyCode", partyCode);

        return "redirect:/partyphoto/list";

    } // writePhotoBoard

    // 포토 갤러리 수정 - view
    @GetMapping("/editview")
    public void editPhotoBoardView(
            @ModelAttribute("ldto") BoardSearchListDTO ldto,
            @ModelAttribute("prefer") Integer prefer,
            @ModelAttribute("cri") Criteria cri,
            Model model
    ) {
        Integer partyCode = ldto.getPartyCode();
        log.debug("editPhotoBoardView({}, {}) invoked.", ldto, prefer);

        // 갤러리 글 상세내용 불러오기
        PartyPhotoDTO detail = this.service.getPhotoBoardDetail(prefer, partyCode);
        log.info("\t+ detail : {}", detail);
        model.addAttribute("__DETAIL__", detail);

        // 갤러리 사진 불러오기
        List<String> photo = this.service.getPhotoAddress(prefer, partyCode);
        log.info("\t+ photo : {}", photo);
        model.addAttribute("__PHOTO__", photo);

        // 파티 코드 강제 주입
        model.addAttribute("partyCode", partyCode);

    } // editPhotoBoardView

    // 포토 갤러리 수정
    @PostMapping("/edit")
    public String editPhotoBoard(
            @ModelAttribute("cri") Criteria cri,
            PartyPhotoDTO dto,
            MultipartFile[] images,
            String[] deleteFileLocations,
            RedirectAttributes rttrs
    ) throws IOException {
        log.debug("editPhotoBoard({}) invoked.", images.toString());

        // 글 내용 업로드
        boolean resultNum = this.service.modifyPartyPhoto(dto);
        log.info("\t+ resultNum : {}", resultNum);

        int partyCode = dto.getPartycode();
        int prefer = dto.getPrefer();
		
		/*
		 
		 1. 게시판 상세보기
		 2. 수정
		 3. 내용 불러오기
		 4. 삭제할 사진 눌러서 삭제
		 
		 기존의 것들과 확인이 불가능
		 
		 ( 기존에 있는 것들 : 주소만 가지고 있음 >> 삭제 or 유지 
		 ( 새로 등록할 사진 : 파일 )
		 
		 */

        // 삭제할 그림 목록 가져오기
        if (deleteFileLocations != null) {

            // 1. 해당 경로 데이터베이스에서 삭제
            for (String file : deleteFileLocations) {

                boolean deleteResult = this.service.deleteImages(file);
                log.info("\t+ deleteResult : {}", deleteResult);

            } // for

            // 2. aws 에서 그림 완전 삭제
            awsUpload.deleteFiles(deleteFileLocations);

        } // if

        // 새로운 이미지 등록
        // 사진 업로드
        // 파티코드와 날짜 합쳐서 새로운 폴더 준비
        String imagePath = "image/photogallery/" + partyCode + "/" + dto.getPrefer() + "/";
        log.debug("\t+ imagePath : {}", imagePath);

        for (MultipartFile image : images) {
            String originalName = image.getOriginalFilename(); // 파일의 원래 이름

            if (originalName != "" && originalName != null) {

                // 랜덤값 형성 및 aws에 파일 업로드
                UUID uuid = UUID.randomUUID(); // 랜덤값
                String imageUrl = awsUpload.fileUpload(image, imagePath, uuid);
                log.info("\t+ imageUrl : {}", imageUrl);

                String newName = uuid + "_" + image.getOriginalFilename();

                // DB에 이미지 정보 저장하기
                // HashMap을 이용하여 DTO 처럼 사용할 예정
                // Mapper.xml 에 갔을 때 key를 입력하면 value 값이 들어감
                // value의 타입이 object인건 value의 타입이 모두 같은것이 아니기 때문
                Map<String, Object> imageInfo = new HashMap<String, Object>();
                imageInfo.put("oldFilename", originalName); // 기존 파일 이름
                imageInfo.put("newFilename", newName); // 새로운 파일 이름
                imageInfo.put("fileLocation", imageUrl); // 파일 이름 주소
                imageInfo.put("partyCode", partyCode);
                imageInfo.put("prefer", prefer);

                boolean result = this.service.registerImages(imageInfo);
                log.info("\t + result : {}", result);

            } // if

        } // for


        rttrs.addAttribute("partyCode", partyCode);
        rttrs.addAttribute("prefer", dto.getPrefer());
        rttrs.addAttribute("currPage", cri.getCurrPage());

        return "redirect:/partyphoto/detail";

    } // editPhotoBoard

    // 포토 갤러리 삭제
    @PostMapping("/delete")
    public String deletePhotoBoard(
            Integer prefer,
            Integer partyCode,
            @ModelAttribute("cri") Criteria cri,
            RedirectAttributes rttrs
    ) {
        log.debug("deletePhotoBoard({}, {}) invoked.", prefer, partyCode);

        // 글의 댓글 삭제
        boolean resultDelRe = this.service.deletePartyPhotoReply(prefer, partyCode);
        log.info("\t+ resultDelRe : {}", resultDelRe);

        // 삭제할 그림 목록 가져오기
        List<String> photo = this.service.getPhotoAddress(prefer, partyCode);
        log.info("\t+ photo : {}", photo);

        if (photo.size() != 0) {

            // 1. 해당 경로 데이터베이스에서 삭제
            for (String file : photo) {

                boolean deleteResult = this.service.deleteImages(file);
                log.info("\t+ deleteResult : {}", deleteResult);

            } // for

            // 2. aws 에서 그림 완전 삭제
            // String[] delete = (String[]) photo.toArray();
            // awsUpload.deleteFiles(delete);

        } // if

        // 글 내용 삭제
        boolean resultDel = this.service.deletePartyPhoto(prefer, partyCode);
        log.info("\t+ resultDel : {}", resultDel);

        rttrs.addAttribute("partyCode", partyCode);

        return "redirect:/partyphoto/list";

    } // deletePhotoBoard

    // 포토 갤러리 - 댓글 작성
    @PostMapping("/writecomment")
    public String writeComment(
            Integer prefer,
            Integer partyCode,
            @ModelAttribute("cri") Criteria cri,
            ReplyCriteria recri,
            PartyPhotoReDTO dto,
            RedirectAttributes rttrs
    ) {
        log.debug("writeComment({}, {}, {}, {}, {}) invoked.", prefer, partyCode, cri, recri, dto);

        boolean result = this.service.writePhotoBoardComment(dto);
        log.info("\t+ result : {}", result);

        rttrs.addAttribute("prefer", prefer);
        rttrs.addAttribute("partyCode", partyCode);
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage", recri.getReCurrPage());

        return "redirect:/partyphoto/detail";

    } // writeComment

    // 포토 갤러리 - 댓글 수정
    @PostMapping("/editcomment")
    public String editComment(
            @ModelAttribute("cri") Criteria cri,
            ReplyCriteria recri,
            PartyPhotoReDTO dto,
            RedirectAttributes rttrs
    ) {
        log.debug("editComment({}, {}, {}) invoked.", cri, recri, dto);

        boolean result = this.service.modifyPhotoBoardComment(dto);
        log.info("\t+ result : {}", result);

        rttrs.addAttribute("prefer", dto.getPrefer());
        rttrs.addAttribute("partyCode", dto.getPartyCode());
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage", recri.getReCurrPage());

        return "redirect:/partyphoto/detail";

    } // editComment

    // 포토 갤러리 - 댓글 삭제
    @PostMapping("/deletecomment")
    public String deleteComment(
            PartyPhotoReDTO dto,
            @ModelAttribute("cri") Criteria cri,
            ReplyCriteria recri,
            RedirectAttributes rttrs
    ) {
        log.debug("deleteComment({}, {}, {}) invoked.", dto, cri, recri);

        boolean result = this.service.deletePhotoBoardComment(dto);
        log.info("\t+ result : {}", result);

        rttrs.addAttribute("prefer", dto.getPrefer());
        rttrs.addAttribute("partyCode", dto.getPartyCode());
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage", recri.getReCurrPage());

        return "redirect:/partyphoto/detail";

    } // deleteComment
	
	/*// 포토 갤러리 - 좋아요 기능
	@PostMapping("/heart")
	public String givePhotoHeart(
			HeartDTO hdto,
			@ModelAttribute("cri") Criteria cri,
			@ModelAttribute("recri") ReplyCriteria recri,
			RedirectAttributes rttrs,
			Model model
			) {
		log.debug("givePhotoHeart({}, {})",hdto,cri);
		
		Integer heartCheck = this.service.checkPhotoBoardHeart(hdto);		
		log.info("\t+ heartCheck : {}", heartCheck);
		
		model.addAttribute("__MYHEART__", heartCheck);
		
		// 총 좋아요 개수 불러오기
		Integer totalHeart = this.service.getTotalPartyPhotoHeart(hdto.getPrefer(),hdto.getPartyCode());
		log.info("\t+ totalHeart : {}",totalHeart);
		model.addAttribute("__TOTALHEART__", totalHeart);
		
		rttrs.addAttribute("prefer", hdto.getPrefer());
		rttrs.addAttribute("partyCode", hdto.getPartyCode());
		rttrs.addAttribute("currPage", cri.getCurrPage());
		rttrs.addAttribute("reCurrPage", recri.getReCurrPage());
		
		return "redirect:/partyphoto/detail";
		
	} // givePhotoHeart*/

    // 포토 갤러리 - 좋아요 기능
    @PostMapping(value = "/heart", produces = "application/json; charset=utf8")
    @ResponseBody()
    public Map<String, Object> givePhotoHeart(
            @RequestBody String json
    ) {
        log.debug("json: {}", json);

        // JsonParser parser = new JsonParser();
        // JsonElement element = parser.parse(json);

        JsonElement element = JsonParser.parseString(json);
        log.info("element: {}", element);

        Integer currPage = element.getAsJsonObject().get("currPage").getAsInt();
        Integer reCurrPage = element.getAsJsonObject().get("reCurrPage").getAsInt();
        Integer partyCode = element.getAsJsonObject().get("partyCode").getAsInt();
        Integer prefer = element.getAsJsonObject().get("prefer").getAsInt();
        String email = element.getAsJsonObject().get("email").getAsString();

        HeartDTO dto = new HeartDTO();
        dto.setPrefer(prefer);
        dto.setPartyCode(partyCode);
        dto.setEmail(email);

        Integer heartCheck = this.service.checkPhotoBoardHeart(dto);
        log.info("\t+ heartCheck : {}", heartCheck);

        Integer totalHeart = this.service.getTotalPartyPhotoHeart(prefer, partyCode);
        log.info("\t+ totalHeart : {}", totalHeart);

        Map<String, Object> data = new HashMap<>();
        data.put("prefer", prefer);
        data.put("partyCode", partyCode);
        data.put("currpage", currPage);
        data.put("reCurrPage", reCurrPage);
        data.put("myHeart", heartCheck);
        data.put("totalHeart", totalHeart);
        // // 총 좋아요 개수 불러오기
        // Integer totalHeart = this.service.getTotalPartyPhotoHeart(hdto.getPrefer(),hdto.getPartyCode());
        // log.info("\t+ totalHeart : {}",totalHeart);
        // model.addAttribute("__TOTALHEART__", totalHeart);
        //
        // rttrs.addAttribute("prefer", hdto.getPrefer());
        // rttrs.addAttribute("partyCode", hdto.getPartyCode());
        // rttrs.addAttribute("currPage", cri.getCurrPage());
        // rttrs.addAttribute("reCurrPage", recri.getReCurrPage());

        return data;

    } // givePhotoHeart

} // end class
