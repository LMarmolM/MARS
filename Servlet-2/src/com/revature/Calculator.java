package com.revature;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Calculator extends HttpServlet{
	//Reference: https://happycoding.io/tutorials/java-server/post
	
	float sum =0;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("this is GET method of my calculator");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//Style
		out.print("<style>");
		out.print("div{");
			out.print("border: 10px solid orange;");
		out.print("margin:auto;");
		out.print("width: 400px;");
		out.print("height: 240px;");
		out.print("padding:20px;");
		out.print("box-shadow: 5px 5px 8px black;");
		out.print("border-radius:10px;");
		out.print("background-color:orange;"
				+ "  text-align:center;");
		out.print("}");

		out.print("h1{");
				out.print("text-align:center;");
			out.print("color:white;");
			out.print("background-color: #D67229;");
			out.print("}");
			out.print("</style>");
		
		
		//Script
		out.print("<script>");
		out.print("async function getSum() {");
	    out.print("const response = await fetch('http://localhost:8080/Servlet-2/calc');");
	    out.print("const nameListHtml = await response.text();");
	    out.print("document.getElementById('result').innerHTML += nameListHtml;");
	    out.print("}");
	    out.print("</script>");
		//Body
		out.print("<h1> Welcome to the sample, server-side calculator</h1>");
		out.print("<div>"
				+ "<h2>Enter numbers here</h2>");
		out.print("<form method=\"post\" action=\"http://localhost:8080/Servlet-2/calc\">");
		out.print("<span>Enter first number:</span>");
		out.print("<br>");
		out.print("<input name=\"one\" type=\"number\"></input>");
		out.print("<br>");
		out.print("<span>Enter second number:</span>");
		out.print("<br>");
		out.print("<input name = \"two\" type=\"number\"></input>");
		out.print("<br>");
		out.print("<input type=\"submit\"  ></input>");
		out.print("</form>");
		out.print("<span name = \"result\">Result:"+sum+" </span>");
		out.print("</div>");
		out.print(new Date().toString());
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("this is post method of my servlet");
		response.setContentType("text/html");
		float x = Float.parseFloat(request.getParameter("one"));
		float y = Float.parseFloat(request.getParameter("two"));
		PrintWriter out = response.getWriter();
		sum = x+y;
		response.sendRedirect("http://localhost:8080/Servlet-2/calc");
		//out.print("<h1>Post Method called</h1>");
		//out.print("n1:"+x+"\tn2:"+y+"\tSum:"+(x+y)+"<br>");
		//out.print(new Date().toString());
	}

}
