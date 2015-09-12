package com.company.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Customer extends Model<Customer>{
	public static final Customer customer = new Customer();
	
	
	public Page<Customer> getPage(){
		
		return null;
	}

	

}
