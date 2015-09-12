package com.company.controller;

import com.jfinal.core.Controller;

public class TestController extends Controller {
	public void index() {
		this.renderVelocity("index.html");
	}
	
	public void test(){
		
		this.renderVelocity("test.html");
	}
}
