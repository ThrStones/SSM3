package com.galaxy.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.galaxy.bean.Meeting;
import com.galaxy.service.MeetingService;

@Controller
@RequestMapping("meeting")
public class MeetingController extends BaseController {

	@Resource
	private MeetingService meetingService;

	@GetMapping("meetingList")
	public String meetingList(int pageNum, Meeting meeting, Model model) {
		List<Meeting> meetingList = meetingService.queryAllByPage(pageNum, pageSize, meeting);
		model.addAttribute("meetingList", meetingList);
		Map<String, Integer> countMap = meetingService.queryTotalPage(pageSize, meeting);
		model.addAttribute("countMap", countMap);
		model.addAttribute("pageNum", pageNum);
		return "meeting/meetingList";
	}

	@GetMapping("insertPage")
	public String insertPage() {
		return "meeting/meetingInsert";
	}

	@PostMapping("insert")
	public String insert(Meeting meeting, Model model,HttpSession session) {
		//方法一：在后台获取session中的值
//		Account loginAccount = (Account) session.getAttribute("loginAccount");
//		meeting.setEmpId(loginAccount.getId());
		//方法二：在页面获取session中的值，并提交到后台
		//<input type="hidden" name="empId" value="${ sessionScope.loginAccount.id }">
		meetingService.insert(meeting);

		if (meeting.getId() > 0) {
			// success
			return "redirect:meetingList?pageNum=1";
		} else {
			// fail
			model.addAttribute("errorMsg", "添加失败");
			model.addAttribute("meeting", meeting);
			return "meeting/meetingInsert";
		}
	}

	@PostMapping("delete")
	public String delete(int[] ids) {
		meetingService.delete(ids,"meeting");
		return "redirect:meetingList?pageNum=1";
	}

	@GetMapping("queryById")
	public String queryById(@RequestParam("ids") int id, Model model) {
		Meeting meeting = meetingService.queryById(id);
		model.addAttribute("meeting", meeting);
		return "meeting/meetingUpdate";
	}

	@PostMapping("update")
	public String update(Meeting meeting, Model model) {
		int count = meetingService.update(meeting);
		if (count > 0) {
			// success
			return "redirect:meetingList?pageNum=1";
		} else {
			// fail
			model.addAttribute("errorMsg", "修改失败");
			Meeting meeting2 = meetingService.queryById(meeting.getId());
			model.addAttribute("meeting", meeting2);
			return "meeting/meetingUpdate";
		}
	}

}
