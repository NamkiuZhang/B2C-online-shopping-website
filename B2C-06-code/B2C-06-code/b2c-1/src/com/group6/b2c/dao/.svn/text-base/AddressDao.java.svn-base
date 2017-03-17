
package com.group6.b2c.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.group6.b2c.pojo.Address;




public class AddressDao extends BaseDao{

	public int add(Address ad){
			int i=-1;
			String sql="insert into address(u_name, f_address, s_address, post_number) values"+
			"( ? , ? , ? , ? )";
                 
			String[] args={ad.getUser_name(),ad.getF_address(),ad.getS_address(),
					ad.getPost_number()+""};
			i = update(sql, args);
			return i;
		}
	public int findKey(String uname,String f_address,String s_address,int post_number){
		String sql="select id from address where u_name=? and f_address=? " +
				"and s_address=? and post_number=? ";
		String[] args={uname,f_address,s_address,post_number+""};
		Result result = query(sql,args);	
		SortedMap[] sms = result.getRows();
		return sms[0].get("id")==null?-1:
			Integer.parseInt(sms[0].get("id").toString());
	}
	public List<Address> findByKey(String username ){
		List<Address>ads=new ArrayList<Address>();
		String sql = "select * from address where u_name= ? ";
		
		String[] args={username};
		Result result = query(sql,args);	
	
		ads = r2o(result);
		return ads;
	}
	private List<Address> r2o(Result result) {
		if (result == null ||result.getRowCount() == 0) {
			return null;			
		}
		List<Address> lds = new ArrayList<Address>();
		SortedMap[] sms = result.getRows();
		for (int i = 0; i < result.getRowCount(); i++) {
			SortedMap sm =sms[i];
			Address d = r2o(sm);
			lds.add(d);
			
		}
		return lds;
	}
	private Address r2o(SortedMap sm) {
		if(sm == null|| sm.size() == 0)
		{
			return null;
		}
		Address a=new Address();
		
		a.setF_address(sm.get("f_address")==null? "":sm.get("f_address").toString());
		a.setId(sm.get("id")==null?-1:Integer.parseInt(sm.get("id").toString()));
		a.setPost_number(sm.get("post_number")==null?-1:Integer.parseInt(sm.get("post_number").toString()));
		a.setS_address(sm.get("s_address")==null? "":sm.get("s_address").toString());
		a.setUser_name(sm.get("u_name")==null? "":sm.get("u_name").toString());
	
		return a;
	}


	

	public int delete(int id){
		int i=-1;
		String sql="delete address where id =  ?  ";
		String[] args={id+""};
		i=update(sql, args);
		return i;
	}
	public int mod(Address address){
		int i=-1;
		String sql="update address set f_address = ?  , " +
				"s_address = ?   , post_number =  ?   where id = ?  ";
		String[] args={address.getF_address(), address.getS_address(), address.getPost_number()+"",address.getId()+""};
		i=update(sql, args);
		return i;
	}
	public String[] findById(int id){
		String sql="select * from address where id=  ?  ";
		String[] args={id+""};
		Result result=query(sql, args);
		SortedMap[] sm=result.getRows();
		if(sm.length==1){
			String[] addr={sm[0].get("f_address").toString(),sm[0].get("s_address").toString(),sm[0].get("post_number").toString()};
			return addr;
		}
		return null;
	}

	
	



}
	
	


