package com.group6.b2c.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.group6.b2c.dao.OrderDao;
import com.group6.b2c.dao.PayDao;
import com.group6.b2c.dao.ProductDao;
import com.group6.b2c.pojo.Order;
import com.group6.b2c.pojo.Payment;
import com.group6.b2c.pojo.Product;
import com.group6.b2c.viewbean.Ordersvo;
import com.group6.b2c.viewbean.Ordervo;
import com.group6.b2c.viewbean.Postvo;



public class OrderService {

	public List<Ordersvo> findall(String userName) {
		List<Ordersvo> vos = new ArrayList<Ordersvo>();
		OrderDao od = new OrderDao();
		List<Order> ors = od.findall(userName);
		vos = p2v(ors);// new ArrayList<StudentVo>();
		return vos;
	}

	

	public int RemoveById(int id) {
		int i = -1;
		OrderDao oDao = new OrderDao();
		i = oDao.removeById(id);
		oDao.removeProFromOrder(id);
		return i;
	}

	public Ordersvo findByKey(int orderid) {
		OrderDao od = new OrderDao();
		Order order = od.searchById(orderid);
		PayDao pDao = new PayDao();
		Ordersvo ov = new Ordersvo();

		if (order != null) {
			ov.setOrderID(order.getOrder_id());
			if (!order.getStatus().contains("未支付")) {
				if(!order.getStatus().equals("已作废")){
				Payment pm = new Payment();
				pm = pDao.findByKey(order.getPay_id()).get(0);
				ov.setPayID(pm.getPay_id());
				ov.setPayTime(pm.getPay_time());
				}
			}
			ov.setStart_time(order.getBorn_time());
			ov.setStatus(order.getStatus());
			return ov;
		} else {
			return null;
		}
	}

	public int changeStatusToConfirm(int orderid) {
		int i = -2;
		OrderDao oDao = new OrderDao();
		Ordersvo o=findByKey(orderid);
		if (o.getPayID() == 0) {
			return i;
		}
		if(o.getStatus().equals("已确认")){
			return -3;
		}
		if(o.getStatus().equals("已发货")){
			i = oDao.changeStatus("已确认", orderid);
			return i;
		}
		return -4;
		
	}
	public int payByShip(int orderid){
		int i=-1;
		OrderDao odDao=new OrderDao();
		i=odDao.changeToPayShip("未支付，已发货", orderid);
		
		return i;
	}

	public int changeStatusToPay(int orderid) {
		int i = -2;
		OrderDao oDao = new OrderDao();
		if (findByKey(orderid).getPayID() == 0) {
			i = oDao.changeStatus("已支付", orderid);
		}
		return i;
	}

	public int addPayment(int pid, int oid) {
		OrderDao oDao = new OrderDao();
		int i = oDao.addPaymentIntoOrder(pid, oid);
		return i;
	}

	public int addOrder(Order o, String[] ids, String[] quas) {
		OrderDao oDao = new OrderDao();
		oDao.addorder(o);
		int i = oDao.searchKey(o.getBorn_time(), o.getUser_name());
		oDao.addProductIntoOr(i, ids, quas);
		return i;
	}

	public List<Ordervo> findProductInOrder(int orderid) {
		ProductDao pao = new ProductDao();
		OrderDao od = new OrderDao();
		List<Product> pros = pao.findInOrder(orderid);
		List<Ordervo> vos = new ArrayList<Ordervo>();
		for (Product p : pros) {
			Ordervo vo = new Ordervo();
			vo.setImage(p.getImage());
			vo.setProduct_id(p.getP_id());
			vo.setProduct_name(p.getP_name());
			vo.setProduct_price(p.getP_price());
			vo.setQuantity(od.findQuantityInOrder(orderid, p.getP_id()));
			double total = vo.getQuantity() * vo.getProduct_price();
			vo.setTotal(total);
			vos.add(vo);
		}
		return vos;
	}
	//梦娇的部分
	public List<Ordersvo> findOrderById(int id) {
		OrderDao od = new OrderDao();
		List<Order> lspo = od.findOrderById(id);
		List<Ordersvo> lsvo = p2v(lspo);// new ArrayList<StudentVo>();
		return lsvo;
	}

	public List<Ordersvo> findOrderByStatus(String[] status) {
		OrderDao od = new OrderDao();
		List<Order> lspo = od.findOrderByStatus(status);
		List<Ordersvo> lsvo = p2v(lspo);// new ArrayList<StudentVo>();
		if(lsvo!=null){
		    List<Ordersvo> list=removeDup(lsvo);
		    return list;
		}
		return lsvo;
	}

	public List<Ordersvo> findOrder(int id, String[] status) {
		OrderDao od = new OrderDao();
		List<Order> lspo = od.findOrder(id, status);
		List<Ordersvo> lsvo = p2v(lspo);
		if(lsvo!=null){
		    List<Ordersvo> list=removeDup(lsvo);
		    return list;
		}
		return lsvo;
	}
	
	public List<Ordersvo> removeDup(List<Ordersvo> vo){
		List<Ordersvo> v = new ArrayList<Ordersvo>();
		for (int i = 0; i < vo.size(); i++) {
			boolean hasSame=false;
			if(i==0){
				v.add(vo.get(i));
			
			}else{
				for (int j = 0; j < v.size(); j++) {
					if(v.get(j).getOrderID()==(vo.get(i).getOrderID())){
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

	// 删除订单
	public boolean deleteOrder(int id) {
		OrderDao od = new OrderDao();
		if (od.deleteOrder(id) == 1) {
			return true;
		}
		return false;
	}

	public boolean changeStatus(String status, int orderid) {
		OrderDao od = new OrderDao();
		if (1 == od.changeStatus(status, orderid)) {
			return true;
		}
		return false;
	}

	private List<Ordersvo> p2v(List<Order> lsps) {
		PayDao pd = new PayDao();
		if (lsps == null || lsps.size() == 0) {
			return null;
		}
		List<Ordersvo> vo = new ArrayList<Ordersvo>();
		for (Order o : lsps) {
			Ordersvo p = new Ordersvo();
			p.setOrderID(o.getOrder_id());
			p.setStart_time(o.getBorn_time());
			p.setStatus(o.getStatus());
			p.setPayID(o.getPay_id());
			if (!o.getStatus().contains("未支付")){
				if(!o.getStatus().equals("已作废"))
				p.setPayTime(pd.findByKey(o.getPay_id()).get(0).getPay_time());
			}
			vo.add(p);
		}
		return vo;
	}



}
