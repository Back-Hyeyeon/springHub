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

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("/getBoardList.do");
		// 2. DB 연동 처리
		BoardVO_back vo = new BoardVO_back();
		BoardDAO boardDAO = new BoardDAO();

		List<BoardVO_back> boardList = boardDAO.getBoardList(vo);
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		// 응답화면 구성
		return "getBoardList";
	}
}
