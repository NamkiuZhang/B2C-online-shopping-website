package com.group6.b2c.service;

import java.util.ArrayList;
import java.util.List;

import com.group6.b2c.dao.AddressDao;
import com.group6.b2c.dao.OrderDao;
import com.group6.b2c.pojo.Address;
import com.group6.b2c.pojo.Order;
import com.group6.b2c.viewbean.Postvo;



public class PostService {
	public List<Postvo> findall(String userName) {
		List<Postvo> vos = new ArrayList<Postvo>();
		Postvo vo = new Postvo();
		OrderDao sd = new OrderDao();
		AddressDao pd = new AddressDao();
		List<Order> ors = sd.findall(userName);
		List<Address> ades = pd.findByKey(userName);

		vos = p2v(ors, ades);// new ArrayList<StudentVo>();
		return vos;
	}

	private List<Postvo> p2v(List<Order> lsps, List<Address> ad) {
		if (lsps == null || lsps.size() == 0) {
			return null;
		}
		List<Postvo> vo = new ArrayList<Postvo>();
		for (Order o : lsps) {
			for (Address a : ad) {
				if (a.getId() == o.getAddress_id()) {
					Postvo pvoPostvo = new Postvo();
					pvoPostvo.setReceiver(o.getReceiver());
					pvoPostvo.setPhone(o.getReceriver_phone());
					pvoPostvo.setAddressID(a.getId());
					pvoPostvo.setF_address(a.getF_address());
					pvoPostvo.setS_address(a.getS_address());
					pvoPostvo.setPost_number(a.getPost_number());
					vo.add(pvoPostvo);
				}
			}

		}
		List<Postvo> v = new ArrayList<Postvo>();
		
		for (int i = 0; i < vo.size(); i++) {
			boolean hasSame=false;
			if(i==0){
				v.add(vo.get(i));
			
			}else{
				for (int j = 0; j < v.size(); j++) {
					if(v.get(j).getF_address().equals(vo.get(i).getF_address())&&
							v.get(j).getReceiver().equals(vo.get(i).getReceiver())
							&& v.get(j).getPhone().equals(vo.get(i).getPhone())){
						hasSame=true;
						break;
					}
				}if(hasSame){
					
				}else{
				
					v.add(vo.get(i));
				}
			}
		}
		return v;
	}

}
