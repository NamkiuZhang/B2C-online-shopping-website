package com.group6.b2c.service;

import com.group6.b2c.dao.AddressDao;
import com.group6.b2c.pojo.Address;
import com.group6.b2c.viewbean.AddressVo;

public class AddressService {

	public boolean address(AddressVo aVo){
		Address address=new Address();
		address.setF_address(aVo.getF_address());
		address.setS_address(aVo.getS_address());
		address.setPost_number(aVo.getPost_number());
		address.setUser_name(aVo.getUser_name());
		AddressDao ad=new AddressDao();
		if(ad.add(address)==1){
			return true;
		}
		return false;
	}
	
	public boolean modAddress(AddressVo aVo){
		Address address=new Address();
		address.setId(aVo.getId());
		address.setF_address(aVo.getF_address());
		address.setS_address(aVo.getS_address());
		address.setPost_number(aVo.getPost_number());
		AddressDao ad=new AddressDao();
		if(ad.mod(address)==1){
			return true;
		}
		return false;
	}
}
