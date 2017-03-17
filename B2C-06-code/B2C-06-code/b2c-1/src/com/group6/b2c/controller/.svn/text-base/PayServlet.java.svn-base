package com.group6.b2c.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.b2c.dao.PayDao;
import com.group6.b2c.pojo.Product;
import com.group6.b2c.service.OrderService;
import com.group6.b2c.service.ProductService;
import com.group6.b2c.viewbean.Ordervo;



public class PayServlet extends HttpServlet {

	

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
       if(request .getParameter("web")!=null)
		doPayByWeb(request,response );
       else if (request .getParameter("ship")!=null)
    	   doPayByShip(request ,response );
		
	}

	private void doPayByShip(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession  s=request .getSession();
		int id=Integer.parseInt(s.getAttribute("porderid").toString());
		OrderService orderService=new OrderService();
		orderService .payByShip(id);
		doDecreasenum(request,response);
	   response.sendRedirect("OrderServlet");	
	}

	private void doPayByWeb(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PayDao pdDao=new PayDao();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		String time=df.format(new Date());
		pdDao.addPayment(time, 10);
		HttpSession  s=request .getSession();
		int id=Integer.parseInt(s.getAttribute("porderid").toString());
		OrderService orderService=new OrderService();
		int payid=pdDao.findId(time,10);	
		orderService .addPayment(payid, id);
		orderService.changeStatusToPay(id);
		doDecreasenum(request,response);
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();
         out.println("<SCRIPT   LANGUAGE='JavaScript'>");    
         out.println("alert('操作成功')");   
         out.println("</SCRIPT>"); 
         response.sendRedirect("OrderServlet");
		
	}
	private void doDecreasenum(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession  s=request .getSession();
		ArrayList<Ordervo> ps=(ArrayList<Ordervo>) s.getAttribute("selectedpro");
	    ProductService pService=new ProductService();
	    for(Ordervo p:ps){    	
	        pService.updateStorage(p.getQuantity(), p.getProduct_id());
	        pService.updateSalenum(p.getQuantity(), p.getProduct_id());
	    }
	}


}
