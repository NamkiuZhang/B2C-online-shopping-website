package com.group6.b2c.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.group6.b2c.pojo.User;


public class UserDao extends BaseDao {

	public int addUser(User user) {
		int i = -1;
		String sql = "insert into usr(u_name, role_id, log_pwd, question, answer)"
				+ "values(  ?  ,  ?   ,  ?   ,  ?  ,  ?  )";
		String[] args = { user.getU_name(), 3 + "", user.getLog_pwd(),
				user.getQuestion(), user.getAnswer() };
		i = update(sql, args);
		return i;
	}

	public int modPwd(User user) {
		int i = -1;
		String username = user.getU_name();
		String password = user.getLog_pwd();
		String sql = "   update usr      set       log_pwd =   ?    where u_name = ?    ";
		String[] args = { password, username };
		i = update(sql, args);
		return i;
	}

	public SortedMap[] isUserExist(String username) {
		String sql = "select * from usr where u_name=  ?  ";
		String[] args = { username };
		Result result = query(sql, args);
		SortedMap[] sm = result.getRows();
		return sm;
	}

	public User findUserByUName(String username) {
		SortedMap[] sm = isUserExist(username);
		User user = null;
		if (sm.length == 1) {
			user = new User();
			user.setU_name(username);
			user.setLog_pwd(sm[0].get("log_pwd").toString());
			user.setQuestion(sm[0].get("question").toString());
			user.setAnswer(sm[0].get("answer").toString());
			user.setRole_id(Integer.parseInt(sm[0].get("role_id").toString()));
			user.setGender(sm[0].get("gender")==null?"":sm[0].get("gender").toString());
			user.setRealname(sm[0].get("real_name")==null?"":sm[0].get("real_name").toString());
		}
		return user;
	}
	
	public int setUserinfo(User user) {
		int i = -1;
		String username = user.getU_name();
		String gender=user.getGender();
		String realname=user.getRealname();
		String sql = "   update usr      set       gender =   ?   , real_name =  ?    where u_name = ?    ";
		String[] args = { gender,realname, username };
		i = update(sql, args);
		return i;
	}
	
	//查询所有管理员
    public List<User> findAllManager(){
    	String sql =" select * from usr where role_id =2 ";
    	Result r = query(sql, null);
    	List<User> lspm = r2o(r);
    	return lspm;
    	
    }

    private List<User> r2o(Result r) {
		 List<User> lspu = null;
		 if (r ==null || r.getRowCount()==0) {
			return lspu;
		}
		 lspu = new ArrayList<User>();
		 SortedMap[] sms = r.getRows();
		 for (int i = 0; i < sms.length; i++) {
			SortedMap sm = sms[i];
			User sp = r2o(sm);
			lspu.add(sp);
		}
		return lspu;
	}

	private User r2o(SortedMap sm) {
		if (sm==null) {
			return null;
		}
		User up =new User();
		up.setId( Integer.parseInt( sm.get("id").toString()));
		up.setU_name(  sm.get("u_name").toString() );//判空	
		up.setLog_pwd(  sm.get("log_pwd").toString());
		up.setRole_id( Integer.parseInt(sm.get("role_id").toString()));
		up.setQuestion( sm.get("question").toString());
		up.setAnswer( sm.get("answer").toString());
		return up;
	}
	
	//删除用户和管理员
	public int deleteUser(String u_name){
 	    String sql="delete from usr where u_name=  ? "; 
 	    String[] args = { u_name };
		int i = update(sql, args);	     
		return i;
	}
	
	//添加管理员
	public int addManager(User m){
		//判断用户名是否已经存在
		String sql="insert into Usr (id, u_name,log_pwd, role_id,question,answer) values(  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )";
		String[] args={2+"",m.getU_name(),m.getLog_pwd(),2+"",m.getQuestion(),m.getAnswer()};
		int i = update(sql, args);		
		return i;
	}
	
	public List<User> findCustomer(String u_name){
    	String sql =" select * from usr where role_id =3 and u_name  like   ?  ";
    	String []args={ "%"+u_name+"%"}; 
    	Result r = query(sql, args);
    	List<User> lspc = r2o(r);
    	return lspc;
    	
    }
	//用于查看用户和 管理员详细信息
   public User findOneUser(String name){
	   String sql = "select * from usr where u_name=  ?  ";
	   String []args ={ name };
	   Result r = query(sql,args);
	   List<User> lspu = r2o(r);
	   return lspu.get(0);
	   
   }

}
