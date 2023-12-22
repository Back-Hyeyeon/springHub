package com.mire.view.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class DispstcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;   
    private ViewResolver viewResolver;   
	
	
    public DispstcherServlet() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Process(request, response);
	}
	protected void Process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String path =uri.substring(uri.lastIndexOf("/"));
		
		Controller controller = handlerMapping.getController(path);
		
		String viewName = controller.handleRequest(request, response);
		
		if(!viewName.contains(".do")) {
			viewName = viewResolver.getView(viewName);
		}
		response.sendRedirect(viewName);
	}

}
