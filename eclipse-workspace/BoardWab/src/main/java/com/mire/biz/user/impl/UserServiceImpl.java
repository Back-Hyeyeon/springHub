package com.mire.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mire.biz.user.UserService;
import com.mire.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	
	/* 위에 UserDAO를 관리 하는 것이 있어서 set은 안써도됨
	 * public void setUserDAO(UserDAO userDAO) { this.userDAO = userDAO; }
	 */

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
