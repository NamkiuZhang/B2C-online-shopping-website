package com.group6.b2c.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.group6.b2c.pojo.Product;




public class ProductDao extends BaseDao {

	public Product findByKey(int id){
		List<Product> lds=new ArrayList<Product>();
		String sql="select * from product where p_id = ? ";
		String[] args={id+""};
		Result result = query(sql, args);
		lds = r2o(result);
		return lds.get(0);
	}
	public List<Product> findInCart(int cartID){
		List<Product> lds=new ArrayList<Product>();
		String sql = "select * from  product where p_id in (select p_id from cart_product where cart_id= ? )";
		String[] args={cartID+""};
		Result result = query(sql, args);
		lds = r2o(result);
		return lds;
	}
	public List<Product> findInOrder(int orderID){
		List<Product> lds=new ArrayList<Product>();
		String sql = "select * from product where p_id in (select p_id from order_pro where order_id= ? )";
		String[] args={orderID+""};
		Result result = query(sql, args);
		lds = r2o(result);
		return lds;
	}
	private List<Product> r2o(Result result) {
		if (result == null ||result.getRowCount() == 0) {
			return null;			
		}
		List<Product> lds = new ArrayList<Product>();
		SortedMap[] sms = result.getRows();
		for (int i = 0; i < result.getRowCount(); i++) {
			SortedMap sm =sms[i];
			Product d = r2o(sm);
			lds.add(d);
			
		}
		return lds;
	}
	

	public int updateAvgScore(String score,int pid){
		int res = -1;
		String url = "UPDATE Product set avg_score = ? where p_id = ? ";
		String[] args = {score,pid+""};
		res = this.update(url, args);		
		return res;		
	}

	public int addProduct(Product pp){
		int res = -1;
		String sql = "insert into product (p_id, p_name, p_price, market_time, avg_score, " +
				"storagee, salesnum, producttype_id, img, material, " +
				"guaranteee, weight, brand, origin, color, modell, descc) values" +
				"( ? , ? , ? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ? , ? )";
		String[] args = {pp.getP_id()+"",pp.getP_name(),pp.getP_price()+"",pp.getMarket_time(),
				pp.getAvg_score()+"",pp.getStorage()+"",pp.getSalesnum()+"",pp.getProducttype_id()+"",
				pp.getImage(),pp.getMaterial(),pp.getGuarantee()+"",pp.getWeight()+"",
				pp.getBrand(),pp.getOrigin(),pp.getColor(),pp.getModel(),pp.getDesc()};
		res = this.update(sql, args);
		return res;
	}
	
	public Product findbypid(int pid){
		List<Product> lpp = null;
		String sql = "select * from product where p_id = ? ";
		String[] args = {pid+""};

		Result r = query(sql, args);
		lpp = r2o( r );
		return lpp.get(0);
	}
	
	
	public List<Product> findbyKeywords(String keywords){
		List<Product> lpp = null;
		String sql = "select * from product where p_name like ? or descc like ? or producttype_id in " +
				"(select id from producttype where pt_name like ? )";
		String[] args = {"%"+keywords+"%","%"+keywords+"%","%"+keywords+"%"};
		Result r = query(sql, args);
		lpp = r2o( r );
		return lpp;
	}
	

	public List<Product> findbypTypeId(int pTypeId){
		List<Product> lpp = null;
		
		String sql = "select * from product where producttype_id in" +
				"( select id from producttype where parent_id =  ?  ) or producttype_id = ? ";
		String[] args = {pTypeId+"", pTypeId+""};

		Result r = query(sql, args);
		lpp = r2o( r );
		return lpp;
	}
	

	

	
	public List<Product> findRecommends(){
		List<Product> lpp =null;
		String sql = "select * from ( select * from product order by avg_score desc) where rownum <=5";
		Result r = query(sql, null);
		lpp = r2o( r );		
		return lpp;
	}
	
	public List<Product> findHots(){
		List<Product> lpp =null;
		String sql = "select * from ( select * from product order by salesnum desc) where rownum <=30";
		Result r = query(sql, null);
		lpp = r2o( r );		
		return lpp;
	}
		

	private Product r2o(SortedMap sm) {
		// TODO Auto-generated method stub
		//p_id, p_name, p_price, market_time, avg_score, storagee, salesnum, producttype_id, 
		//img, material, guaranteee, weight, brand, origin, color, modell
		if(sm == null|| sm.size() == 0)
		{
			return null;
		}
		Product pp = new Product();
		pp.setAvg_score(sm.get("avg_score")==null?-1:Double.parseDouble(sm.get("avg_score").toString()));
		pp.setImage(sm.get("img")==null? "":sm.get("img").toString());
		pp.setMarket_time(sm.get("market_time")==null? "":sm.get("market_time").toString());
		pp.setP_id(sm.get("p_id")==null?-1:Integer.parseInt(sm.get("p_id").toString()));
		pp.setP_name(sm.get("p_name")==null? "":sm.get("p_name").toString());
		pp.setP_price(sm.get("p_price")==null?-1:Double.parseDouble(sm.get("p_price").toString()));
		pp.setProducttype_id(sm.get("producttype_id")==null?-1:Integer.parseInt(sm.get("producttype_id").toString()));
		pp.setSalesnum(sm.get("salesnum")==null?0:Integer.parseInt(sm.get("salesnum").toString()));
		pp.setStorage(sm.get("storagee")==null?0:Integer.parseInt(sm.get("storagee").toString()));
		pp.setSalesnum(sm.get("salesnum")==null?0:Integer.parseInt(sm.get("salesnum").toString()));
		pp.setStorage(sm.get("storagee")==null?-1:Integer.parseInt(sm.get("storagee").toString()));
		pp.setMaterial(sm.get("material")==null?"":sm.get("material").toString());
		pp.setGuarantee(sm.get("guaranteee")==null?-1:Integer.parseInt( sm.get("guaranteee").toString()));
		pp.setWeight(sm.get("weight")==null?-1:Double.parseDouble( sm.get("weight").toString()));
		
		pp.setBrand(sm.get("brand")==null?"":sm.get("brand").toString());
		pp.setOrigin(sm.get("origin")==null?"":sm.get("origin").toString());
		pp.setColor(sm.get("color")==null?"":sm.get("color").toString());
		pp.setModel(sm.get("modell")==null?"":sm.get("modell").toString());
		pp.setDesc(sm.get("descc")==null?"":sm.get("descc").toString());
		return pp;
	}

	
	// 添加商品
	public int addProduct(String name, double price, int typeId,int storage,String img) {
		// 加一判断商品名，时候是否存在；
		String sql = "insert into Product( p_name,p_price,producttype_id, storagee,img) values(  ? , ? , ? , ? , ?  )";
		String[] args = { name, price+"", typeId+"", storage+"", img };
		int i = update(sql, args);
		return i;
	}

	// 查询脱销产品
	public List<Product> findSellout() {
		String sql = " select * from product where storagee = 0 ";
		Result r = query(sql, null);
		List<Product> lspp = r2o(r);
		return lspp;

	}
   //查询商品
	public List<Product> queryProduct(String name, int ptId){
		String sql="select * from product where p_name like ?   and producttype_id=  ?  ";
		String []args={ "%"+name+"%" , ptId+""};
		Result r = query(sql, args);
    	List<Product> lspp = r2o(r);
    	return lspp;	
	}
	
	//查询二级分类下的所有商品
	public List<Product> findAllPros(int typeId){
		List<Product> lpp =null;
		String sql = "select *  from product where producttype_id  =  ? ";
		String[] args = {typeId+""};
		Result r = query(sql, args);
		lpp = r2o( r );
		return lpp;
		
	}
	
	//查看商品信息
	public Product findOneProduct(int id){
		String sql="select * from product where p_id =  ?  ";
	    String []args = { id+"" };
		Result r = query(sql,args);
		List<Product> lspp = r2o(r);
		return lspp.get(0);
		
	}
	
	//修改商品信息
	public int modifyProductInfo(String img, String name, int typeId,  double price,int storage, String brand ,int pid){
		String sql="update product set img = ?  , p_name= ?  , producttype_id =　?　,　 p_price =  ?  , storagee = ?  , brand =  ?　 where p_id = 　? ";
		String []args = { img, name, typeId+"", price+"", storage+"", brand , pid+"" };
		int i = update(sql, args);
		System.out.println(i);
		return i;
		
	}
	
	//删除商品
	public int deleteProduct(int id){
		 String sql="delete from product where p_id=  ? "; 
	 	 String[] args = { id+"" };
	     int i = update(sql, args);	     
		return i;
	}
	public int getStorage(int id){
		int i=-1;
		 String sql="select  storagee from product where p_id=  ? "; 
	 	 String[] args = { id+"" };
	 	Result result = query(sql,args);	
		SortedMap[] sms = result.getRows();
		if(sms.length>0)
		i= sms[0].get("storagee")==null?-1:
			Integer.parseInt(sms[0].get("storagee").toString());
		return i;     
		
	}
	public int getSalesnum(int id){
		int i=-1;
		 String sql="select  salesnum from product where p_id=  ? "; 
	 	 String[] args = { id+"" };
	 	Result result = query(sql,args);	
		SortedMap[] sms = result.getRows();
		if(sms.length>0)
		i= sms[0].get("salesnum")==null?-1:
			Integer.parseInt(sms[0].get("salesnum").toString());
		return i;     
		
	}
	public int updateStorage(int storage,int id){
		int res = -1;
		String url = "UPDATE Product set storagee = ? where p_id = ? ";
		String[] args = {storage+"",id+""};
		res = this.update(url, args);		
		return res;	
	}
	public int updateSalenum(int num,int id){
		int res = -1;
		String url = "UPDATE Product set salesnum = ? where p_id = ? ";
		String[] args = {num+"",id+""};
		res = this.update(url, args);		
		return res;	
	}
	public List<Product> findAllproductsInOrder(){
		List<Product> lds=new ArrayList<Product>();
		String sql = "select * from product where p_id in (select p_id from cart_product )";
		Result result = query(sql, null);
		lds = r2o(result);
		return lds;
	}
	public List<Product> findAllproductsInCart(){
		List<Product> lds=new ArrayList<Product>();
		String sql = "select * from product where p_id in (select p_id from order_pro )";
		Result result = query(sql, null);
		lds = r2o(result);
		return lds;
	}

	

}

