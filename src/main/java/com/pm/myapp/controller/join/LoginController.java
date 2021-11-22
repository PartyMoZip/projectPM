package com.pm.myapp.controller.join;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.myapp.domain.UserDTO;

import com.pm.myapp.domain.kakao.KakaoTokenDTO;
import com.pm.myapp.domain.kakao.KakaoUserDTO;
import com.pm.myapp.domain.naver.NaverTokenDTO;
import com.pm.myapp.domain.naver.NaverUserDTO;

import com.pm.myapp.service.join.LoginService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.HashMap;


@Log4j2
@NoArgsConstructor

@RequestMapping("/login")
@Controller
public class LoginController {

	//세션 key값
	public static final String authKey = "__AUTH__";

	@Setter(onMethod_= {@Autowired})
	private LoginService loginService;

	private static final String kakoAuthUrl = "https://kauth.kakao.com";
	private static final String kakaoApiKey = "61c59cfc356c37a46e4cd427c03246f7";
	private static final String redirectURI = "http://localhost:8090/login/doLogin";
	private static final String scope = "profile_nickname , profile_image ,account_email";
	private static final String loginUrl = kakoAuthUrl + "/oauth/authorize?client_id=" + kakaoApiKey + "&redirect_uri=" + redirectURI + "&response_type=code" +"&scope="+scope;



	// 로그인 (view)
	@GetMapping("")
	public String showLoginMain() {
		return "/join/join";
	} //showLoginMain


	// 로그인 (view)
	@GetMapping("/loginPage")
	public String showLoginPage() {
		return "redirect:"+loginUrl;
	} //showLoginPage


	// 로그인
	@GetMapping("/doLogin")
	public String  doLogin(@RequestParam(required = false ,name = "code") String code, @RequestParam(required = false, name = "error") String error, Model model) throws Exception {
		log.debug("doLogin() invoked.");

		if (error != null || code == null) {
			System.out.println(error);
		} else {
			KakaoTokenDTO tokenDto = getAccessToken(code); //카카오 서비스에 접근 할 수 있는 토큰을 받아야함
			System.out.println("access_token~ = " + tokenDto.getAccess_token());
			KakaoUserDTO userInfo = getUserInfo(tokenDto.getAccess_token());
			System.out.println("userInfo~ = " + userInfo);

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("email", userInfo.getKakao_account().getEmail()); //카카오로부터 넘어온 이메일
			map.put("nickname", "");
			System.out.println("요청 전");
			UserDTO findUser = loginService.selectUser(map);
			System.out.println("회원있냐?"+findUser);
			if (findUser == null) {

				UserDTO userDto = new UserDTO();
				userDto.setEmail(userInfo.getKakao_account().getEmail());
				userDto.setNickname(userInfo.getKakao_account().getProfile().getNickname());
				userDto.setUserPic(userInfo.getProperties().getProfile_image());
				userDto.setUserBanned(0);
				System.out.println("넘어왓나??" + userDto);


				int result = loginService.insertUser(userDto);
				System.out.println("result = ~~ "+result);
				model.addAttribute(LoginController.authKey , userDto);
			} else {
				model.addAttribute(LoginController.authKey , findUser);
			}
		}
		return "join/loginPost";
	} //doLogin


	// 로그아웃
	@GetMapping("/doLogout")
	public String doLogout(HttpSession session) {
		log.debug("doLogout() invoked.");

		session.invalidate();
		return "redirect:/";
	} // doLogout


	//---------------------------------kakao------------------------------------//
	//토큰얻기(공식같은거!)
	private KakaoTokenDTO getAccessToken(String code) {

		// 1. RestTemple 객체 생성시 필요한 파라미터로 타임아웃같은 설정을 건들수 있음
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(); //라이브러리 가져온거(HTTP커넥션의 대한 타임아웃설정하기 위함!)
		factory.setConnectTimeout(5000); //연결 타임아웃 5초
		factory.setReadTimeout(5000);//응답 타임아웃 5초
		RestTemplate restTemplate = new RestTemplate(factory); //카카오한테 요청하는 객체

		// 2. 토큰 요청 url 만들기
		String reqUrl = "/oauth/token";
		URI tokenUrl = URI.create(kakoAuthUrl + reqUrl);

		// 3. 헤더 객체 생성 하여 Content-type 설정하기 (토큰을 받기 위해 공식문서에서 넣으라고 함!)
		HttpHeaders headers = new HttpHeaders(); //HttpRequest 헤더
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 4. httpBody부분 생성 및 셋팅하기(보통 Map 형태이다)(공식문서에서 지정한 파라미터 값)
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type","authorization_code");
		params.add("client_id",kakaoApiKey);
		params.add("redirect_uri",redirectURI);
		params.add("code", code);

		// 5. HttpHeader , HttpBody를 포함하여 HTTP요청을 하기위해 만든 객체(HttpHeader + HttpBody)
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

		// 6. token api  요청하기 ~~~
		ResponseEntity<String> response = restTemplate.exchange(
				tokenUrl,  //전송 url
				HttpMethod.POST, // 전송방식
				entity, //보낼 파라미터값(ttpHeader + HttpBody)
				String.class  //리턴타입(아무거나) = <제너릭> 일치해야함
		);
		System.out.println(response.getBody()); //json 형태로 값이 넘어옴 (카카오에서 토큰 줌!)

		// 7. 받아온 JSON 형태 결과를 DTO에 매핑시키기
		ObjectMapper mapper = new ObjectMapper(); //json core 라이브러리
		KakaoTokenDTO result = null;
		try {
			result = mapper.readValue(response.getBody(), KakaoTokenDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	} //getAccessToken

	//사용자 정보 얻기 (사용자 정보를 얻기 위해 처음 발급받았던 accessToken을 사용함!)
	public KakaoUserDTO getUserInfo(String accessToken) {

		// 1. RestTemple 객체 생성시 필요한 파라미터로 타임아웃같은 설정을 건들수 있음
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000); //연결 타임아웃 5초
		factory.setReadTimeout(5000);//응답 타임아웃 5초
		RestTemplate restTemplate = new RestTemplate(factory);

		// 2. 사용자 정보 요청 url 만들기   ,https://kapi.kakao.com/v2/user/me
		String reqUrl = "https://kapi.kakao.com/v2/user/me";

		// 3. 헤더 객체 생성 하여 Content-type 설정 및 헤더에 담아보내야할 파라미터인 Authorization 설정하기
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization" , "Bearer " + accessToken); //위에서 발급받은 토큰
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 5. HttpHeader를 담아 HTTP요청을 하기위해 만든 객체
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

		// 6. 사용자 정보 api 요청하기~~
		ResponseEntity<String> response = restTemplate.exchange(
				reqUrl,
				HttpMethod.POST,
				kakaoProfileRequest,
				String.class
		);
		System.out.println(response.getBody());

		// 7. 받아온 JSON 형태 결과를 DTO에 매핑시키기
		ObjectMapper mapper = new ObjectMapper(); //json 데이터를 dto매핑해줌
		KakaoUserDTO userInfo = null;
		try {
			userInfo = mapper.readValue(response.getBody(), KakaoUserDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return userInfo;
	} //getUserInfo



	//------------------------ naver login---------------------------------------//

	private final static String naverApiKey = "IlrTzYWREjyyrc5xTDPi";
	private final static String naverSecret = "qG89IKEeZN";
	private static final String NaverAuthUrl = "https://nid.naver.com";
	private static final String naverRedirectURI = "http://localhost:8090/login/naverDoLogin";
	private static final String naverScope = "profile_nickname , profile_image ,account_email";


	@GetMapping("/naverLoginPage")
	public String showLoginPageNaver() {
		String NaverLoginUrl = NaverAuthUrl + "/oauth2.0/authorize?client_id=" + naverApiKey + "&redirect_uri=" + naverRedirectURI + "&response_type=code";
		return "redirect:"+NaverLoginUrl;
	} //showLoginPageNaver

	// 로그인
	@GetMapping("/naverDoLogin")
	public String  naverDoLogin(@RequestParam(required = false ,name = "code") String code, @RequestParam(required = false, name = "error") String error, Model model) throws Exception {
		log.debug("naverDoLogin() invoked.");

		if (error != null || code == null) {
			System.out.println(error);
		} else {
			NaverTokenDTO naverTokenDto = getNaverAccessToken(code);
			System.out.println("access_token~ = " + naverTokenDto.getAccess_token());
			NaverUserDTO naverUserInfo = getNaverUserInfo(naverTokenDto.getAccess_token());
			System.out.println("naverUserInfo~ = " + naverUserInfo.getResponse().getProfile_image());

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("email", naverUserInfo.getResponse().getEmail());
			map.put("nickname", "");
			System.out.println("요청 전");
			UserDTO findUser = loginService.selectUser(map);
			System.out.println("회원있냐?"+findUser);
			if (findUser == null) {
				UserDTO userDto = new UserDTO();
				int result = loginService.insertUser(userDto);
				System.out.println("result = ~~ "+result);
				model.addAttribute(LoginController.authKey , userDto);
			} else {
				model.addAttribute(LoginController.authKey , findUser);
			} //else
		} //if
		return "join/loginPost";
	} //naverDoLogin

	//---------------------------naver--------------------------------//
	//토큰얻기(공식같은거!)
	private NaverTokenDTO getNaverAccessToken(String code) {
		System.out.println(code);
		// 1. RestTemple 객체 생성시 필요한 파라미터로 타임아웃같은 설정을 건들수 있음
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(); //라이브러리 가져온거(HTTP커넥션의 대한 타임아웃설정하기 위함!)
		factory.setConnectTimeout(5000); //연결 타임아웃 5초
		factory.setReadTimeout(5000);//응답 타임아웃 5초
		RestTemplate restTemplate = new RestTemplate(factory); //네이버한테 요청하는 객체

		// 2. 토큰 요청 url 만들기
		String reqUrl = "/oauth2.0/token";
		URI tokenUrl = URI.create(NaverAuthUrl + reqUrl);

		// 3. 헤더 객체 생성 하여 Content-type 설정하기 (토큰을 받기 위해 공식문서에서 넣으라고 함!)
		HttpHeaders headers = new HttpHeaders(); //HttpRequest 헤더
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 4. httpBody부분 생성 및 셋팅하기(보통 Map 형태이다)(공식문서에서 지정한 파라미터 값)
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type","authorization_code");
		params.add("client_id",naverApiKey);
		params.add("client_secret", naverSecret);
		params.add("code", code);

		// 5. HttpHeader , HttpBody를 포함하여 HTTP요청을 하기위해 만든 객체(HttpHeader + HttpBody)
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

		// 6. token api  요청하기 ~~~
		ResponseEntity<String> response = restTemplate.exchange(
				tokenUrl,  //전송 url
				HttpMethod.POST, // 전송방식
				entity, //보낼 파라미터값(ttpHeader + HttpBody)
				String.class  //리턴타입(아무거나) = <제너릭> 일치해야함
		);
		System.out.println(response.getBody()); //json 형태로 값이 넘어옴 (카카오에서 토큰 줌!)

		// 7. 받아온 JSON 형태 결과를 DTO에 매핑시키기
		ObjectMapper mapper = new ObjectMapper(); //json core 라이브러리
		NaverTokenDTO result = null;
		try {
			result = mapper.readValue(response.getBody(), NaverTokenDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	} //getNaverAccessToken

	//-------------------------------------------------------------//
	//사용자 정보 얻기 (사용자 정보를 얻기 위해 처음 발급받았던 accessToken을 사용함!)
	public NaverUserDTO getNaverUserInfo(String accessToken) {

		// 1. RestTemple 객체 생성시 필요한 파라미터로 타임아웃같은 설정을 건들수 있음
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000); //연결 타임아웃 5초
		factory.setReadTimeout(5000);//응답 타임아웃 5초
		RestTemplate restTemplate = new RestTemplate(factory);

		// 2. 사용자 정보 요청 url 만들기   ,https://kapi.kakao.com/v2/user/me
		String reqUrl = "https://openapi.naver.com/v1/nid/me";

		// 3. 헤더 객체 생성 하여 Content-type 설정 및 헤더에 담아보내야할 파라미터인 Authorization 설정하기
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization" , "Bearer " + accessToken); //위에서 발급받은 토큰
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 5. HttpHeader를 담아 HTTP요청을 하기위해 만든 객체
		HttpEntity<MultiValueMap<String, String>> naverProfileRequest = new HttpEntity<>(headers);

		// 6. 사용자 정보 api 요청하기~~
		ResponseEntity<String> response = restTemplate.exchange(
				reqUrl,
				HttpMethod.POST,
				naverProfileRequest,
				String.class
		);
		System.out.println(response.getBody());

		// 7. 받아온 JSON 형태 결과를 DTO에 매핑시키기
		ObjectMapper mapper = new ObjectMapper(); //json 데이터를 dto매핑해줌
		NaverUserDTO userInfo = null;
		try {
			userInfo = mapper.readValue(response.getBody(), NaverUserDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return userInfo;
	} //getUserInfo
} // end class
