package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.Bean.LoginBean;
import com.util.DBVars;

public class LoginDAO implements DBVars{
	
	private Connection con_ = null;
	private ResultSet rs_ = null;
	private PreparedStatement ps_ = null;

	public LoginDAO(){
		try {
			Class.forName(driver);
			con_ = DriverManager.getConnection(dburl, dbuname, dbpass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//user validation
	public String validateUser(LoginBean bean) 
	{
		//set value from client browser
		String uName = bean.getUName();
		String pWord = bean.getPWord();
		System.out.println("input from brower:" + uName + " " + pWord);
		
		//prepare variables for DB data for validation process
		int uidR;
		String unameR ="";
		String passR = "";
		String uroleR="";
		
		
		try {
			//create sql statement for fetching data from mySQL
			String sql = "SELECT * FROM userlist";
	    	ps_ = con_.prepareStatement(sql);
	
			 // set username and password from login.jsp to sql statement
	        //ps_.setString(1, uName);
	        //ps_.setString(2, pWord);
	        
	        //execute sql statement
	        rs_ = ps_.executeQuery();
			
			//set user credential fetched from DB
			while(rs_.next()) 
			{
				uidR = rs_.getInt(1);
				unameR = rs_.getString(2); 
				passR =rs_.getString(3);
				uroleR = rs_.getString(4);
				System.out.println("while loop:" + unameR+" "+passR);
				
				if(uName.equals(unameR) && pWord.equals(passR) && uroleR.equals("admin")) 
				{return "Admin_role";}
				else if(uName.equals(unameR) && pWord.equals(passR) && uroleR.equals("user")) 
				{return "User_role";}
				else if (uName.equals(unameR) && pWord.equals(passR))
				{return "User_role";}
			}	 
			
		}catch(SQLException se) {se.printStackTrace();}
		return "invalid user. Try again";
		
		}
	
	public void close() {
		if (rs_ != null) {
	        try {rs_.close();} catch (SQLException se) { se.printStackTrace();}
	    }
	    if (ps_ != null) {
	        try {ps_.close();} catch (SQLException se) {se.printStackTrace();}
	    }
	    if (con_ != null) {
	        try {con_.close();} catch (SQLException se) {se.printStackTrace();}
	    }
	}
}
