package com.galaxy.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.galaxy.bean.Dept;
import com.galaxy.service.DeptService;
import com.galaxy.service.impl.DeptServiceImpl;

@Controller
@RequestMapping("dept")
@PropertySource("classpath:db.properties")
public class DeptController {
	
	@Value("${mybatis.pageHelper.size}")
	int pageSize;
	
	@Resource
	private DeptService deptService;
	
	@GetMapping("deptList")
	public String deptList(int pageNum,Dept dept,Model model) {
		
		
		//分页查询部门信息
		/*
		 * 思路：
		 * 1、获取页面需要查询的页码pageNum
		 * 2、使用pageHelper来分页，读取db.properties中的每页显示的条数pageSize
		 * 		在类上添加注解@PropertySource("db.properties")
		 * 		使用@Value注解获取值
		 * 3、调用Service，并在Service中进行调用Dao及分页操作
		 * 		@Resource注入Service
		 * 		PageHelper.StartPage(pageNum,pageSize);
		 *		调用Dao查询
		 *		new PageInfo(list);
		 * 4、Dao编写查询接口及注解
		 * 5、查询总页数--查询总条数--计算
		 */
		
		List<Dept> deptList = deptService.queryAllByPage(pageNum, pageSize, dept);
		model.addAttribute("deptList", deptList);
		
		Map<String, Integer> countMap = deptService.queryTotalPage(pageSize, dept);

		model.addAttribute("countMap", countMap);
		
		model.addAttribute("pageNum", pageNum);
		
		//条件查询
		/*
		 * 把分页查询的所有的步骤，添加需要进行条件查询的参数
		 * 只在调用Dao时，讲需要查询的参数加入其中即可
		 * 查询总页数时，也需要讲该参数传入
		 */
		
		
		return "dept/deptList";
	}
	
	@GetMapping("insertPage")
	public String insertPage() {
		return "dept/deptInsert";
	}
	
	@PostMapping("insert")
	public String insert(Dept dept,Model model) {
		deptService.insert(dept);
		
		if (dept.getId()>0) {
			//success
			return "redirect:deptList?pageNum=1";
		} else {
			//fail
			model.addAttribute("errorMsg", "添加失败");
			model.addAttribute("dept", dept);
			return "dept/deptInsert";
		}
	}
	
	@PostMapping("delete")
	public String delete(int[] ids) {
		deptService.delete(ids,"dept");
		return "redirect:deptList?pageNum=1";
	}
	
	@GetMapping("queryById")
	public String queryById(@RequestParam("ids") int id,Model model) {
		Dept dept = deptService.queryById(id);
		model.addAttribute("dept", dept);
		return "dept/deptUpdate";
	}
	
	@PostMapping("update")
	public String update(Dept dept,Model model) {
		int count = deptService.update(dept);
		if (count>0) {
			//success
			return "redirect:deptList?pageNum=1";
		} else {
			//fail
			model.addAttribute("errorMsg", "修改失败");
			Dept dept2 = deptService.queryById(dept.getId());
			model.addAttribute("dept", dept2);
			return "dept/deptUpdate";
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
