package com.group6.b2c.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import javax.servlet.jsp.jstl.sql.Result;
import com.group6.b2c.pojo.Order;






public class OrderDao extends BaseDao{

	public int addorder(Order order) 
	{
		int i = -1;
		String sql = " insert into ordr(status, born_time, " +
				"cart_id,  u_name, receiver, receiver_phone, address_id)" +
				"values( ? , ? , ? , ? ," +
				" ? , ? , ? )";
                                                                                                             	
		String [] args={order.getStatus(),order.getBorn_time(),order.getCart_id()+"",
				order.getUser_name(),order.getReceiver(),
				order.getReceriver_phone(),order.getAddress_id()+""};
		i = update(sql, args);
	    return i;
	}
	public int addPaymentIntoOrder(int pid,int oid){
		int i = -1;
		String sql ="update ordr set status= ? , pay_id= ? where order_id= ? "; 
                                                                                                             	
		String [] args={"已支付",pid+"",oid+""};
		i = update(sql, args);
	    return i;
	}
	public int addProductIntoOr(int orderid,String[] pid,String[] quas){
		int i = -1;
		String sql = " insert into order_pro( order_id,p_id,quantity)values( ? , ? , ? )";  
		for (int j = 0; j < pid.length; j++) {
			String[] args={orderid+"",pid[j],quas[j]};
			i = update(sql, args);
		}	
		return i;		
	}
	public int findQuantityInOrder(int orderid,int pid){
		String sql="select quantity from order_pro where p_id= ? and order_id= ? ";
		String[] args={pid+"",orderid+""};
		Result result =query(sql, args);
		SortedMap[] sms = result.getRows();
		
		return sms[0].get("quantity")==null?-1:
			Integer.parseInt(sms[0].get("quantity").toString());
	}
	public int searchKey(String time,String name){
		String sql="select order_id from ordr where born_time= ? and u_name= ? ";
		String[] args={time,name};
		Result result =query(sql, args);
		SortedMap[] sms = result.getRows();
		
		return sms[0].get("order_id")==null?-1:
			Integer.parseInt(sms[0].get("order_id").toString());
	}

	public Order searchById(int orderId){
		List<Order> lds=null;
		String sql="  select * from ordr where order_id = ?";
		String[] args={orderId+""};
		Result result = query(sql,args);	
		lds = r2o(result);
		if(lds==null||lds.size()==0){
			return null;
		}
		return lds.get(0);
	}
	public int removeById(int orderId){
		int i = -1;
		String sql="  delete from ordr where order_id = ? ";
		String[] args={orderId+""};
		i = update(sql, args);
		return i;	
	}
	public int removeProFromOrder(int orderId){
		int i = -1;
		String sql="  delete order_pro where order_id = ? ";
		String[] args={orderId+""};
		i = update(sql, args);
		return i;
	}

	public int changeToPayShip(String status,int orderid){
		int i=-1;
		String sql="update ordr set status= ? where order_id= ? ";
		String[] args={status,orderid+""};
		i=update(sql, args);
		return i;
		
	}
	public List<Order> findall(String userName)
	{
		List<Order> lds=null;
		String sql = "select * from ordr where u_name= ? ";
		String[] args={userName};
		Result result = query(sql, args);
		lds = r2o(result);
		return lds;
	}
	private List<Order> r2o(Result result) {
		if (result == null ||result.getRowCount() == 0) {
			return null;			
		}
		List<Order> lds = new ArrayList<Order>();
		SortedMap[] sms = result.getRows();
		for (int i = 0; i < result.getRowCount(); i++) {
			SortedMap sm =sms[i];
			Order d = r2o(sm);
			lds.add(d);
			
		}
		return lds;
	}
	private Order r2o(SortedMap sm) {
		if(sm == null|| sm.size() == 0)
		{
			return null;
		}
		Order o =new Order();
		o.setAddress_id(sm.get("address_id")==null?-1:Integer.parseInt(sm.get("address_id").toString()));
		o.setCart_id(sm.get("cart_id")==null?-1:Integer.parseInt(sm.get("cart_id").toString()));
		o.setOrder_id(sm.get("order_id")==null?-1:Integer.parseInt(sm.get("order_id").toString()));
		o.setPay_id(sm.get("pay_id")==null?-1:Integer.parseInt(sm.get("pay_id").toString()));
		o.setBorn_time(sm.get("born_time")==null? "":sm.get("born_time").toString());
		o.setReceiver(sm.get("receiver")==null? "":sm.get("receiver").toString());
		o.setReceriver_phone(sm.get("receiver_phone")==null? "":sm.get("receiver_phone").toString());
		o.setStatus(sm.get("status")==null? "":sm.get("status").toString());
		o.setUser_name(sm.get("u_name")==null? "":sm.get("u_name").toString());
		
		
		return o;
	}
	
	// 查询订单
	public List<Order> findOrder(int id, String[] status) {
		List<Order> lspo = null;
		if (id != -1 && (status == null || status.length == 0)) {
			String sql = " select * from ordr where order_id =  ?  ";
			String[] args = { String.valueOf(id) };
			Result r = query(sql, args);
			lspo = r2o(r);
		} else if (id != -1 && status.length > 0) {

			for (int i = 0; i < status.length; i++) {
				String sql = " select * from ordr where order_id =  ?  	and status like  ?   ";
				String []args={ id+"", "%"+ status[i]+"%" };
				Result r = query(sql, args);
				List<Order> lspoTmp = r2o(r);
				if (lspo == null)
					lspo = new ArrayList<Order>();
					if (lspoTmp != null)
						lspo.addAll(lspoTmp);
					else
						lspo = null;
			}
		} else if (id == -1 && status.length > 0) {
			 lspo = new ArrayList<Order>();
			for (int i = 0; i < status.length; i++) {
				String sql = " select * from ordr where  status like   ?  " ;
				String []args={  "%"+ status[i]+"%"  };
				Result r = query(sql, args);
				List<Order> lspoTmp = r2o(r);
					if (lspoTmp != null)
						lspo.addAll(lspoTmp);
					else
						lspo = lspo;
			}
		}

		return lspo;
	}

	public List<Order> findOrderById(int id) {
		String sql = " select * from Ordr where Order_id like  ?  ";
		String[] args = { "%"+ id +"%" };
		Result r = query(sql, args);
		List<Order> lspo = r2o(r);
		return lspo;

	}

	public List<Order> findOrderByStatus(String[] status) {
		List<Order> lspo = new ArrayList<Order>();
		for (int i = 0; i < status.length; i++) {
			String sql = " select * from Ordr where  status  like    ?  " ;
			String []args={ "%"+ status[i]+"%"  };
			Result r = query(sql, args);
			List<Order> lspoTmp = r2o(r);
				if (lspoTmp != null)
					lspo.addAll(lspoTmp);
				else
					lspo = lspo;
			}
		
		return lspo;
	}

	// 删除订单
	public int deleteOrder(int id) {
		String sql = "delete from Ordr where Order_id=  ? ";
		String[] args = { id + "" };
		int i = update(sql, args);
		return i;
	}

	// 修改订单状态
	public int changeStatus(String status, int Orderid) {

		String sql = "update Ordr set status =  ?   where Order_id= ? ";
		String[] args = { status, Orderid + "" };
		int i = update(sql, args);
		return i;

	}
	public int changeStatuss(String status,int Orderid){
		int i=-1;
		String sql="update Ordr set status= ? where Order_id= ? ";
		String[] args={status,Orderid+""};
		i=update(sql, args);
		return i;
		
	}
	

	
	
	
}