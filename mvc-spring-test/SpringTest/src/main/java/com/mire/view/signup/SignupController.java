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
//@SessionAttributes("signup")
public class SignupController {

//	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
//	public String loginView(@ModelAttribute("signup") SignupVO vo) {
//		System.out.println("화면이동");
//		
//		vo.setNewid("test");
//		vo.setSign_passwd("test123");
//
//		return "login.jsp";
//	}
//	
	// , method = RequestMethod.POST
	@RequestMapping(value = "/login.do")
	public String login(SignupVO vo, SignupDAO signupDAO, HttpSession session) {
		System.out.println("/login.do");
		/*
		 * if(vo.getNewid() == null || vo.getNewid().equals("")) { throw new
		 * IllegalArgumentException(""); }
		 */
		System.out.println("Newid : " + vo.getNewid());

		SignupVO signup = signupDAO.getLogSignuup(vo);
		System.out.println("signup : " + signup);
		if (signup != null) {

			session.setAttribute("userName", signup.getNickname());

			return "mainPage";
		} else {
			System.out.println("login");
			System.out.println("22login");
			return "loginPage";
		}
	}

	@RequestMapping(value = "/loginPage.do")
	public String loginPage(SignupVO vo, SignupDAO signupDAO, HttpSession session) {
		System.out.println("/loginPage.do");
		return "loginPage";
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		System.out.println("/logout.do");
		session.invalidate();
		return "mainPage";
	}

	@RequestMapping(value = "/mainPage.do")
	public String mainPage(HttpSession session) {
		System.out.println("/mainPage.do");
		
		return "mainPage";
	}
}
