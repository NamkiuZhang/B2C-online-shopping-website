package com.group6.b2c.service;



import java.util.ArrayList;
import java.util.List;

import com.group6.b2c.dao.ProductDao;
import com.group6.b2c.dao.ProductTypeDao;
import com.group6.b2c.pojo.Product;
import com.group6.b2c.pojo.ProductType;
import com.group6.b2c.viewbean.IndexVo;
import com.group6.b2c.viewbean.ProductTypeVo;
import com.group6.b2c.viewbean.ProductVo;
import com.group6.b2c.viewbean.RecommendVo;



public class LoadService {

	public IndexVo getIndexVo() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		IndexVo iv = new IndexVo();
		List<ProductTypeVo> lptv = null;
		List<RecommendVo> recommends = null;
		List<ProductVo> hots = null;
		
		ProductTypeDao ptd = new ProductTypeDao();
		ProductDao pd = new ProductDao();
		lptv = p2v1(ptd.findFirstType());
		recommends = p2v2(pd.findRecommends());
		hots = p2v3(pd.findHots());
		
		iv.setFirstTypes(lptv);
		iv.setRecommends(recommends);
		iv.setHots(hots);
				
		return iv;
	}

	private List<ProductVo> p2v3(List<Product> lpp) {
		// TODO Auto-generated method stub
		List<ProductVo> lpv = null;
		if(lpp == null || lpp.size()==0){
			return lpv;
		}
		lpv = new ArrayList<ProductVo>();
		for(int i=0;i<lpp.size();i++){
			Product pp = lpp.get(i);
			ProductVo pv= p2v3(pp);
			lpv.add(pv);
		}	
		return lpv;
	}

	private ProductVo p2v3(Product pp) {
		// TODO Auto-generated method stub
		ProductVo pv = new ProductVo();
		pv.setDesc(pp.getDesc());
		pv.setId(pp.getP_id());
		pv.setImgPath(pp.getImage());
		pv.setPrice(pp.getP_price());		
		return pv;
	}

	private List<RecommendVo> p2v2(List<Product> lpp) {
		// TODO Auto-generated method stub
		List<RecommendVo> lrv =null;
		if(lpp == null || lpp.size()==0){
			return lrv;
		}
		lrv = new ArrayList<RecommendVo>();
		for(int i=0;i<lpp.size();i++){
			Product pp = lpp.get(i);
			RecommendVo rv = p2v2(pp);
			lrv.add(rv);
		}
		return lrv;
	}

	
	private RecommendVo p2v2(Product pp) {
		// TODO Auto-generated method stub
		RecommendVo rv = new RecommendVo();
		rv.setId(pp.getP_id());
		rv.setImgPath(pp.getImage());
		return rv;
	}

	private List<ProductTypeVo> p2v1(List<ProductType> lptp) {
		// TODO Auto-generated method stub
		List<ProductTypeVo> lptv = null;
		if(lptp==null || lptp.size() == 0){
			return lptv;
		}
		lptv = new ArrayList<ProductTypeVo>();
		for(int i=0;i<lptp.size();i++){
			ProductType ptp = lptp.get(i);
			ProductTypeVo ptv = p2v2(ptp);
			lptv.add(ptv);
		}
		return lptv;
	}
	private ProductTypeVo p2v2(ProductType ptp) {
		// TODO Auto-generated method stub
		ProductTypeVo ptv = new ProductTypeVo();
		ptv.setId(ptp.getId());
		ptv.setT_name(ptp.getName());
		return ptv;
	}

}
