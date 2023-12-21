package com.mire.view.signup;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mire.biz.signup.SignupVO;
import com.mire.biz.signup.impl.SignupDAO;

@Controller
@SessionAttributes("signup")
public class SignupController {
	
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("signup") SignupVO vo) {
		System.out.println("/login.do");
		
		vo.setNewid("test");
		vo.setSign_passwd("test123");

		return "login.jsp";
	}
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(SignupVO vo,SignupDAO signupDAO , HttpSession session) {
		System.out.println("/login.do");
		if(vo.getNewid() == null || vo.getNewid().equals("")) {
			throw new IllegalArgumentException("");
		}
		
		
		SignupVO signup = signupDAO.getLogSignuup(vo);
		if (signup != null) {
			session.setAttribute("userName", signup.getNickname());
			return "redirect:mainPage.do";
		} else {
			System.out.println("login");
			return "login";
		}
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		System.out.println("/logout.do");
		session.invalidate();
		return "redirect:login.do";
	}
}
