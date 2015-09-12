package com.company.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
	
	public void index() { 
	    renderText("Hello JFinal World."); 
	}
	
	
	public void login() {
		
		renderVelocity("login.html");
	}
}
