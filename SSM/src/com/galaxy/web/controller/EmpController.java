package com.galaxy.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galaxy.bean.Emp;
import com.galaxy.service.EmpService;

@Controller
@RequestMapping("emp")
public class EmpController extends BaseController {

	@Resource
	private EmpService empService;

	@GetMapping("empList")
	public String queryAllByPage(int pageNum, Emp emp, Model model) {
		List<Emp> empList = empService.queryAllByPage(emp, pageNum, pageSize);
		Map<String, Integer> countMap = empService.queryTotalPage(emp, pageNum, pageSize);
		model.addAttribute("empList", empList);
		model.addAttribute("countMap", countMap);
		model.addAttribute("pageNum", pageNum);
		return "emp/empList";
	}

	@PostMapping("delete")
	public String delete(int[] ids) {
		empService.delete(ids);
		return "redirect:empList?pageNum=1";
	}

}
