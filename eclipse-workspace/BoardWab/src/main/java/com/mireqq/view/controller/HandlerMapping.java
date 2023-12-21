package com.mireqq.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.mire.view.board.DeleteBoardController;
import com.mire.view.board.GetBoardController;
import com.mire.view.board.GetBoardListController;
import com.mire.view.board.InsertBoardController;
import com.mire.view.board.UpDateBoardController;
import com.mire.view.user.LogOutController;
import com.mire.view.user.LoginController;


public class HandlerMapping {

	private Map<String, Controller> mappings;

	// 생성자.
	public HandlerMapping() {
		
		mappings = new HashMap<String, Controller>();
		
		
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/updateBoard.do", new UpDateBoardController());
		mappings.put("/logout.do", new LogOutController());
		//. 나머지 만들기 
		
	}

	public Controller getController(String path) {

		return mappings.get(path);
	}
}
