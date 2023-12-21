package com.mire.biz.signup;

public class SignupVO {

	private String newid;
	private String nickname;
	private String username;
	private String sign_passwd;
	private String email;
	private String phonenum;
	private String bankname;
	private String bankaccount;
	
	public String getNewid() {
		return newid;
	}
	public void setNewid(String newid) {
		this.newid = newid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSign_passwd() {
		return sign_passwd;
	}
	public void setSign_passwd(String sign_passwd) {
		this.sign_passwd = sign_passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	@Override
	public String toString() {
		return "SignupVO [newid=" + newid + ", nickname=" + nickname + ", username=" + username + ", sign_passwd="
				+ sign_passwd + ", email=" + email + ", phonenum=" + phonenum + ", bankname=" + bankname
				+ ", bankaccount=" + bankaccount + "]";
	}
	
	
	
}
