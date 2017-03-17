package com.group6.b2c.service;



import java.util.ArrayList;
import java.util.List;

import com.group6.b2c.dao.ProductDao;
import com.group6.b2c.pojo.Product;
import com.group6.b2c.viewbean.ProductVo;



public class SearchService {
	
	
	public List<ProductVo> findByKeyWords(String keyword){
		List<ProductVo> lpv = null;	
		ProductDao pd = new ProductDao();
		List<Product> lpp = pd.findbyKeywords(keyword);	
		lpv = p2v(lpp);
		
		return lpv;
	}
	
	
	public List<ProductVo> findBytpid(int tpid){
		List<ProductVo> lpv = null;
		ProductDao pd = new ProductDao();
		List<Product> lpp = pd.findbypTypeId(tpid);
		lpv = p2v(lpp);
		return lpv;
	}

	private List<ProductVo> p2v(List<Product> lpp) {
		// TODO Auto-generated method stub
		List<ProductVo> lpv = null;
		if(lpp == null || lpp.size()==0){
			return lpv;
		}
		lpv = new ArrayList<ProductVo>();
		for(int i=0;i<lpp.size();i++){
			ProductVo pv = new ProductVo();
			pv = p2v(lpp.get(i));
			lpv.add(pv);
		}
		return lpv;
	}

	private ProductVo p2v(Product pp) {
		// TODO Auto-generated method stub
		ProductVo pv = new ProductVo();
		pv.setId(pp.getP_id());
		pv.setDesc(pp.getDesc());
		pv.setImgPath(pp.getImage());
		pv.setPrice(pp.getP_price());
		return pv;
	}
}
