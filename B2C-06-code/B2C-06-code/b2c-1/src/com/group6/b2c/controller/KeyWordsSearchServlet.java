package com.group6.b2c.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.b2c.service.SearchService;
import com.group6.b2c.viewbean.ProductVo;



public class KeyWordsSearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public KeyWordsSearchServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		doPost(request,response);
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String keywords = request.getParameter("keywords");
		keywords =   new String(keywords.getBytes("iso-8859-1"), "utf-8" ); 
	
		int space = keywords.indexOf(" ");
		
		if(space != -1){
			keywords = keywords.substring(0, space);
		}
		
		SearchService ss = new SearchService();
		
		List<ProductVo> lpv = ss.findByKeyWords(keywords);
		
		HttpSession session = request.getSession();
		if(lpv==null || lpv.size()==0){
			session.setAttribute("nohint", "找不到与"+keywords+"相关的商品！");
		}
		session.setAttribute("lpv", lpv);
		request.getRequestDispatcher("products_list.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
