package com.model;

public class Truck {
	private String truckmodel,truckcolor,trucktype,truckid,perdayrate;

	public Truck(String truckmodel, String truckcolor, String trucktype,
			String truckid, String perdayrate) {
		super();
		this.truckmodel = truckmodel;
		this.truckcolor = truckcolor;
		this.trucktype = trucktype;
		this.truckid = truckid;
		this.perdayrate = perdayrate;
	}

	public String getTruckmodel() {
		return truckmodel;
	}

	public void setTruckmodel(String truckmodel) {
		this.truckmodel = truckmodel;
	}

	public String getTruckcolor() {
		return truckcolor;
	}

	public void setTruckcolor(String truckcolor) {
		this.truckcolor = truckcolor;
	}

	public String getTrucktype() {
		return trucktype;
	}

	public void setTrucktype(String trucktype) {
		this.trucktype = trucktype;
	}

	public String getTruckid() {
		return truckid;
	}

	public void setTruckid(String truckid) {
		this.truckid = truckid;
	}

	public String getPerdayrate() {
		return perdayrate;
	}

	public void setPerdayrate(String perdayrate) {
		this.perdayrate = perdayrate;
	}
	
}
