package com.group6.b2c.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.group6.b2c.pojo.Code;

public class CodeDao extends BaseDao{
	
	public String findById(int id){
		String sql = "  select name from code where id=  ?   ";
		String[] args={id+""};
		Result r = query(sql, args);
		SortedMap[] sm = r.getRows();
		if (sm.length == 1) {
			return (String) sm[0].get("name");
		}else{
			return null;
		}
	}
	public List<Code> find(int p_id) {
		String sql = "  select name, id, parent_id from code where parent_id=  ?   ";
		String[] args={p_id+""};
		Result r = query(sql, args);
		List<Code> lcs = r2o(r);
		return lcs;
	}

	private List<Code> r2o(Result r) {
		List<Code> lcs = null;
		if (r == null || r.getRowCount() == 0) {
			return lcs;
		}
		lcs = new ArrayList<Code>();
		SortedMap[] sms = r.getRows();
		for (int i = 0; i < sms.length; i++) {
			SortedMap sm = sms[i];
			Code sp = r2o(sm);
			lcs.add(sp);
		}
		return lcs;
	}

	private Code r2o(SortedMap sm) {
		if (sm == null) {
			return null;
		}
		Code code = new Code();
		code.setName(sm.get("name").toString());// �п�
		code.setId(Integer.parseInt(sm.get("id").toString()));
		code.setParent_id(Integer.parseInt(sm.get("parent_id").toString()));
		return code;
	}

}
