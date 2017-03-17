package com.group6.b2c.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;
import javax.swing.text.StyleContext.SmallAttributeSet;

import com.group6.b2c.pojo.Cart;





public class CartDao extends BaseDao{

	public int removeProductFromCart(int productId){
			int i = -1;
			String sql = "delete from cart_product where p_id = ? ";
			String[] args={productId+""};
			i = update(sql, args);
			return i;
		}
	public int findCartIDByUser(String userName){
		int i=-1;
		List<Cart> lds=null;
		String sql = "select cart_id from cart where u_name= ? ";
	
		String[] args={userName};
		Result result = query(sql,args);	
		SortedMap[] sms = result.getRows();
		if(sms.length>0)
		i= sms[0].get("cart_id")==null?-1:
			Integer.parseInt(sms[0].get("cart_id").toString());
		return i;
		
	}

	public int findQuantityOfProduct(int cartID,int productID){
		
		List<Cart> lds=null;
		String sql = "select quantity from cart_product where cart_id= ? and p_id= ? ";
		String[] args={cartID+"",productID+""};
		Result result = query(sql,args);	
		SortedMap[] sms = result.getRows();
		if(sms.length>0)
		return sms[0].get("quantity")==null?-1:
			Integer.parseInt(sms[0].get("quantity").toString());
		return -1;
		
	}

	public int removeProductFromCartByTour(String sessionId,int pid){
		int i = -1;
		String sql = "delete from tour where sessionid = ? and  p_id = ? ";
		String[] args={sessionId,pid+""};
		i = update(sql, args);
		return i;
	}
	public int addProductIntoCartByUser(int p_id,int cart_id,int quantity){
		int i=-1;
		String sql="insert into cart_product( p_id,cart_id,quantity)values"+
                   "(? , ? , ? )";
		String[] args={p_id+"",cart_id+"",quantity+""};
		i = update(sql, args);
		return i;
	}
	public int addProductIntoCartByTour(String s_id,int p_id,int quantity){
		int i=-1;
		String sql="insert into tour( sessionid,p_id,quantity)values"+
                   "(? , ? , ? )";
		String[] args={s_id,p_id+"",quantity+""};
		i = update(sql, args);
		return i;
	}
	public int findQuantityOfProductInTour(String sessionID,int productID){
		
		List<Cart> lds=null;
		String sql = "select quantity from tour where sessionid= ? and p_id= ? ";
		String[] args={sessionID,productID+""};
		Result result = query(sql,args);	
		SortedMap[] sms = result.getRows();
		if(sms.length>0)
		return sms[0].get("quantity")==null?-1:
			Integer.parseInt(sms[0].get("quantity").toString());
		return -1;
		
	}
     public SortedMap[] findPidsAboutTour(String sessionid){
    		int i=-1;
    		String sql="select p_id,quantity from tour where sessionid= ? ";
    		String[] args={sessionid};
    		Result result = query(sql,args);	
    		SortedMap[] sms = result.getRows();
    		return sms;
	}
     public int changQuntityInTour(String sessionID,int productID,int quantity){
    		int i = -1;
    		String sql ="update tour set quantity=? where sessionid= ? and p_id= ?  "; 
                                                                                                                 	
    		String [] args={quantity+"",sessionID,productID+""};
    		i = update(sql, args);
    	    return i;
     }
     public int changQuntityInUser(int cID,int productID,int quantity){
 		int i = -1;
 		String sql ="update cart_product set quantity=? where cart_id= ? and p_id= ?  "; 
                                                                                                              	
 		String [] args={quantity+"",cID+"",productID+""};
 		i = update(sql, args);
 	    return i;
  }
 	public int add(String name){
		int i=-1;
		String sql="insert into cart( u_name)values"+
                   "(? )";
		String[] args={name};
		i = update(sql, args);
		return i;
	}
		
}
