package com.group6.b2c.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.group6.b2c.dao.CodeDao;
import com.group6.b2c.pojo.Code;
import com.group6.b2c.viewbean.CodeVo;

public class CodeService {

	public List<CodeVo> find(int p_id) {
		CodeDao cd = new CodeDao();

		List<Code> lcps = cd.find(p_id);
		List<CodeVo> lcvs = p2v(lcps);
		return lcvs;
	}

	private List<CodeVo> p2v(List<Code> lcps) {
		if (lcps == null || lcps.size() == 0) {
			return null;
		}
		List<CodeVo> lsvs = new ArrayList<CodeVo>();
		for (Iterator iterator = lcps.iterator(); iterator.hasNext();) {
			Code cpo = (Code) iterator.next();
			CodeVo cvo = p2v(cpo);
			lsvs.add(cvo);
		}
		return lsvs;
	}

	private CodeVo p2v(Code code) {
		CodeVo cvo = new CodeVo();
		cvo.setName(code.getName());
		cvo.setId(code.getId());
		cvo.setParentId(code.getParent_id());
		return cvo;
	}
}
