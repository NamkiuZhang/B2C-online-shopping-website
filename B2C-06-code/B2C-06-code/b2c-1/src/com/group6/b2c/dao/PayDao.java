package com.group6.b2c.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.group6.b2c.pojo.Payment;






public class PayDao extends BaseDao{

	public int addPayment(String time,int id){
		int i = -1;
		String sql = "insert into payment( pay_time, pay_method_id)values( ? , ? )";                                                                                                            	
		String [] args={time,id+""};
		i = update(sql, args);
	    return i;
	}
	public int findId(String time,int id){
		String sql = "select pay_id from payment where pay_time= ? and pay_method_id= ? ";
		String[] args={time,id+""};
		Result result =query(sql, args);
		SortedMap[] sms = result.getRows();
		return sms[0].get("pay_id")==null?-1:
			Integer.parseInt(sms[0].get("pay_id").toString());
	}
	public List<Payment> findByKey(int id ){
		List<Payment>ads=new ArrayList<Payment>();
		String sql = "select * from payment where pay_id= ? ";
		
		String[] args={id+""};
		Result result = query(sql,args);	
		ads = r2o(result);
	
		return ads;
	}
	private List<Payment> r2o(Result result) {
		if (result == null ||result.getRowCount() == 0) {
			return null;			
		}
		List<Payment> lds = new ArrayList<Payment>();
		SortedMap[] sms = result.getRows();
		for (int i = 0; i < result.getRowCount(); i++) {
			SortedMap sm =sms[i];
			Payment d = r2o(sm);
			lds.add(d);
			
		}
		return lds;
	}
	private Payment r2o(SortedMap sm) {
		if(sm == null|| sm.size() == 0)
		{
			return null;
		}
		Payment p =new Payment();	
		p.setPay_id(sm.get("pay_id")==null?-1:Integer.parseInt(sm.get("pay_id").toString()));
		p.setPay_method_id(sm.get("pay_method_id")==null?-1:Integer.parseInt(sm.get("pay_method_id").toString()));
		p.setPay_time(sm.get("pay_time")==null? "":sm.get("pay_time").toString());		
		return p;
	}
	
	
}
