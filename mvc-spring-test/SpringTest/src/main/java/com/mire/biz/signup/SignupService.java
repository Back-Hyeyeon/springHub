package com.mire.biz.signup;

public interface SignupService {

	//회원가입
	void insertSignuup(SignupVO vo);

	//회원정보 수정
	void updateSignuup(SignupVO vo);

	//회원삭제
	void deleteSignuup(SignupVO vo);

	//로그인
	void getLogSignuup(SignupVO vo);

	//회원정보 상세보기
	SignupVO getSignuup(SignupVO vo);

}