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

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("/getBoard.do");

		String seq = request.getParameter("seq");
		// 2. DB 연동 처리
		BoardVO_back vo = new BoardVO_back();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAO();
		BoardVO_back board = boardDAO.getBoard(vo);
		// 3. 응답 화면 구성
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		return "getBoard";
		// BoardVO board = (BoardVO)session.getAttribute("board");
	}
}
