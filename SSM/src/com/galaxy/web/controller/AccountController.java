package com.galaxy.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galaxy.bean.Account;
import com.galaxy.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {
	
	@Resource
	private AccountService accountService;
	
	
	@PostMapping("login")
	public String login(Account account, HttpSession session,Model model) {
		System.out.println(account.getName());
		System.out.println(account.getPassword());
		Account loginAccount = accountService.login(account);
		
		if (loginAccount == null) {
			model.addAttribute("errorMsg", "用户名或密码错误!");
			return "forward:../login.jsp";
		} else {
			session.setAttribute("loginAccount", loginAccount);
			return "redirect:../dept/deptList?pageNum=1";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../login.jsp";
	}

}
