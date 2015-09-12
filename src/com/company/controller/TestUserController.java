package com.company.controller;

import java.util.List;

import com.company.model.TestUser;
import com.jfinal.core.Controller;

public class TestUserController extends Controller {
	public void index() {
		
		renderVelocity("login.html");
	}
	
	public void login() {
		String username= this.getPara("username");
		String password= this.getPara("password");

		List list=TestUser.testUser.find("select * from test_user where username='"+username
				+"' and password='"+password+"'");
		//System.out.println("list:"+list);
		if (list.size()>0) {
			renderText("login successful.");
		}else{
			renderText("login failure.");
		}
	}
}
