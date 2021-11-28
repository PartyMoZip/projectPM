package com.pm.myapp.controller.partyfm;


import com.pm.myapp.domain.CalendarDTO;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pm.myapp.service.partyfm.PartyFuncService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Log4j2
@NoArgsConstructor

@RequestMapping("/partyfunc")
@Controller
public class PartyFuncController {
	
	@Setter(onMethod_= {@Autowired})
	private PartyFuncService service;


	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
	Calendar cal = Calendar.getInstance();

	@GetMapping("/calendar")
	public String view(Integer partyCode , Model model) {
		System.out.println("partyCode = " + partyCode);
		model.addAttribute("partyCode", partyCode);

		return "fullcalendar/fullcalendar";
	}

	@GetMapping("/calendar/data")
	@ResponseBody
	public List<CalendarDTO> list() {
		List<CalendarDTO> list = service.calendarList(); //잭슨바이딩이 List만들때 get이라는 키워드를 json 형태로 만들어줌
		System.out.println("list.size() = " + list.size());
		return list;
	}

	@DeleteMapping("/calendar/data")
	@ResponseBody
	public Boolean delete(@RequestBody CalendarDTO calendarDto) {
		System.out.println(calendarDto);
		int result = service.deleteCalendar(calendarDto.getId());
		return result == 1;
	}

	@ResponseBody
	@PostMapping("/calendar/post")
	public Map<String, String> insertCal(
			@RequestBody List<CalendarDTO> calendarDtoList) throws ParseException {
		System.out.println("calendarDtoList.size()");
		for (CalendarDTO calendarDto : calendarDtoList) {
			System.out.println(calendarDto);
			service.insertCal(calendarDto);
		}
		return null;
	}

	// 채팅방 입장
	@GetMapping("/partychat")
	public String view_chat(
			HttpServletRequest request,
			HttpServletResponse response,
			Integer partyCode,
			Model model) throws Exception {

		System.out.println("들어옴");
		return "/chat/view_chat";

	} // view_chat


} //end class

