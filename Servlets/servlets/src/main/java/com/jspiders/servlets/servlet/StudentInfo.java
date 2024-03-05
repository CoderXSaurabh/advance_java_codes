package com.jspiders.servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentInfo  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		int age=Integer.parseInt(req.getParameter("age"));
		String[] course=req.getParameterValues("Course");
		
		
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.println("Id: "+id +"<br>");
		writer.println("Name: "+id +"<br>");
		writer.println("Email: "+id +"<br>");
		writer.println("Mobile: "+id +"<br>");
		writer.println("Age: "+id +"<br>");
		writer.println("Course: "+id +"<br>");
		for (int i = 0; i < course.length; i++) {
			writer.println(course[i]+"<br>");
			
		}
		
	}
	
	
	

}
