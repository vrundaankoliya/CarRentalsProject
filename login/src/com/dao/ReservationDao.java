package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.model.Reservation;
import com.model.User;

public class ReservationDao {
	private static Statement stmt;
	private static ResultSet rs;
	public int insertReservation(Reservation reservation)throws Exception
	{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
	    //Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:3306:root","rentalservice","");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalservice", "root", "mysql");
	    Statement stmt=(Statement)con.createStatement();
	    System.out.println("Connected!!!");
        String query = "INSERT INTO Reservation (pickupLocation, dropLocation, datePickup, dateDrop, email, insuranceAmount, giftCardAmount,carWashAmount,carType,cost) "
        		+ "VALUES ('"+reservation.getPickupLocation()+"',"
        		+"'"+reservation.getDropLocation()+"',"+"'"+reservation.getDatePickup()+"',"+"'"+reservation.getDateDrop()+"','"+reservation.getEmail()+"','"+reservation.getInsuranceAmount()+"','"
        		+reservation.getGiftCardAmount()+"',"+"'"+reservation.getCarWashAmount()+"',"+"'"+reservation.getCartype()+"',"+"'"+reservation.getCost()+"')";
        int i=stmt.executeUpdate(query);
		return i;
	}
	public String findUser(Reservation reservation) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalservice", "root", "mysql");
	    Statement stmt=(Statement)con.createStatement();
	    System.out.println("Connected!!!");
        String query = "select * from Reservation where email = '"+reservation.getEmail()+"' and cost = '"+reservation.getCost()+"'";
        ResultSet rs=stmt.executeQuery(query);
        if(rs.next())
        {        	
            return  rs.getString("ID").toString();
            					
        }
        else
        	return "0";        
	}
	
	public Reservation findReservationRecord(String Id) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalservice", "root", "mysql");
	    Statement stmt=(Statement)con.createStatement();
	    System.out.println("Connected!!!");
        String query = "select * from Reservation where id = '"+Integer.parseInt(Id)+"'";
        ResultSet rs=stmt.executeQuery(query);
        if(rs.next())
        {        	
        	Reservation rev=new Reservation(rs.getString("email"),rs.getString("pickupLocation"),rs.getString("dropLocation"),rs.getString("datePickup"),rs.getString("dateDrop"),
            											rs.getString("giftCardAmount"),rs.getString("carWashAmount"),rs.getString("insuranceAmount"),
            											rs.getString("carType"),rs.getString("cost"));
            System.out.println(rev);
            return rev;
        }
        else
        	return null;        
	}

}

