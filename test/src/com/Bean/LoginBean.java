package com.Bean;

public class LoginBean {
	private String uName;
	private String pWord;
	
	public LoginBean(){}
	
	public LoginBean(String uName_, String pass_) 
	{
		this.uName = uName_;
		this.pWord = pass_;
	}
	
	public String getUName() {
		return uName;
	}
	public void setUName(String uName) {
		this.uName = uName;
	}
	public String getPWord() {
		return pWord;
	}
	public void setPWord(String pWord) {
		this.pWord = pWord;
	}
	
	

}
