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
	public String list(@ModelAttribute("partyCode") Integer partyCode) {
		return "fullcalendar/fullcalendar";
	}//list


	@ResponseBody
	@PostMapping("/calendar/post")
	public Map<String, String> insertCal(
			@RequestBody List<CalendarDTO> calendarDtoList) throws ParseException {
		System.out.println(calendarDtoList.size());

		for (CalendarDTO calendarDto : calendarDtoList) {
			System.out.println(calendarDto);
			Date startDate = formatDate(calendarDto.getStart());
			Date endDate = formatDate(calendarDto.getEnd());
			calendarDto.setStart(startDate);
			calendarDto.setEnd(endDate);

			service.insertCal(calendarDto);
		} //for
		return null;
	} //insertCal

	//GMT 9시간 빼기 메소드
	public Date formatDate(Date date) throws ParseException {
		cal.setTime(date);
		cal.add(Calendar.HOUR, -9);
		String format = timeFormat.format(cal.getTime());
		Date newFormat = timeFormat.parse(format);
		return newFormat;
	} //formatDate

  // 채팅방 입장
	@GetMapping("/partychat")
	public String view_chat(
			HttpServletRequest request,
			HttpServletResponse response,
			Integer partyCode,
			Model model) throws Exception {

		return "/chat/view_chat";
		
	} // view_chat


} //end class

