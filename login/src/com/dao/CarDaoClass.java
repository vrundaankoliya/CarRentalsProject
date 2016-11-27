package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Car;

public class CarDaoClass {
	private static Statement stmt;
	private static ResultSet rs;
	public CarDaoClass()
	{
		
	}
	
	public ArrayList<Car> findCars() throws Exception
	{	
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalservice", "root", "mysql");
	    stmt=(Statement)con.createStatement();
	    System.out.println("Connected!!!");
        String query = "select * from RENTALCAR where availability = 'true'";
        rs=stmt.executeQuery(query);
        ArrayList<Car> cars = new ArrayList<Car>();
        while(rs.next())
        {        	
        	boolean avail = carAvailability(rs.getString("availability"));        	
            Car car=new Car(rs.getString("carname"),rs.getString("carcolor"),rs.getString("cartype"),rs.getString("carid"),
            											rs.getString("drent"),avail);           
            cars.add(car);
            System.out.println(car);
        }
        return cars;
	}
	
	public static boolean carAvailability(String avail)
	{
		if(avail.equalsIgnoreCase("true"))
    	{
    		return true;
    	}else
    	{
    		return false;
    	}
	}
	
	public double findPrice(String carName)throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalservice", "root", "mysql");
	    stmt=(Statement)con.createStatement();
	    System.out.println("Connected!!!");
		double price=0;
		String query = "select * from RENTALCAR where carname = '"+carName+"'";
		rs=stmt.executeQuery(query);
		while(rs.next())			
        {
			price=Double.parseDouble(rs.getString("drent"));   
			System.out.println("price ==="+price);
        }        
		return price;
	}
}
