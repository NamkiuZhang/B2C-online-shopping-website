package com.group6.b2c.service;



import java.util.ArrayList;
import java.util.List;

import com.group6.b2c.dao.ProductTypeDao;
import com.group6.b2c.pojo.ProductType;
import com.group6.b2c.viewbean.ProductTypeVo;



public class SubmenuService {
	public List<ProductTypeVo> getSubmenu(int pid){
		ProductTypeDao ptd = new ProductTypeDao();
		List<ProductType> lptp = ptd.findbyparentid(pid);
		
		List<ProductTypeVo> lptv = p2v1(lptp);
		return lptv;
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
