package com.group6.b2c.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
private int order_id;
private String status;
private String born_time;
private int cart_id;
private String user_name;
int hasBornDays;
public String getUser_name() {
	return user_name;
}
public void setUser_name(String userName) {
	user_name = userName;
}
private String receiver;
private String receriver_phone;
private int address_id;
private int pay_id;

public int getPay_id() {
	return pay_id;
}
public void setPay_id(int payId) {
	pay_id = payId;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getBorn_time() {
	return born_time;
}
public void setBorn_time(String born_time) {
	this.born_time = born_time;
}
public int getCart_id() {
	return cart_id;
}
public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}

public String getReceiver() {
	return receiver;
}
public void setReceiver(String receiver) {
	this.receiver = receiver;
}
public String getReceriver_phone() {
	return receriver_phone;
}
public void setReceriver_phone(String receriver_phone) {
	this.receriver_phone = receriver_phone;
}
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}

public int getHasBornDays() {

	if (born_time != null) {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			Date bornTime = format.parse(born_time);
			hasBornDays = (int) ((now.getTime() - bornTime.getTime()) / (1000 * 60 * 60 * 24));
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
