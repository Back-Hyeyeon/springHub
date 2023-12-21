package com.mire.view.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mire.biz.signup.SignupService;

@Controller
@SessionAttributes("signup")
public class SignupController {
	@Autowired
	private SignupService signupService;
	
	
}
