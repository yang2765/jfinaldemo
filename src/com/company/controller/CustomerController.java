package com.company.controller;

import java.util.List;

import com.company.model.Customer;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class CustomerController extends Controller{
	
	public void index(){
		setAttr("customer", Customer.customer.findById(2));
		
		
		renderVelocity("customer.html");
	}
	
	public void listAll() {
		List list=Customer.customer.find("select * from customer");
		
		renderJson(list);
	}
	
	public void test() {
		//new Customer().set("name", "Jolululu").;
		
		Customer.customer.findById(7).set("name", "Helen kale").update();
		
		renderJson(Customer.customer.find("select count(*) from customer"));
	}
	
	
	public void test2() {
		Record userRecord=new Record().set("name", "wan fen");
		Db.save("customer", userRecord);
		
		renderJson(Customer.customer.find("select * from customer"));
	}
	
}	
