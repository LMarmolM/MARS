package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	//USE POSTMAN TO GET THIS REQUEST, OTHERWISE
	//YOU CANNOT OBTAIN THE RESPONSE
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome to Register Servlet<h1>");
		
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		
		out.println("Hello "+ name+ ", my email is "+ email);
	}

}