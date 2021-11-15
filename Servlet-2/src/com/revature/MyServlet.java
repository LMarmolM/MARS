package com.revature;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet{

	ServletConfig config;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		System.out.println("Servlet initialized");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("config asked");
		return this.config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servicing");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	System.out.println("Destruction initiated");	
	}


	@Override
	public String getServletInfo() {
	
		return "Servlet created by admin";
	}


	
}
