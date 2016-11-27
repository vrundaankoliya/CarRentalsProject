package com.model;

public class Bike {
	private String bikemodel,bikecolor,biketype,bikeid,perdayrate;

	public Bike(String bikemodel, String bikecolor, String biketype,
			String bikeid, String perdayrate) {
		super();
		this.bikemodel = bikemodel;
		this.bikecolor = bikecolor;
		this.biketype = biketype;
		this.bikeid = bikeid;
		this.perdayrate = perdayrate;
	}

	public String getBikemodel() {
		return bikemodel;
	}

	public void setBikemodel(String bikemodel) {
		this.bikemodel = bikemodel;
	}

	public String getBikecolor() {
		return bikecolor;
	}

	public void setBikecolor(String bikecolor) {
		this.bikecolor = bikecolor;
	}

	public String getBiketype() {
		return biketype;
	}

	public void setBiketype(String biketype) {
		this.biketype = biketype;
	}

	public String getBikeid() {
		return bikeid;
	}

	public void setBikeid(String bikeid) {
		this.bikeid = bikeid;
	}

	public String getPerdayrate() {
		return perdayrate;
	}

	public void setPerdayrate(String perdayrate) {
		this.perdayrate = perdayrate;
	}
	
}
