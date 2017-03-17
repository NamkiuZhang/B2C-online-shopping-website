package com.group6.b2c.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.group6.b2c.dao.ProductTypeDao;
import com.group6.b2c.pojo.ProductType;
import com.group6.b2c.viewbean.ProductTypeVo;

public class ProductTypeService {
	//��Ӳ�Ʒ����
	public boolean addProductType(String ptname, int pid){
		ProductTypeDao ptd = new ProductTypeDao();
		if(1==ptd.addProductType(pid,ptname)){
			return true;
		}
		return false;
	}
	//�޸Ĳ�Ʒ���
	public boolean modifyType(String ptname, int id){
		ProductTypeDao ptd = new ProductTypeDao();
		if(1==ptd.modifyTypeName(ptname,id)){
			return true;
		}
		return false;
	}
	
	//ɾ�����
   public boolean deleteType(int id){
	   ProductTypeDao ptd = new ProductTypeDao();
	  
	   if(ptd.findChildenType(id)!=null){
		   return false;
	   }
	   if(1==ptd.deleteType(id)){
		   return true;
	   }
	   return false;
	   
	   
   }
   
   //����
   /*public List<ProductTypeVo> getSubmenu(int pid){
		ProductTypeDao ptd = new ProductTypeDao();
		List<ProductTypePo> lptp = ptd.findbyparentid(pid);
		
		List<ProductTypeVo> lptv = p2v1(lptp);
		return lptv;
	} 
	
	
	private List<ProductTypeVo> p2v1(List<ProductTypePo> lptp) {
		// TODO Auto-generated method stub
		List<ProductTypeVo> lptv = null;
		if(lptp==null || lptp.size() == 0){
			return lptv;
		}
		lptv = new ArrayList<ProductTypeVo>();
		for(int i=0;i<lptp.size();i++){
			ProductTypePo ptp = lptp.get(i);
			ProductTypeVo ptv = p2v2(ptp);
			lptv.add(ptv);
		}
		return lptv;
	}

	private ProductTypeVo p2v2(ProductTypePo ptp) {
		// TODO Auto-generated method stub
		ProductTypeVo ptv = new ProductTypeVo();
		ptv.setId(ptp.getId());
		ptv.setT_name(ptp.getT_name());
		ptv.setParent_id(ptp.getParent_id());
		return ptv;
	}*/
   /*查询一级分类下所有子分类
   public List<ProductTypeVo>  findSubByParenttypeName(String ptname){
	   ProductTypeDao ptd = new ProductTypeDao();
		List<ProductType> lptp = ptd.findSubByParenttypeName(ptname);
		List<ProductTypeVo> lptv = p2v(lptp);
		return lptv;
	}*/
   
   public List<ProductTypeVo> find(int p_id) {
	   ProductTypeDao cd = new ProductTypeDao();

		List<ProductType> lptp = cd.find(p_id);
		List<ProductTypeVo> lptv = p2v(lptp);
		return lptv;
	}

   
   
	private List<ProductTypeVo> p2v(List<ProductType> lptp) {
		if (lptp == null || lptp.size() == 0) {
			return null;
		}
		List<ProductTypeVo> lsvs = new ArrayList<ProductTypeVo>();
		for (Iterator iterator = lptp.iterator(); iterator.hasNext();) {
			ProductType ptp = (ProductType) iterator.next();
			ProductTypeVo ptv = p2v(ptp);
			lsvs.add(ptv);
		}
		return lsvs;
	}

	private ProductTypeVo p2v(ProductType ptp) {
		ProductTypeVo ptv = new ProductTypeVo();
		ptv.setT_name(ptp.getName());
		ptv.setId(ptp.getId());
		ptv.setParent_id(ptp.getParentid());
		return ptv;
	}
}
