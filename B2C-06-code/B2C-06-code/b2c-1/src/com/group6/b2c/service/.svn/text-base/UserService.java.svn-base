package com.group6.b2c.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.group6.b2c.dao.UserDao;
import com.group6.b2c.pojo.User;
import com.group6.b2c.viewbean.UserVo;


public class UserService {

	public static int login(String username, String password) {
		UserDao ud = new UserDao();
		User user = ud.findUserByUName(username);
		if (user != null && user.getLog_pwd().equals(password)) {
			return user.getRole_id();
		}
		return -1;
	}

	public boolean modpwd(String username, String password) {
		UserDao ud = new UserDao();
		User user = new User();
		user.setU_name(username);
		user.setLog_pwd(password);
		if (ud.modPwd(user) == 1) {
			return true;
		}
		return false;
	}
	
	public String[] userinfo(String username){
		UserDao ud=new UserDao();
		User user = ud.findUserByUName(username);
		String[] ui = new String[2];
		if(user.getGender()!=""){
			ui[0]=user.getGender();
		}
		if(user.getRealname()!=""){
			ui[1]=user.getRealname();
		}
		return ui;
	}

	public boolean setUserinfo(String username, String gender, String realname){
		User user = new User();
		user.setU_name(username);
		user.setGender(gender);
		user.setRealname(realname);
		UserDao ud = new UserDao();
		if(ud.setUserinfo(user)==1){
			return true;
		}
		return false;
	}
	public String[] fpwd(String username) {
		UserDao ud = new UserDao();
		User user = ud.findUserByUName(username);
		String[] pa = new String[2];
		if (user != null) {
			pa[0] = user.getQuestion();
			pa[1] = user.getAnswer();
		}
		return pa;
	}

	public boolean isUserExist(String username) {
		UserDao ud = new UserDao();
		if (ud.isUserExist(username).length == 0) {
			return false;
		}
		return true;
	}

	public boolean register(UserVo uVo) {
		User user = new User();
		user.setU_name(uVo.getU_name());
		user.setLog_pwd(uVo.getLog_pwd());
		user.setQuestion(uVo.getQuestion());
		user.setAnswer(uVo.getAnswer());
		UserDao ud = new UserDao();
		int i = ud.addUser(user);
		if (i == 1) {
			return true;
		}
		return false;
	}

	public List<UserVo> findAllManager()
	{
		UserDao ud = new UserDao();
		List<User> lspm = ud.findAllManager();
		List<UserVo>  lsvm =p2v(lspm);//new ArrayList<StudentVo>();
		return  lsvm;
	}
	
	public boolean addManager(String mname,String pwd, String question, String answer){
		User m = new User();
		m.setU_name(mname);
		m.setLog_pwd(pwd);
		m.setQuestion(question);
		m.setAnswer(answer);
		UserDao md = new UserDao();
		int i = md.addManager(m);
		if(i==1){
			return true;
		}
		return false;
	}
	
	public List<UserVo> queryCustomer(String name){
		UserDao ud = new UserDao();
		List<User> lspc = ud.findCustomer(name);
		List<UserVo> lsvc = p2v(lspc);
		return lsvc;
	}
	
	public boolean deleteUser(String name){
		UserDao ud = new UserDao();
		if(ud.deleteUser(name)==1){
			return true;
		}
		return false;
	}
	
	private List<UserVo> p2v(List<User> lspm) {
		if (lspm==null ||  lspm.size()==0) {
			return null;
		} 
		List<UserVo>  lsvm =new ArrayList<UserVo>();
		 for (Iterator iterator = lspm.iterator(); iterator.hasNext();) {
			 User mpo = (User) iterator.next();
			 UserVo mvo= p2v(mpo);
			lsvm.add(mvo);
		}
		return lsvm;
	}
	private UserVo p2v(User mpo) {
		
		UserVo mvo =new UserVo();
		mvo.setU_id(mpo.getId());
		mvo.setU_name(mpo.getU_name());
		mvo.setLog_pwd((mpo.getLog_pwd()));
		mvo.setRole_id(mpo.getRole_id());
		mvo.setQuestion(mpo.getQuestion());
		mvo.setAnswer(mpo.getAnswer());
		return mvo;
	}

	public UserVo findOneUser(String name) {
		UserDao ud = new UserDao();	
		return p2v(ud.findOneUser(name));
	}
}
