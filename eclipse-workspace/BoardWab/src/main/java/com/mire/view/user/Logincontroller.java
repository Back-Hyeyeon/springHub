package com.mire.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mire.biz.user.UserVO;
import com.mire.biz.user.impl.UserDAO;
import com.mireqq.view.controller.Controller;

public class Logincontroller implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("/login.do");

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DB �뿰�룞 泥섎━
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		// 3. �솕硫� �꽕鍮꾧쾶�씠�뀡
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login";
		}
	}

	
}
