package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.model.User;

public class UserDaoClass {
	User user;
	public int insertUser(User user)throws Exception
	{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
	    //Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:3306:root","rentalservice","");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalservice", "root", "mysql");
	    Statement stmt=(Statement)con.createStatement();
	    System.out.println("Connected!!!");
        String query = "INSERT INTO USERTBL (FNAME, LNAME, ADDRESS, PHNO, BDATE, PASSWORD, EMAIL) VALUES ('"+user.getFname()+"',"
        		+"'"+user.getLname()+"',"+"'"+user.getAddress()+"',"+"'"+user.getPhno()+"','"+user.getBdate()+"','"+user.getPassword()+"','"
        		+user.getEmail()+"')";
        int i=stmt.executeUpdate(query);
		return i;
	}

}
/*INSERT INTO "SYSTEM"."USERTBL" (FNAME, LNAME, ADDRESS, PHNO, BDATE, PASSWORD, EMAIL) VALUES ('abc', 'xyxz', 'fremont', '789865453', '02/12/1989', 'pratik', 'abc')

Commit Successful

*/