
package com.group6.b2c.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.group6.b2c.pojo.ProductType;



public class ProductTypeDao extends BaseDao{
	
	
	public List<ProductType> findFirstType(){
		List<ProductType> lptp = null;
		String sql = "select * from producttype where parent_id = 0";	
		Result r = query(sql, null);
		lptp = r2o( r );	
		return lptp;
	}
	
	
	public List<ProductType> findbyparentid(int parentid){
		List<ProductType> lptp = null;
		String sql = "select * from producttype where parent_id = ? ";
		String[] args = {parentid+""};
		Result r = query(sql, args);
		lptp = r2o( r );
		return lptp;
	}
	
	/*查询一级分类下子分类
	public List<ProductType>  findSubByParenttypeName(String ptname){
		List<ProductType> lptp = null;
		String sql = "  select pt_name from producttype where exists  ( select id from producttype where pt_name=  ?  )";
		String []args={ ptname };
		Result r= query(sql, args);
		lptp=r2o(r);
		return lptp;
	}*/
	


	
	public int addProductType(int pid, String name ){
		String sql;
		String [] args;
		if(pid == 0){
			sql = " insert into Producttype( pt_name ,parent_id ) values(  ? , ?  )";
			args= new String[] { name , pid+""} ;
		}else{
			sql =" insert into Producttype( pt_name, parent_id) values(  ? , ?  )";
			args= new String[] { name , String.valueOf(pid) } ;
		}
		int i =update(sql, args);
		return i;
		
	}

	
	public int modifyTypeName(String name, int id){
		String sql=" update producttype set pt_name=  ?  where id=   ?  ";
		String []args = { name , id+"" };
		int i=update(sql, args);
		return i;	
	}
	
	
	public int deleteType(int id){
		String sql ="delete from producttype where id=  ?   ";
		String []args = { id+"" };
		int i=update(sql,args);
		return i;
	}
	public List<ProductType> findChildenType(int id){
		int i=-1;
		String sql ="select * from producttype where parent_id=  ?   ";
		String args[] = {id+""};
		Result r = query(sql,args);
		List<ProductType> lptp = r2o( r );
		return lptp;
	}
	
		

	public ProductType findById(int id){
		ProductType ptp =null;
		String sql = "select * from producttype where id = ? ";
		String args[] = {id+""};
		Result r = query(sql,args);
		List<ProductType> lptp = r2o( r );
		ptp = lptp.get(0);
		return ptp;
	}
		

	public List<ProductType> find(int p_id) {

		String sql = "  select pt_name, id, parent_id from producttype where parent_id=  ?   ";
		String[] args={p_id+""};
		Result r = query(sql, args);
		List<ProductType> lcs = r2o(r);
		return lcs;
	}


	private List<ProductType> r2o(Result r) {
		List<ProductType> lptp = null;
		if (r == null || r.getRowCount() == 0) {
			return lptp;
		}
		lptp = new ArrayList<ProductType>();
		SortedMap[] sms = r.getRows();
		for (int i = 0; i < sms.length; i++) {
			SortedMap sm = sms[i];
			ProductType sp = r2o(sm);
			lptp.add(sp);
		}
		return lptp;
	}

	private ProductType r2o(SortedMap sm) {
		if (sm == null) {
			return null;
		}
		ProductType ptp = new ProductType();
		ptp.setName(sm.get("pt_name").toString());// �п�
		ptp.setId(sm.get("id")== null?-1:Integer.parseInt(sm.get("id").toString()));
		//ptp.setId(Integer.parseInt(sm.get("id").toString()));
		ptp.setParentid(sm.get("parent_id")==null?-1:Integer.parseInt(sm.get("parent_id").toString()));
		return ptp;
	}

	
}
