package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.model.User;




public class LoginClass {
	String username,password;
	
	public LoginClass() {
		super();
	}
	public LoginClass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User findUser(String username, String password) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalservice", "root", "mysql");
	    Statement stmt=(Statement)con.createStatement();
	    System.out.println("Connected!!!");
        String query = "select * from usertbl where email = '"+username+"' and password = '"+password+"'";
        ResultSet rs=stmt.executeQuery(query);
        if(rs.next())
        {        	
            User user=new User(rs.getString("fname"),rs.getString("lname"),rs.getString("address"),rs.getString("phno"),
            											rs.getString("bdate"),rs.getString("email"),rs.getString("password"),rs.getString("role"));
            System.out.println(user);
            return user;
        }
        else
        	return null;        
	}
	/*public User(String fname, String lname, String address, String phno,
			String bdate, String email, String password) {*/
	// then check the username and passsword with a db 
	// if it exist and math then reply as founds and send respective data
	// else reply as no user found.	

}
