package org.kh.shareware.attendance.controller;

import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.domain.Stats;
import org.kh.shareware.attendance.service.AttendanceService;
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.common.Pagination;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService aService;

	
	// 출근 등록
	@RequestMapping(value = "/attendance/registerAtt.sw", method = RequestMethod.POST)
	public String registerAttendance(HttpServletRequest request, 
				Model model, @ModelAttribute Attendance attendance) {
		HttpSession session = request.getSession();
		session.getAttribute("loginUser");
		Member value = (Member) session.getAttribute("loginUser");
		try{
			if (value != null) {
				attendance.setMemNum(value.getMemberNum()); // 사원번호
				// 지각
				LocalTime now = LocalTime.now();
				int hour = now.getHour();
				int second = now.getSecond();
					// 시 분 초 -> 9, 0, 1 -> 지각
					if(hour >= 9 && second > 0) {
						attendance.setAttStatus("지각");
					}else {
						attendance.setAttStatus("출근");
					}
				int result = aService.registerAttendance(attendance);
				if(result > 0) {
					return "redirect:/attendance/attListViewEmp.sw";
				}else {
					model.addAttribute("msg", "출근 등록 실패!");
					return "common/errorPage";
				}
			}else {
				model.addAttribute("msg", "로그인 실패!");
				return "common/errorPage";
			}
		}catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		
	}
	// 퇴근 등록
		@RequestMapping(value = "/attendance/modifyAtt.sw", method = RequestMethod.POST)
		public String modifyAttendance(HttpServletRequest request, 
					Model model, @ModelAttribute Attendance attendance) {
			HttpSession session = request.getSession();
			session.getAttribute("loginUser");
			Member value = (Member) session.getAttribute("loginUser");
			try {
				if (value != null) {
					attendance.setMemNum(value.getMemberNum()); // 사원번호
					//조퇴
					LocalTime now = LocalTime.now();
					int hour = now.getHour();
					int second = now.getSecond();
						if(hour >= 13 && hour <= 18) {
							attendance.setAttStatus("조퇴");
						}else {
							attendance.setAttStatus("퇴근");
						}
					int result = aService.modifyAttendance(attendance);
					if(result > 0) {
						return "redirect:/attendance/attListViewEmp.sw";
					}else {
						model.addAttribute("msg", "퇴근 등록 실패!");
						return "common/errorPage";
					}
				}else {
					model.addAttribute("msg", "로그인 실패!");
					return "common/errorPage";
				}
			}catch(Exception e) {
				model.addAttribute("msg", e.toString());
				return "common/errorPage";
			}
		}
	
	//출퇴근 리스트
	@RequestMapping(value="/attendance/attListViewEmp.sw", method=RequestMethod.GET)
	public String attListViewEmp(
			Model model
			, HttpSession session
			, @RequestParam(value="page", required=false) Integer page
			, @RequestParam(value="date", required=false) String date) {
		int currentPage = (page != null) ? page : 1;
		Member value = (Member) session.getAttribute("loginUser");
		String memNum = value.getMemberNum();
		int totalCount = aService.getListCount(memNum);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Attendance> aList = aService.printAll(pi, memNum);
		List<Stats> sList = aService.printStats(memNum); //통계
		if(!aList.isEmpty()) {
			model.addAttribute("sList", sList); //통계
			model.addAttribute("aList", aList);
			model.addAttribute("pi", pi);
			model.addAttribute("myCondition", "attendance");
			model.addAttribute("listCondition", "attendance");
		}		
		return "attendance/attListViewEmp";
	}
	

	//날짜 검색 (연도/월)
	@PostMapping("/attendance/searchDate.sw")
	public String searchDate(String date, HttpSession session, Model model) {			
		
		int currentPage = 1;
		Member value = (Member) session.getAttribute("loginUser");
		String memNum = value.getMemberNum()+date;  //A02022-06
		
		int totalCount = aService.getListCount(memNum);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Attendance> aList = aService.printAll(pi, memNum);
		List<Stats> sList = aService.printStats(memNum); //통계
		if(!aList.isEmpty()) {
			model.addAttribute("sList", sList); //통계
			model.addAttribute("aList", aList);
			model.addAttribute("pi", pi);
		}	
		//return "redirect:/attendance/attListViewEmp.sw";
		return "attendance/attListViewEmp";
	}
				
}
