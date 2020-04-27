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
		
		
		//��ҳ��ѯ������Ϣ
		/*
		 * ˼·��
		 * 1����ȡҳ����Ҫ��ѯ��ҳ��pageNum
		 * 2��ʹ��pageHelper����ҳ����ȡdb.properties�е�ÿҳ��ʾ������pageSize
		 * 		���������ע��@PropertySource("db.properties")
		 * 		ʹ��@Valueע���ȡֵ
		 * 3������Service������Service�н��е���Dao����ҳ����
		 * 		@Resourceע��Service
		 * 		PageHelper.StartPage(pageNum,pageSize);
		 *		����Dao��ѯ
		 *		new PageInfo(list);
		 * 4��Dao��д��ѯ�ӿڼ�ע��
		 * 5����ѯ��ҳ��--��ѯ������--����
		 */
		
		List<Dept> deptList = deptService.queryAllByPage(pageNum, pageSize, dept);
		model.addAttribute("deptList", deptList);
		
		Map<String, Integer> countMap = deptService.queryTotalPage(pageSize, dept);

		model.addAttribute("countMap", countMap);
		
		model.addAttribute("pageNum", pageNum);
		
		//������ѯ
		/*
		 * �ѷ�ҳ��ѯ�����еĲ��裬�����Ҫ����������ѯ�Ĳ���
		 * ֻ�ڵ���Daoʱ������Ҫ��ѯ�Ĳ����������м���
		 * ��ѯ��ҳ��ʱ��Ҳ��Ҫ���ò�������
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
			model.addAttribute("errorMsg", "���ʧ��");
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
			model.addAttribute("errorMsg", "�޸�ʧ��");
			Dept dept2 = deptService.queryById(dept.getId());
			model.addAttribute("dept", dept2);
			return "dept/deptUpdate";
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
