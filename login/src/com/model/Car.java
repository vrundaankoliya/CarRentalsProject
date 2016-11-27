package com.model;

public class Car {
	private String carmodel,carcolor,cartype,carid,perdayrate;
	private boolean occupied;
	public Car(String carmodel, String carcolor, String cartype, String carid,
			String perdayrate, boolean occupied) {
		super();
		this.carmodel = carmodel;
		this.carcolor = carcolor;
		this.cartype = cartype;
		this.carid = carid;
		this.perdayrate = perdayrate;
		this.occupied = occupied;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public String getPerdayrate() {
		return perdayrate;
	}
	public void setPerdayrate(String perdayrate) {
		this.perdayrate = perdayrate;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	@Override
	public String toString() {
		return "Car [carmodel=" + carmodel + ", carcolor=" + carcolor
				+ ", cartype=" + cartype + ", carid=" + carid + ", perdayrate="
				+ perdayrate + ", occupied=" + occupied + "]";
	}
	
	
}
