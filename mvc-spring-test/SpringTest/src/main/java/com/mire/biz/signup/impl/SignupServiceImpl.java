package com.mire.biz.signup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mire.biz.signup.SignupService;
import com.mire.biz.signup.SignupVO;

@Service("signupService")
public class SignupServiceImpl implements SignupService {

	@Autowired
	public SignupDAO signupDAO;
	
	@Override
	public void insertSignuup(SignupVO vo) {
		// TODO Auto-generated method stub
		signupDAO.insertSignuup(vo);
	}

	@Override
	public void updateSignuup(SignupVO vo) {
		// TODO Auto-generated method stub
		signupDAO.updateSignuup(vo);
	}

	@Override
	public void deleteSignuup(SignupVO vo) {
		// TODO Auto-generated method stub
		signupDAO.deleteSignuup(vo);
	}

	@Override
	public void getLogSignuup(SignupVO vo) {
		// TODO Auto-generated method stub
		signupDAO.getLogSignuup(vo);
	}

	@Override
	public SignupVO getSignuup(SignupVO vo) {
		// TODO Auto-generated method stub
		return signupDAO.getSignuup(vo);
	}

}
