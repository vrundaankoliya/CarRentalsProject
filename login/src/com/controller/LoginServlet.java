package com.controller;

import java.io.IOException;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginClass;

public class LoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check the username and password is valid or not.
		
		String email=(String)request.getParameter("email");
		String password=(String)request.getParameter("password");

		// do validation here data is valid or not.
		
		LoginClass login = new LoginClass();
		
		try{
			/*request.getSession().setAttribute("user", login.findUser(email, password));
			System.out.println(login.findUser(email, password));
			request.getSession().setAttribute("logLabel", login.findUser(email, password).getFname());*/
			if(login.findUser(email, password)==null)
			{
				System.out.println("user not found !!!");
				request.getSession().setAttribute("frmheader","Please Check email and password.");
				request.getSession().setAttribute("logvisibility","show");
				request.getSession().setAttribute("email",email);
			}
			else if(login.findUser(email, password)!=null)
			{	
				request.getSession().setAttribute("user", login.findUser(email, password));
				request.getSession().setAttribute("logLabel", login.findUser(email, password).getFname());
				request.getSession().setAttribute("logvisibility","hidden");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		response.sendRedirect("jsp/start.jsp");
	}

}
