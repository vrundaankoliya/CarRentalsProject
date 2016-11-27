package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReservationDao;
import com.model.Reservation;
import com.model.User;

/**
 * Servlet implementation class GetReservationStatus
 */
public class GetReservationStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReservationStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=(String)request.getParameter("reservationId");
		ReservationDao rDao=new ReservationDao();
		Reservation r=new Reservation();
		try {
			r=rDao.findReservationRecord(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.setAttribute("pickupLocation",r.getPickupLocation());
		 request.setAttribute("email",r.getEmail());
		 request.setAttribute("dropLocation",r.getDropLocation());
		 request.setAttribute("datePickup",r.getDatePickup());
		 request.setAttribute("dateDrop",r.getDateDrop());
		 request.setAttribute("giftCardAmount",r.getGiftCardAmount());
		 request.setAttribute("carWashAmount",r.getCarWashAmount());
		 request.setAttribute("insuranceAmount",r.getInsuranceAmount());
		 request.setAttribute("carType",r.getCartype());
		 request.setAttribute("cost",r.getCost());
		 request.getRequestDispatcher("jsp/RegistrationStatus.jsp").forward(request,response);

	}

}
