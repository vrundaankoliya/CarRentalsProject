package com.model;

public class Reservation {
public Reservation(String email, String pickupLocation, String dropLocation, String datePickup, String dateDrop,
			String giftCardAmount, String carWashAmount, String insuranceAmount, String cartype, String cost) {
		this.email = email;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.datePickup = datePickup;
		this.dateDrop = dateDrop;
		this.giftCardAmount = giftCardAmount;
		this.carWashAmount = carWashAmount;
		this.insuranceAmount = insuranceAmount;
		this.cartype = cartype;
		this.cost = cost;
	}
public Reservation(){}
private String email;
private String pickupLocation,dropLocation,datePickup,dateDrop,giftCardAmount,carWashAmount,insuranceAmount,cartype,cost;

/**
 * @return the giftCardAmount
 */
public String getGiftCardAmount() {
	return giftCardAmount;
}
/**
 * @param giftCardAmount the giftCardAmount to set
 */
public void setGiftCardAmount(String giftCardAmount) {
	this.giftCardAmount = giftCardAmount;
}
public String getPickupLocation() {
	return pickupLocation;
}
public void setPickupLocation(String pickupLocation) {
	this.pickupLocation = pickupLocation;
}
public String getDropLocation() {
	return dropLocation;
}
public void setDropLocation(String dropLocation) {
	this.dropLocation = dropLocation;
}
public String getDatePickup() {
	return datePickup;
}
public void setDatePickup(String datePickup) {
	this.datePickup = datePickup;
}
public String getDateDrop() {
	return dateDrop;
}
public void setDateDrop(String dateDrop) {
	this.dateDrop = dateDrop;
}
public String getCarWashAmount() {
	return carWashAmount;
}
public void setCarWashAmount(String carWashAmount) {
	this.carWashAmount = carWashAmount;
}
public String getInsuranceAmount() {
	return insuranceAmount;
}
public void setInsuranceAmount(String insuranceAmount) {
	this.insuranceAmount = insuranceAmount;
}
public String getCartype() {
	return cartype;
}
public void setCartype(String cartype) {
	this.cartype = cartype;
}
/**
 * @return the cost
 */
public String getCost() {
	return cost;
}
/**
 * @param cost the cost to set
 */
public void setCost(String cost) {
	this.cost = cost;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
}
