package com.company.demo;

import com.company.controller.CustomerController;
import com.company.controller.HelloController;
import com.company.controller.TestController;
import com.company.controller.TestUserController;
import com.company.model.Customer;
import com.company.model.TestUser;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants arg0) {
		//加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("dbconfig.txt");
		
		arg0.setDevMode(true);// 运行在开发模式
		arg0.setViewType(ViewType.VELOCITY);//使用 Velocity模版引擎
		arg0.setBaseViewPath("/WEB-INF/page"); //可以配置全部模板的基础路径
	}

	@Override
	public void configHandler(Handlers arg0) {
		
		
	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		
		
	}

	@Override
	public void configPlugin(Plugins arg0) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin=new C3p0Plugin(PropKit.get("jdbcUrl"),
				PropKit.get("user"),PropKit.get("password").trim());
		arg0.add(c3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp=new ActiveRecordPlugin(c3p0Plugin);
		arg0.add(arp);
		arp.addMapping("customer", Customer.class);
		arp.addMapping("test_user", TestUser.class);
	}

	@Override
	public void configRoute(Routes arg0) {
		
		arg0.add("/hello",HelloController.class);
		arg0.add("/test",TestController.class);
		arg0.add("/customer",CustomerController.class);
		arg0.add("/testuser",TestUserController.class);
	}
	
}
