package com.group6.b2c.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.group6.b2c.dao.CartDao;
import com.group6.b2c.service.CartService;
import com.group6.b2c.viewbean.Ordervo;
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators.ParentIterator;

public class CartServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Ordervo vo = new Ordervo();
		vo.setProduct_id(request.getParameter("oid") == null ? 0 : Integer
				.parseInt(request.getParameter("oid")));
		HttpSession session = request.getSession();
	
		if (request.getParameter("remo")!= null && request.getParameter("remo")!= "") {
			
			doRemove(request, response);
		} else if (request.getParameter("vau") != null && request.getParameter("vau")!= "") {
			if(request.getParameter("vau")!= "")
			doPay(request, response);
		}
		else if (request.getParameter("addtocart") != null) {
			doAddToCart(request, response); 
	}
		else {
			doList(request, response);
		}

	}
	private void doAddToCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int pro_id = Integer.parseInt(request.getParameter("selectid"));
		int quantity = Integer.parseInt(request.getParameter("quant"));
		CartService cs = new CartService();
		int s=cs.getStorage(pro_id,quantity);
		if(s!=-2){
			List<Ordervo> lsvs =new ArrayList<Ordervo>();
		if (session.getAttribute("user") == null) {
			
			String sessionid = session.getAttribute("sessionid").toString();
			cs.addCartByTour(sessionid, pro_id, quantity);
			 lsvs =cs.findProductsIntourCart(sessionid);
		} else {
			String name = session.getAttribute("user").toString();
			cs.addCartByUser(name, pro_id, quantity);
			lsvs = cs.findall(name);
		}
		if(lsvs==null){
			session.setAttribute("inumber",0);}
			else{
			session.setAttribute("inumber", lsvs.size());
		}   
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();			 
        out.println("<SCRIPT   LANGUAGE='JavaScript'>");   	         
        out.println("alert('成功添加到购物车!');");    
        out.println("document.location.href='/b2c-1/product_detail.jsp';");
      out.println("</SCRIPT>"); 
		}else{
			 response.setContentType("text/html");
				PrintWriter out = response.getWriter();			 
	        out.println("<SCRIPT   LANGUAGE='JavaScript'>");   	         
	        out.println("alert('商品库存不够!');");    
	        out.println("document.location.href='/b2c-1/product_detail.jsp';");
	      out.println("</SCRIPT>"); 
		}

	}

	private void doList(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		HttpSession s = request.getSession();
		CartService ss = new CartService();
		List<Ordervo> lsvs =new ArrayList<Ordervo>();
		if (s.getAttribute("user") == null) {
			String sessionid = s.getAttribute("sessionid").toString();
			 lsvs =ss.findProductsIntourCart(sessionid);
		} else {
			String userName = s.getAttribute("user").toString();		
			if(s.getAttribute("sessionid")!=null){
				String sessionid = s.getAttribute("sessionid").toString();
				ss.changeTourToUser(userName, sessionid);
			}
			lsvs = ss.findall(userName);
			
		}
		s.setAttribute("productincart", lsvs);
		if(lsvs==null){
			s.setAttribute("inumber",0);}
			else{
			s.setAttribute("inumber", lsvs.size());
		}   
		response.sendRedirect("/b2c-1/icart.jsp");

	}

	private void doRemove(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			IOException {
		HttpSession session = request.getSession();
		CartDao cd = new CartDao();
		if (session.getAttribute("user") != null) {
			int index=Integer.parseInt( request.getParameter("index"));
			int id=Integer .parseInt(request.getParameterValues("oid")[index]);
		  cd.removeProductFromCart(id);
		
		}else{
			int index=Integer.parseInt( request.getParameter("index"));
			int id=Integer .parseInt(request.getParameterValues("oid")[index]);
			String sessionid = session.getAttribute("sessionid").toString();
			cd.removeProductFromCartByTour(sessionid,id);
		}
		doList(request, response);
	}

	private void doPay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
		List<Ordervo> psList = new ArrayList<Ordervo>();
		if (request.getParameterValues("prod") == null
			) {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<SCRIPT   LANGUAGE='JavaScript'>");

			out.println("alert('请选择商品!');");
			out.println("document.location.href='/b2c-1/icart.jsp';");
			out.println("</SCRIPT>");

		} else {
			CartService cs = new CartService();
		
            boolean isEnough=true;
	       String nsString= request.getParameter("qindex");
	       String[] ins=new String[request.getParameterValues("prod").length];
	       if(nsString.equals("")){
	    	   for(int i=0;i<request.getParameterValues("prod").length;i++){
	    		   ins[i]=i+1+"";
	    	   }
	       }else{
	            ins=nsString.split("m");
	       }
			for (int i = 0; i < ins.length; i++) {
				
				int quantity=Integer.parseInt(request
						.getParameterValues("quantity")[Integer .parseInt(ins[i])-1]);
			    int pro_id=Integer.parseInt(request
						.getParameterValues("oid")[Integer .parseInt(ins[i])-1]);
				int s=cs.getStorage(pro_id,quantity);
				String pname=request.getParameterValues("na")[Integer .parseInt(ins[i])-1];
				if(s!=-2){
				Ordervo ordervo = new Ordervo();
				ordervo.setImage(request.getParameterValues("im")[Integer .parseInt(ins[i])-1]);
				ordervo.setProduct_id(pro_id);

				ordervo.setProduct_name(pname);
		
				ordervo.setProduct_price(Double.parseDouble(request
						.getParameterValues("price")[Integer .parseInt(ins[i])-1]));
				ordervo.setQuantity(quantity);
				ordervo.setTotal(Double.parseDouble(request
						.getParameterValues("eachTotal")[Integer .parseInt(ins[i])-1]));
				psList.add(ordervo);
				}else{
					isEnough=false;
				//	String infString=pname+"库存不够!";
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<SCRIPT   LANGUAGE='JavaScript'>");
					out.println("alert('库存不够');");
					out.println("document.location.href='/b2c-1/icart.jsp';");
					out.println("</SCRIPT>");
				}
			}
			if(isEnough){
			double sum = Double.parseDouble(request.getParameter("v"));
			session.setAttribute("sumvalue", sum);
			session.setAttribute("selectedpro", psList);
			response.sendRedirect("PostServlet");
			}
			
		}
	} else {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<SCRIPT   LANGUAGE='JavaScript'>");

		out.println("alert('您还未登陆!');");
		out.println("document.location.href='/b2c-1/icart.jsp';");
		out.println("</SCRIPT>");
	}
	}


}
