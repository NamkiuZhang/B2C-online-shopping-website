package com.group6.b2c.service;



import java.util.ArrayList;
import java.util.List;

import com.group6.b2c.dao.CommentDao;
import com.group6.b2c.dao.ProductDao;
import com.group6.b2c.dao.ProductTypeDao;
import com.group6.b2c.pojo.Comment;
import com.group6.b2c.pojo.Product;
import com.group6.b2c.pojo.ProductType;
import com.group6.b2c.viewbean.CommentVo;
import com.group6.b2c.viewbean.ViewProductVo;



public class ViewProductService {
	
	public ViewProductVo getProductDetail(int pid){
		ViewProductVo vpv = new ViewProductVo();
		ProductDao pd = new ProductDao();
		CommentDao cd = new CommentDao();
		ProductTypeDao ptd = new ProductTypeDao();
		
		Product pp = pd.findbypid(pid);
		List<Comment> lcp = cd.findbypid(pid);
		ProductType ptp = ptd.findById(pp.getProducttype_id());
		
		
		List<CommentVo> lcv = p2v(lcp);	
		
		vpv.setTypename(ptp.getName());
		vpv.setAvgScore(pp.getAvg_score());
		vpv.setComments(lcv);
		
		vpv.setDesc(pp.getDesc());
		vpv.setImgPath(pp.getImage());
		vpv.setMarketTime(pp.getMarket_time()==""?"暂无信息":pp.getMarket_time());
		
		vpv.setName(pp.getP_name());
		vpv.setPrice(pp.getP_price());
		vpv.setSalesNum(pp.getSalesnum());
		vpv.setStorage(pp.getStorage());
		vpv.setId(pp.getP_id());
		
		vpv.setBrand(pp.getBrand()==""?"暂无信息":pp.getBrand());
		vpv.setColor(pp.getColor()==""?"暂无信息":pp.getColor());
		vpv.setGuarantee(pp.getGuarantee()==-1?"暂无信息":pp.getGuarantee()+"");
		
		vpv.setMaterial(pp.getMaterial()==""?"暂无信息":pp.getMaterial());
		vpv.setModel(pp.getModel()==""?"暂无信息":pp.getModel());
		vpv.setOrigin(pp.getOrigin()==""?"暂无信息":pp.getOrigin());
		vpv.setWeight(pp.getWeight()==-1?"暂无信息":pp.getWeight()+"");
		vpv.setCommentNum(lcv.size());
		
		return vpv;
	}

	
	private List<CommentVo> p2v(List<Comment> lcp) {
		List<CommentVo> lcv = new ArrayList<CommentVo>();;
		if(lcp==null || lcp.size()==0){
			return lcv;
		}
		for(int i=0;i<lcp.size();i++){
			Comment cp = lcp.get(i);
			CommentVo cv = p2v(cp);
			lcv.add(cv);
		}
		return lcv;
	}

	private CommentVo p2v(Comment cp) {
		CommentVo cv = new CommentVo();
		cv.setContent(cp.getContent());
		cv.setName(cp.getUsername());
		cv.setScore(cp.getScore());
		cv.setTime(cp.getTime());
		cv.setPid(cp.getPid());
		return cv;
	}

}
