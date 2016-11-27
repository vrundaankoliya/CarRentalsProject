package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CarDaoClass;
import com.services.CarRentCalculate;

public class CarOrderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cars=(String)request.getParameter("cars");
		String city=(String)request.getParameter("city");
		String startDate=(String)request.getParameter("startDate");
		String endDate=(String)request.getParameter("endDate");
		String iCompact=(String)request.getParameter("iCompact");
		String iMidSize=(String)request.getParameter("iMidSize");
		String iLuxury=(String)request.getParameter("iLuxury");
		String giftcard=(String)request.getParameter("giftcard");
		String carWash=(String)request.getParameter("carWash");
		String cost=(String)request.getParameter("cost");
		String dropcity=(String)request.getParameter("dropcity");
		
		System.out.println("cars="+cars);
		System.out.println("city="+city);
		System.out.println("startDate="+startDate);
		System.out.println("endDate="+endDate);
		System.out.println("iCompact="+iCompact);
		System.out.println("iMidSize="+iMidSize);
		System.out.println("iLuxury="+iLuxury);
		System.out.println("giftcard"+giftcard);
		System.out.println("carWash="+carWash);
		System.out.println("cost="+cost);
		//String noofdays=(String)request.getParameter("noofdays");
		request.getSession().setAttribute("cost",cost);
		request.getSession().setAttribute("startDate",startDate);
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("fromcity",city);
		request.getSession().setAttribute("tocity",dropcity);
		request.getSession().setAttribute("cost",cost);
		if ("29.99".equals(cars)){
		request.getSession().setAttribute("selectedcar","Compact");}
		if ("39.99".equals(cars)){
			request.getSession().setAttribute("selectedcar","Mid Size");}
			
		if ("49.99".equals(cars)){
			request.getSession().setAttribute("selectedcar","Luxury");}
		if (iCompact!= null)
		request.getSession().setAttribute("insuranceAmount",iCompact);
		if (iMidSize!= null)
		request.getSession().setAttribute("insuranceAmount",iMidSize);
		if (iLuxury!= null)
		request.getSession().setAttribute("insuranceAmount",iLuxury);
		if (giftcard!= null)
			{request.getSession().setAttribute("giftcard",giftcard);}
			if (carWash!= null)
			{request.getSession().setAttribute("carWash",carWash);}
		
		
		response.sendRedirect("jsp/orderconfirmation.jsp");
		
		/*response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Login Response</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("<div> <h1>Totall Rent = "+rent+"</br>No Of Days = "+days+"</h1></div>");
	    out.println("</body>");
	    out.println("</html>");	 */       
	}

}
