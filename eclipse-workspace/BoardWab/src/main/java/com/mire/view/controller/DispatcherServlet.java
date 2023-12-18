package com.mire.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public DispatcherServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		//1.Controller 객체를 만든다., 
		handlerMapping = new HandlerMapping();
		//ViewRwsolver 객체를 만들고 경로를 배정한다.
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
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
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		// http://localhost:8080/biz/login.do 창에 써보기
		
		//2.해당된 Controller 진행한다.(다현성)
		Controller controller = handlerMapping.getController(path);
		
		//3.검색된 controller를 실행해서 문자열을 리턴 받는다.
		String viewName = controller.handleRequest(request, response);
		
		//4. 화면전환을 해줘야한다.
		if(!viewName.contains(".do")) {
			viewName = viewResolver.getView(viewName);
		}
		response.sendRedirect(viewName);
	}
}
