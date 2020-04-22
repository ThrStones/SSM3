package com.galaxy.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galaxy.bean.TestBean;
import com.galaxy.service.TestBeanService;

@Controller
@RequestMapping("testBean")
@PropertySource("classpath:db.properties")
public class TestBeanController {

	@Resource
	private TestBeanService testBeanService;
	
	@Value("${mybatis.pageHelper.size}")
	int pageSize;

	@GetMapping("insertPage")
	public String insertPage() {
		return "insert";
	}

	@PostMapping("insert")
	public String insert(TestBean testBean) {
		testBeanService.insert(testBean);
		return "redirect:queryAllByPage?pageNum=1";
	}

	@GetMapping("delete")
	public String delete(int id) {
		testBeanService.delete(id);
		return "redirect:queryAllByPage?pageNum=1";
	}

	@PostMapping("update")
	public String update(TestBean testBean) {
		testBeanService.update(testBean);
		return "redirect:queryAllByPage?pageNum=1";
	}

	@GetMapping("queryById")
	public String queryById(int id, Model model) {
		TestBean testBean = testBeanService.queryById(id);
		model.addAttribute("testBean", testBean);
		return "update";
	}
	
	
	@GetMapping("queryAllByPage")
	public String queryAllByPage(int pageNum, Model model) {
		List<TestBean> testBeanList = testBeanService.queryAllByPage(pageNum, pageSize);
		int totalPage = testBeanService.queryTotalPage(pageSize);
		model.addAttribute("testBeanList", testBeanList);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalPage);
		return "list";
	}
	
	
	
	
	
	
	
	
	

}
