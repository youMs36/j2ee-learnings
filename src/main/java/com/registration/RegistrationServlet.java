package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("firstName");
		String password = req.getParameter("password");
		String emailId = req.getParameter("email_id");
		PrintWriter out = resp.getWriter();
//		out.println(name);
//		out.println(password);
//		out.println(emailId);
		
		/// open connection
		try {
			Thread.sleep(3000);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/firstdb", "root", "India@123");
			/// query
			String query = "INSERT INTO tb_users (name, password, emailId) values (?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, emailId);
			preparedStatement.executeUpdate();
			out.println("done");
		} catch (Exception e) {
			out.println("Error.....");
		}
	}
}
