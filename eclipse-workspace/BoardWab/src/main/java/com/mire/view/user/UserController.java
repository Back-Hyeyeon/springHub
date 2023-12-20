package com.mire.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mire.biz.user.UserVO;
import com.mire.biz.user.impl.UserDAO;

@Controller
public class UserController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("/login.do");
		
		vo.setId("test");
		vo.setPassword("test123");

		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("/login.do");
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디와 비번을 반드시 입력");
		}
		
		
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "redirect:getBoardList.do";
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
