package com.example.sessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTwo
 */
@WebServlet("/ServletTwo")
public class ServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTwo() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String name = req.getParameter("name");
		System.out.println("name = "+name);
		PrintWriter out = resp.getWriter();
//		out.println("Hello "+ name + " welcome <b>back</b> to my website..........");
		
		Cookie[] cookieArray = req.getCookies();
		if(null == cookieArray)
		{
			out.println("New User!! handling. ");
		}
		for(Cookie ck : cookieArray)
		{
			if("user_name".equals(ck.getName()))
			{
				name=ck.getValue();
				out.println("Hello "+ name + " welcome <b>back</b> to my website..........");
			}
		}
	}
    


}
