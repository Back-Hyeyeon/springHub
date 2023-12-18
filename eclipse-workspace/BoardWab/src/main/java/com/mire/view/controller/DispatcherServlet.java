package com.mire.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mire.biz.board.BoardVO;
import com.mire.biz.board.impl.BoardDAO;
import com.mire.biz.user.UserVO;
import com.mire.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process(request, response);
	}

	private void Process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트 정보를 추출한다.
		// http://localhost:8080/biz/login.do=>/login.do 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		request.setCharacterEncoding("utf-8");
		// http://localhost:8080/biz/login.do 창에 써보기
		// System.out.println(path);

		// 2. 추출한 정보를 해당된 처리 컨트롤러로 분기를 해야 한다. ex)login_proc.***

		switch (path) {
		case "/login.do": {
			
		}
			break;
		case "/logout.do":{
			System.out.println("/logout.do");
			// 1. 브라우저와 연결된 세션 객체를 강제 종료한다. 
			HttpSession session = request.getSession();
			session.invalidate();
			// 2. 세션 종료 후, 메인 화면으로 이동힌다. 
			response.sendRedirect("login.jsp");
		}
			break;
		case "/insertBoard.do":{
			System.out.println("/insertBoard.do");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
		}
			break;
		case "/updateBoard.do": {
			System.out.println("/updateBoard.do");
			// 1. 사용자 입력 정보 추출
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
		}
			break;
		case "/deleteBoard.do":{
			System.out.println("/deleteBoard.do");
			//1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq"); 
			//2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq)); 

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo); 
			//3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
		}
			break;
		case "/getBoard.do": {
			System.out.println("/getBoard.do");

			String seq = request.getParameter("seq");
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			// 3. 응답 화면 구성
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			// BoardVO board = (BoardVO)session.getAttribute("board");
		}

			break;
		case "/getBoardList.do": {
			System.out.println("/getBoardList.do");
			// 1. 사용자 입력 정보 추출(검색 기능윤 나중에 구현)
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			// List<BoardVO> boardList = (List)session.getAttribute("boardList");
			response.sendRedirect("getBoardList.jsp");
		}
			break;
		}

		// 3. 화면전환을 해줘야한다.

	}

}
