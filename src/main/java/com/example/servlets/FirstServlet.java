package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet{

	ServletConfig servletConfig;
	
	@Override
	public void destroy() 
	{
		System.out.println("                            destroying servlet object%%");
	}

	@Override
	public ServletConfig getServletConfig() 
	{
		
		return servletConfig;
	}

	@Override
	public String getServletInfo() 
	{
		
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException 
	{
		this.servletConfig = arg0;
		System.out.println("Creating object.............");
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("      servicig -------------");
		//set The content type.
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
//		writer.println("<h1> **** output from servlet serviceMethod<\h1>");
		writer.println("<h3> Todays Date and time"+new Date().toString());
		
		
		
	}

}
