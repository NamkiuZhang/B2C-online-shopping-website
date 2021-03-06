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

import com.group6.b2c.service.CartService;
import com.group6.b2c.service.UserService;
import com.group6.b2c.viewbean.Ordervo;

public class IndexFilter implements Filter {

        public void destroy() {
                // TODO Auto-generated method stub

        }

        public void doFilter(ServletRequest arg0, ServletResponse arg1,
                        FilterChain arg2) throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) arg0;
                HttpServletResponse response = (HttpServletResponse) arg1;
                Cookie[] cookies = request.getCookies();
                String[] cooks = null;
                String username = null;
                String password = null;
                if (cookies != null) {
                        for (Cookie coo : cookies) {
                                String aa = coo.getValue();
                                cooks = aa.split("==");
                                if (cooks.length == 2) {
                                        username = cooks[0];
                                        password = cooks[1];
                                }
                        }
                }
                if (UserService.login(username, password)!=-1) {
                        request.getSession().setAttribute("user",username);
                        List<Ordervo> lsvs =new ArrayList<Ordervo>();
                        CartService cs = new CartService();
                        lsvs = cs.findall(username);
                        if(lsvs==null){
                        	request.getSession().setAttribute("inumber",0);}
                			else{
                				request.getSession().setAttribute("inumber", lsvs.size());
                		}   
                        request.getSession().setAttribute("roleid", UserService.login(username, password));
                        response.sendRedirect("index.jsp");
                        
                }else{
                        arg2.doFilter(request,response );
                }
        

        }

        public void init(FilterConfig arg0) throws ServletException {
                // TODO Auto-generated method stub

        }

}
