package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserOption extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = (String)request.getParameter("action");
		if(option.equals("signout"))
		{
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("jsp/start.jsp");
		}
		if(option.equals("viewprofile"))
		{
			response.sendRedirect("jsp/userprofile.jsp");
		}
		
	}

}
