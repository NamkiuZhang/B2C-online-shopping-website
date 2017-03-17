package com.group6.b2c.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.group6.b2c.pojo.Comment;




public class CommentDao extends BaseDao{
	
	
	public int addComment(Comment cp){
		int res = -1;
		String sql = "insert into user_product( p_id, u_name, content, score, c_time) " +
				"values(  ? , ? , ? , ? , ? )";
		String[] args = {cp.getPid()+"",cp.getUsername(),cp.getContent(),cp.getScore()+"",cp.getTime()};
		res = this.update(sql, args);
		return res;
	}
	
	
	
	public List<Comment> findbypid(int pid){
		List<Comment> lcp = null;
		
		String sql = " select * from user_product where p_id  =  ?   order by c_time" ;
		String [] args  = { pid+"" };
		
		Result r = query(sql, args);
		lcp = r2o( r );
		return lcp;
		
	}

	private List<Comment> r2o(Result r) {
		// TODO Auto-generated method stub
		List<Comment> lcp = null ;
		if (r==null || r.getRowCount()==0) {
			return lcp;
		}
		lcp = new ArrayList<Comment>();
		SortedMap [] sms = r.getRows();
		for (int i = 0; i < sms.length; i++) {
			SortedMap sm = sms[i];
			Comment cp = r2o(sm);
			lcp.add(cp);
		}
		return lcp;
	}

	private Comment r2o(SortedMap sm) {
		// TODO Auto-generated method stub
		Comment cp =new Comment();
		cp.setCid(sm.get("id")==null?-1:(Integer.parseInt(sm.get("id").toString())));
		cp.setContent(sm.get("content")==null?"":sm.get("content").toString());
		cp.setPid(sm.get("p_id")==null?-1:(Integer.parseInt( sm.get("p_id").toString())));
		cp.setScore(sm.get("score")==null?-1:(Integer.parseInt( sm.get("score").toString())));
		cp.setTime(sm.get("c_time")==null?"":sm.get("c_time").toString());
		cp.setUsername(sm.get("u_name")==null?"":sm.get("u_name").toString());
		return cp;
	}
}
