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
 * Servlet implementation class OrderConfirmationServlet
 */
public class OrderConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u=(User)request.getSession().getAttribute("user");
		Reservation reservation =new Reservation();
		reservation.setCartype((String)request.getSession().getAttribute("selectedcar"));
		reservation.setInsuranceAmount((String)request.getSession().getAttribute("insuranceAmount"));
		reservation.setCost((String)request.getSession().getAttribute("cost"));
		reservation.setDatePickup((String)request.getSession().getAttribute("startDate"));
		reservation.setDateDrop((String)request.getSession().getAttribute("endDate"));
		reservation.setPickupLocation((String)request.getSession().getAttribute("fromcity"));
		reservation.setDropLocation((String)request.getSession().getAttribute("tocity"));
		reservation.setCost((String)request.getSession().getAttribute("cost"));
		reservation.setGiftCardAmount((String)request.getSession().getAttribute("giftcard"));
		reservation.setCarWashAmount((String)request.getSession().getAttribute("carWash"));
		reservation.setEmail(u.getEmail());
		ReservationDao rDao=new ReservationDao();
		try {
			rDao.insertReservation(reservation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			request.getSession().setAttribute("confirmationNo",rDao.findUser(reservation));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("jsp/orderconfirmationFinal.jsp");
	}

}
