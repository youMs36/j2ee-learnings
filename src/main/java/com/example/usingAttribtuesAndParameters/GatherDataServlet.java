package com.example.usingAttribtuesAndParameters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GatherDataServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String number1 = req.getParameter("Number1");
		String number2 = req.getParameter("Number2");
		int sum = Integer.parseInt(number1) + Integer.parseInt(number2);
		req.setAttribute("sigma", sum);
		req.getRequestDispatcher("operateDataServlet").forward(req, resp);
//		req.getRequestDispatcher("operateDataServlet").include(req, resp);
	}
}
