package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("inside second servlet service method");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h2>This is second servlet execution...");

	}

}
