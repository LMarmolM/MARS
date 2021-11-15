package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;



public class NamesServlet extends HttpServlet {

	private static final long serialVersionUID = -4145015159380864088L;
List<User> users = new ArrayList<>();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
	  System.out.println("GET NAMES SERVLET");
    //response.getWriter().println("<ul>");
	  String userJsonString ="[";
	  for (User user : users) {
      //response.getWriter().println("<li>" + user.name + "</li>");
      //response.getWriter().println("<li>" + user.email+ "</li>");
      //response.getWriter().println("<li>" + user.password + "</li>");
      //response.getWriter().println("<li>" + user.phone + "</li>");
		  userJsonString += new Gson().toJson(user)+",";
	      
	      
    }
	  
	  PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      try{
      out.print(userJsonString.substring(0,userJsonString.length()-2)+"}]");
      out.flush();}
      catch (Exception e){
    	  return;
      }
    //response.getWriter().println("</ul>");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
	  User u = new User();
	  System.out.println("POST NAMES SERVLET");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String phone = request.getParameter("number");
    u.name =name;
    u.email=email;
    u.password = password;
    u.phone = phone;
    users.add(u);
    response.sendRedirect("http://localhost:8080/Servlet-2/Names.html");
  }
}