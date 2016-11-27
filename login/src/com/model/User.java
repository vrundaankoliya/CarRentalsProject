package com.model;

public class User {
	private String fname,lname,address,phno,bdate,email,password,role;

	public User() {
		super();
	}

	public User(String fname, String lname, String address, String phno,
			String bdate, String email, String password, String role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phno = phno;
		this.bdate = bdate;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", address="
				+ address + ", phno=" + phno + ", bdate=" + bdate + ", email="
				+ email + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
