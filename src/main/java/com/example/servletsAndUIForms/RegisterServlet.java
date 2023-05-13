package com.example.servletsAndUIForms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("inside register servlet.");

		if ("checked".equals(req.getParameter("Terms"))) {
			out.println("Name = " + req.getParameter("userName"));
			out.println("Password = " + req.getParameter("userPassword"));
			out.println("MailId = " + req.getParameter("userEmail"));
			out.println("Gender = " + req.getParameter("userGender"));
			out.println("Course = " + req.getParameter("userSelectedCourse"));
			RequestDispatcher rd = req.getRequestDispatcher("successServlet");
			rd.forward(req, resp);
		} else {
			out.println("Please tick the box to accept the terms and conditions");
			RequestDispatcher rd = req.getRequestDispatcher("submitFormDemo.html");
			rd.include(req, resp);
		}

	}
}
