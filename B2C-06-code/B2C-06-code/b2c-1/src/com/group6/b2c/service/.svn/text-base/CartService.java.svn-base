package com.group6.b2c.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import com.group6.b2c.dao.CartDao;
import com.group6.b2c.dao.ProductDao;
import com.group6.b2c.pojo.Product;
import com.group6.b2c.viewbean.Ordervo;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;



public class CartService {

	public List<Ordervo> findall(String userName)
	{
		List<Ordervo> vos =new ArrayList<Ordervo>();
	
		CartDao sd = new CartDao();
		ProductDao pd=new ProductDao();
		int cartID=sd.findCartIDByUser(userName);
	
		List<Product> products=pd.findInCart(cartID);
		if(products==null){
			return null;
		}
		for(Product p:products){
			Ordervo vo=new Ordervo();
			vo.setImage(p.getImage());
			vo.setProduct_id(p.getP_id());
			vo.setProduct_name(p.getP_name());
			vo.setProduct_price(p.getP_price());
			vo.setQuantity(sd.findQuantityOfProduct(cartID, p.getP_id()));
			double total=vo.getQuantity()*vo.getProduct_price();
			vo.setTotal(total);
			vos.add(vo);
		}
		return vos;
	}
	public Ordervo findbyKey(int id,String username){
		Ordervo ordervo=new Ordervo();
		CartDao sd = new CartDao();
		ProductDao pd=new ProductDao();
		int cartID=sd.findCartIDByUser(username);
		Product product=pd.findByKey(id);
		ordervo.setImage(product.getImage());
		ordervo .setProduct_id(product .getP_id());
		ordervo.setProduct_name(product.getP_name());
		ordervo.setProduct_price(product .getP_price());
		ordervo.setQuantity(sd.findQuantityOfProduct(cartID, product.getP_id()));
		double total=ordervo.getQuantity()*ordervo.getProduct_price();
		ordervo .setTotal(total);
		return ordervo;
	}
	public int addCartByUser(String name,int p_id,int quantity){
		CartDao cd=new CartDao();
		int cartid=cd.findCartIDByUser(name);
		int q=cd.findQuantityOfProduct(cartid, p_id);
		if(cartid==-1){
		cd.add(name);
		cartid=cd.findCartIDByUser(name);
		}
		if(q==-1)
		 cd.addProductIntoCartByUser(p_id, cartid,quantity);
		if(q!=-1){
			cd.changQuntityInUser(cartid, p_id, quantity+q);
		}
		return cartid;
	}
	public int addCartByTour(String sessionid,int p_id,int quantity){
		CartDao cd=new CartDao();
		int q=cd.findQuantityOfProductInTour(sessionid, p_id);
		
		if(q==-1)
		  return cd.addProductIntoCartByTour(sessionid, p_id,quantity);
		else{
			return cd.changQuntityInTour(sessionid, p_id, quantity);
		}
	}
	public int getStorage(int id,int quantity){
		ProductDao pd=new ProductDao();
		int i=pd.getStorage(id);
		if(i!=-1){
			if(i<quantity){
				return -2;
			}
		}
		return i;
		
	}
	
    public List<Ordervo> findProductsIntourCart(String sessionid){
    	CartDao cd=new CartDao();
    	SortedMap[] sm=cd.findPidsAboutTour(sessionid);
    	List<Ordervo> vos =new ArrayList<Ordervo>();
    	for (int i = 0; i < sm.length; i++) {
    		int pid=sm[i].get("p_id")==null?-1:Integer.parseInt(sm[i].get("p_id").toString());
    		int quant=sm[i].get("quantity")==null?-1:Integer.parseInt(sm[i].get("quantity").toString());
    	    if(pid!=-1){
    	    	ProductDao pd=new ProductDao();	
    	    	Product p=pd.findByKey(pid);
    	    	Ordervo vo=new Ordervo();
    			vo.setImage(p.getImage());
    			vo.setProduct_id(p.getP_id());
    			vo.setProduct_name(p.getP_name());
    			vo.setProduct_price(p.getP_price());
    			vo.setQuantity(quant);
    			double total=vo.getQuantity()*vo.getProduct_price();
    			vo.setTotal(total);
    			vos.add(vo);
    	    }
    	}
    	return vos;
    }
    public int changeTourToUser(String name,String sessionid){
    	int i=-1;
    	CartDao cd=new CartDao();
    	int cartid=cd.findCartIDByUser(name);
    	if(cartid==-1){
    	cd.add(name);
    	cartid=cd.findCartIDByUser(name);
    	}
    	List<Ordervo> os=findProductsIntourCart(sessionid);
    	
    	for(Ordervo o:os){
    		i=cd.addProductIntoCartByUser(o.getProduct_id(), cartid, o.getQuantity());
    	}
    	return i;
    }


	
}
