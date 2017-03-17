package com.group6.b2c.viewbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ordersvo {
private int orderID;
private String start_time;
private int payID;
private String payTime;
private String status;
private String action;
 int hasBornDays;
public int getOrderID() {
	return orderID;
}
public void setOrderID(int orderID) {
	this.orderID = orderID;
}
public String getStart_time() {
	return start_time;
}
public void setStart_time(String start_time) {
	this.start_time = start_time;
}
public int getPayID() {
	return payID;
}
public void setPayID(int payID) {
	this.payID = payID;
}
public String getPayTime() {
	return payTime;
}
public void setPayTime(String payTime) {
	this.payTime = payTime;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public void setAction(String action) {
	this.action=action;
	
}
public String getAction() {
	return this.action;
}
public int getHasBornDays() {

	if (start_time != null) {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			Date bornTime = format.parse(start_time);
			hasBornDays = (int) ((now.getTime() - bornTime.getTime()) / (1000 * 60 * 60 * 24));
			System.out.println(hasBornDays);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		hasBornDays = 0;
	}
	return hasBornDays;
}

public void setHasBornDays(int hasBornDays) {
	this.hasBornDays = hasBornDays;
}


}
