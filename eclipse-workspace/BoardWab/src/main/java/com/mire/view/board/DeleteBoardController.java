package com.mire.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mire.biz.board.BoardVO_back;
import com.mire.biz.board.impl.BoardDAO;
import com.mire.biz.user.UserVO;
import com.mire.biz.user.impl.UserDAO;
import com.mireqq.view.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("/deleteBoard.do");
		//1. 사용자 입력 정보 추출
		String seq = request.getParameter("seq"); 
		//2. DB 연동 처리
		BoardVO_back vo = new BoardVO_back();
		vo.setSeq(Integer.parseInt(seq)); 

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo); 
		//3. 화면 네비게이션
		return "getBoardList.do";
	}
}
