package com.galaxy.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galaxy.bean.Dept;
import com.galaxy.bean.Emp;
import com.galaxy.service.DeptService;
import com.galaxy.service.EmpService;

@Controller
@RequestMapping("emp")
public class EmpController extends BaseController {

	@Resource
	private EmpService empService;

	@Resource
	private DeptService deptService;

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

	@GetMapping("insertPage")
	public String insertPage(Model model) {
		// 查询所有的部门，回显到添加页面上
		List<Dept> deptList = queryAllDept();
		model.addAttribute("deptList", deptList);
		return "emp/empInsert";
	}

	@PostMapping("insert")
	public String insert(Emp emp, Model model) {
		empService.insert(emp);
		if (emp.getId() > 0) {
			return "redirect:empList?pageNum=1";
		} else {
			model.addAttribute("errorMsg", "添加失败");
			List<Dept> deptList = queryAllDept();
			model.addAttribute("deptList", deptList);
			return "emp/empInsert";
		}
	}

	@GetMapping("queryById")
	public String queryById(int ids, Model model) {
		Emp emp = empService.queryById(ids);
		model.addAttribute("emp", emp);

		List<Dept> deptList = queryAllDept();
		model.addAttribute("deptList", deptList);
		return "emp/empUpdate";
	}

	@PostMapping("update")
	public String update(Emp emp, Model model) {
		int count = empService.update(emp);
		if (count > 0) {
			return "redirect:empList?pageNum=1";
		} else {
			List<Dept> deptList = queryAllDept();
			model.addAttribute("deptList", deptList);
			model.addAttribute("emp", emp);
			return "emp/empUpdate";
		}
	}

	protected List<Dept> queryAllDept() {
		Integer totalCount = deptService.queryTotalPage(pageSize, "").get("totalCount");
		List<Dept> deptList = deptService.queryAllByPage(1, totalCount, "");
		return deptList;
	}

}
