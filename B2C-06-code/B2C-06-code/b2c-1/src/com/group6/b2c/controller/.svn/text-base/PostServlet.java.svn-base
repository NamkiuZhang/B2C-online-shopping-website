package com.group6.b2c.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.b2c.dao.AddressDao;
import com.group6.b2c.dao.CodeDao;
import com.group6.b2c.pojo.Address;
import com.group6.b2c.service.CodeService;
import com.group6.b2c.service.PostService;
import com.group6.b2c.viewbean.CodeVo;
import com.group6.b2c.viewbean.Postvo;



public class PostServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Postvo vo=new Postvo();
		
		if(request.getParameter("com")!=null){
			if(request.getParameter("iad")==null){
				 response.setContentType("text/html");
					PrintWriter out = response.getWriter();
		            out.println("<SCRIPT   LANGUAGE='JavaScript'>");   		         
		            out.println("alert('请选择地址'); history.go(-1)");   
		          
		            out.println("</SCRIPT>"); 
			}
			else{
				HttpSession session=request.getSession();
				String adsString=request.getParameter("iad");
				String[] a=adsString.split("\\|");
		    	 session.setAttribute("postin", a[0]+" "+a[1]+" "+a[2]+" "+a[3]+" "+a[4]);
			  session.setAttribute("postid", a[5]);
				response.sendRedirect("/b2c-1/iorder.jsp");
			}
		}else if(request.getParameter("change")!=null){			
			doAdd(request,response);
		}
		else{
			doList(request,response);
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
	
		String userName=session.getAttribute("user").toString();
		PostService ps=new PostService();	
		
		session.setAttribute("addresslist",ps.findall(userName));
		response.sendRedirect("/b2c-1/ipost.jsp");
		
	}

	private void doAdd(HttpServletRequest request,
		HttpServletResponse response) throws IOException {
		Address ads=new Address();
		HttpSession session=request.getSession();
		CodeDao cd=new CodeDao();
		 try{
		int a=Integer.parseInt(request.getParameter("cap"));
		int b=Integer.parseInt(request.getParameter("city"));
		int c=Integer.parseInt(request.getParameter("town"));
		
		String f_address=cd.findById(a)+" "+cd.findById(b)+" "+cd.findById(c);
		ads.setF_address(f_address);
		ads.setPost_number(Integer.parseInt(request.getParameter("postnumber")));
		ads.setS_address(request.getParameter("saddress"));
	
		String username=session.getAttribute("user").toString();
		ads.setUser_name(username);
		AddressDao ado=new AddressDao();
		ado.add(ads);	
		int id=ado.findKey(ads.getUser_name(), ads.getF_address(), 
				ads.getS_address(), ads.getPost_number());
		String postin=ads.getF_address()+" "+ads.getS_address()+" ";
		postin+=request.getParameter("receiver")+" "+request.getParameter("phone")+" "+ads.getPost_number();	
		session.setAttribute("postin", postin);
		session.setAttribute("postid", id);
		response.sendRedirect("/b2c-1/iorder.jsp");
		
	}catch (Exception e) {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println("<SCRIPT   LANGUAGE='JavaScript'>");   		         
        out.println("alert('请输入正确的信息'); history.go(-1)");   
      
        out.println("</SCRIPT>"); 
	}
	}
	
		
	


}
