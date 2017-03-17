package com.group6.b2c.service;


import java.text.DecimalFormat;
import java.util.List;

import com.group6.b2c.dao.CommentDao;
import com.group6.b2c.dao.ProductDao;
import com.group6.b2c.pojo.Comment;
import com.group6.b2c.viewbean.CommentVo;



public class CommentService {
	public String addComment(CommentVo cv){
		String res ="";
		Comment cp = v2p(cv);
		CommentDao cd = new CommentDao();
		ProductDao pd = new ProductDao();
		double agscore;
		List<Comment> lcp  = cd.findbypid(cv.getPid());
		if(lcp!=null){
		double totalScore = 0;
		for(int i=0;i<lcp.size();i++){
			totalScore += lcp.get(i).getScore();
		}
		
		agscore = (totalScore + cv.getScore())/(lcp.size()+1);
		}else{
			agscore=4.0;
		}
		
		DecimalFormat fnum = new DecimalFormat("##0.0"); 
		String as = fnum.format( agscore );
		
		if(cd.addComment(cp)!=-1 && pd.updateAvgScore(as, cv.getPid())!=-1);
			res = as;
		return res;
	}

	private Comment v2p(CommentVo cv) {
		// TODO Auto-generated method stub
		Comment cp = new Comment();
		cp.setContent(cv.getContent());
		cp.setPid(cv.getPid());
		cp.setScore(cv.getScore());
		cp.setTime(cv.getTime());
		cp.setUsername(cv.getName());		
		return cp;
	}
}
