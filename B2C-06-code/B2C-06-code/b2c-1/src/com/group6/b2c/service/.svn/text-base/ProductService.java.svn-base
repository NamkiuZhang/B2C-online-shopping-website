package com.group6.b2c.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.group6.b2c.dao.ProductDao;
import com.group6.b2c.pojo.Product;
import com.group6.b2c.viewbean.ProductVo;



public class ProductService {

	public Product findByKey(int id){
		ProductDao pDao=new ProductDao();
		return pDao .findByKey(id);
	}
	
	//添加商品
	public boolean addProduct(String name, double price, int typeId,int storage,String img){
		ProductDao pd = new ProductDao();
		if(1==pd.addProduct(name,price,typeId,storage,img)){
			return true;
		}
		return false;
	}
	
	//查询脱销产品
	public List<ProductVo> findSellout()
	{
		ProductDao pd = new ProductDao();
		List<Product> lspp = pd.findSellout();
		List<ProductVo>  lsvp =p2v(lspp);
		return  lsvp;
	}
	
	//查询商品
	public List<ProductVo> queryProduct(String name, int ptId){
		ProductDao pd = new ProductDao();
		List<Product> lspp = pd.queryProduct(name, ptId);
		List<ProductVo> lsvp = p2v(lspp);
		return lsvp;
	}
	
	//查询某分类下所有商品
	public List<ProductVo> findAllPros( int typeId){
		ProductDao pd = new ProductDao();
		List<Product> lspp = pd.findAllPros(typeId);
		List<ProductVo> lsvp = p2v(lspp);
		return lsvp;
	}
	
	//查看商品详细信息
	public ProductVo findOneProduct(int id) {
		ProductDao pd = new ProductDao();	
		return p2v(pd.findOneProduct(id));
	}
	
	//修改商品信息
	public boolean modifyProductInfo(String img, String name, int typeId,  double price,int storage, String brand ,int pid){
		ProductDao pd = new ProductDao();
		if(1==pd.modifyProductInfo(img, name, typeId, price, storage, brand ,pid)){
			return true;
		}
		return false;
	}
	public int updateStorage(int storage,int id){
		ProductDao pd = new ProductDao();
		int st=pd.getStorage(id)-storage;
		int i=pd.updateStorage(st, id);
		return i;
	}
	public int updateSalenum(int quantity,int id){
		ProductDao pd = new ProductDao();
		int sales=pd.getSalesnum(id)+quantity;
		int i=pd.updateSalenum(sales, id);
		return i;
	}

	
	//删除商品
	public boolean deleteProductByAdmin(int id){
		ProductDao pd = new ProductDao();
	
		List<Product> ps=pd.findAllproductsInCart();
		for (Product product : ps) {
			if(product.getP_id()==id){
				return false;
			}
		}
		List<Product> pls=pd.findAllproductsInOrder();
		for (Product product : pls) {
			if(product.getP_id()==id){
				return false;
			}
		}
		if(pd.deleteProduct(id)==1){
			return true;
		}
		return false;
		
	}

	
	
	private List<ProductVo> p2v(List<Product> lspp) {
		if (lspp==null ||  lspp.size()==0) {
			return null;
		} 
		List<ProductVo>  lsvp =new ArrayList<ProductVo>();
		 for (Iterator iterator = lspp.iterator(); iterator.hasNext();) {
			 Product ppo = (Product) iterator.next();
			 ProductVo pvo= p2v(ppo);
			lsvp.add(pvo);
		}
		return lsvp;
	}
	private ProductVo p2v(Product ppo) {
		
		ProductVo pvo =new ProductVo();
		pvo.setId(ppo.getP_id());
		pvo.setPname(ppo.getP_name());
		pvo.setPprice(ppo.getP_price());
		pvo.setStorage(ppo.getStorage());
		pvo.setTypeId(ppo.getProducttype_id());
		pvo.setPicPath(ppo.getImage());
		pvo.setBrand(ppo.getBrand());
		return pvo;
	}
	
}
