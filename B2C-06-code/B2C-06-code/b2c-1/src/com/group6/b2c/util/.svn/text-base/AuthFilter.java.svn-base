package com.group6.b2c.util;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.b2c.service.CartService;
import com.group6.b2c.viewbean.Ordervo;

public class AuthFilter implements Filter {

	public void init(FilterConfig filterconfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		 HttpServletRequest r  = (HttpServletRequest) servletrequest;
		 HttpSession session = r.getSession();
		 HttpServletResponse response=(HttpServletResponse) servletresponse;
		 String sessionid=session.getId();
		 boolean hasCook=false;
		  Cookie[] cookies = r.getCookies( );
		  List<Ordervo> lsvs =new ArrayList<Ordervo>();
		  CartService cs = new CartService();
		  if (cookies != null){
			  for (int i = 0; i < cookies.length; i++){
	               if (cookies[i].getName( ).equals("sessionid")){
	            	   String id=cookies[i].getValue();
	            	   session.setAttribute("sessionid", id);            	   
	            	   hasCook =true;
	            	   lsvs =cs.findProductsIntourCart(id);
	               }
	               
	               }
			  if(hasCook==false){
				  Cookie cookie = new Cookie("sessionid",sessionid);
				  session.setAttribute("sessionid", sessionid);
				  cookie.setMaxAge(-1);
				  response.addCookie(cookie);
				  
			  }
			
			  
			  if(lsvs.size()==0){
					session.setAttribute("inumber",0);}
					else{
					session.setAttribute("inumber", lsvs.size());
				}   
			
		  }else{		
			  Cookie cookie = new Cookie("sessionid",sessionid);
			  session.setAttribute("sessionid", sessionid);
			  cookie.setMaxAge(-1);
			  response.addCookie(cookie);
			  
		  }
		  
		  filterchain.doFilter(servletrequest, servletresponse);
		  response.sendRedirect("index.jsp");
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
