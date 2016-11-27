package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDaoClass;
import com.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistratServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistratServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello it worked");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Post Method");
		String email=(String)request.getParameter("email");
		String password=(String)request.getParameter("password");
		String fname=(String)request.getParameter("fname");
		String lname=(String)request.getParameter("lname");
		String bdate=(String)request.getParameter("address");
		String address=(String)request.getParameter("bdate");
		String phno=(String)request.getParameter("phno");
		String role=null;
		
		/*public User(String fname, String lname, String address, String phno,
				String bdate, String email, String password, String role) {*/
		User user=new User(fname,lname,address,phno,bdate,email,password,role);
		UserDaoClass userdb = new UserDaoClass();
		try{			
			if(userdb.insertUser(user)==1)
			{
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("logLabel", user.getFname());
				request.getSession().setAttribute("logvisibility","hidden");
				response.sendRedirect("jsp/userprofile.jsp");
			}
			else{
				System.out.println("Error Occured Try Again.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
