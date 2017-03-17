package com.group6.b2c.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.faces.application.Application;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.group6.b2c.dao.AddressDao;
import com.group6.b2c.dao.CodeDao;
import com.group6.b2c.pojo.Address;
import com.group6.b2c.pojo.Code;
import com.group6.b2c.service.AddressService;
import com.group6.b2c.service.CodeService;
import com.group6.b2c.viewbean.AddressVo;
import com.group6.b2c.viewbean.CodeVo;

public class AddressServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddressServlet() {
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

		AddressVo avo=new AddressVo();
		avo.setAction(request.getParameter("action"));
		if ("listaddress".equals(avo.getAction())) {
			doListaddress(request,response);
		}else if ("delete".equals(avo.getAction())) {
			doDeleteAddress(request,response);
		}else if ("getnextposition".equals(avo.getAction())) {
			doGetNextPosition(request,response);
		}else if ("add".equals(avo.getAction())) {
			doAdd(request,response,avo);
		}else if("listua".equals(avo.getAction())){
			doListua(request,response);
		}else if ("mod".equals(avo.getAction())) {
			doMod(request,response,avo);
		}
	}

	private void doMod(HttpServletRequest request,
			HttpServletResponse response, AddressVo avo) throws ServletException, IOException {
		AddressService as=new AddressService();
		CodeDao cd=new CodeDao();
		if("0".equals(request.getAttribute("cap"))){
			String f_address=request.getParameter("oldaddr");
			avo.setF_address(f_address);			
		}else{
			int a=Integer.parseInt(request.getParameter("cap"));
			int b=Integer.parseInt(request.getParameter("city"));
			int c=Integer.parseInt(request.getParameter("town"));
			String f_address=cd.findById(a)+" "+cd.findById(b)+" "+cd.findById(c);
			avo.setF_address(f_address);
		}
		avo.setS_address(request.getParameter("road"));
		avo.setPost_number(Integer.parseInt(request.getParameter("post")));
		avo.setId(Integer.parseInt(request.getParameter("id")));
		if(as.modAddress(avo)){
			doListaddress(request, response);
		}
	}

	private void doListua(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		AddressDao ad=new AddressDao();
		String[] addr=ad.findById(id);
		request.setAttribute("addr", addr);
		request.setAttribute("id", id);
		request.getRequestDispatcher("modAddress.jsp").forward(request, response);
	}

	private void doAdd(HttpServletRequest request,
			HttpServletResponse response, AddressVo avo) throws ServletException, IOException {
		AddressService as=new AddressService();
		CodeDao cd=new CodeDao();
		int a=Integer.parseInt(request.getParameter("cap"));
		int b=Integer.parseInt(request.getParameter("city"));
		int c=Integer.parseInt(request.getParameter("town"));
		String f_address=cd.findById(a)+" "+cd.findById(b)+" "+cd.findById(c);
		avo.setF_address(f_address);
		avo.setS_address(request.getParameter("road"));
		avo.setPost_number(Integer.parseInt(request.getParameter("post")));
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("user");
		avo.setUser_name(username);
		if (as.address(avo)) {
			doListaddress(request, response);
		}
	}

	private void doGetNextPosition(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		CodeService cs=new CodeService();
		List<CodeVo> lcs=cs.find(Integer.parseInt(request.getParameter("id")));
		if (lcs.size()==0) {			
		}
		 else {
			StringBuffer sb = new StringBuffer(lcs.get(0).getName().toString());
			sb.append(",");
			sb.append(lcs.get(0).getId());
			for (int i =1 ; i < lcs.size(); i++) {	
				sb.append(";");
				sb.append(lcs.get(i).getName().toString());
				sb.append(",");
				sb.append(lcs.get(i).getId());				
			}
			response.getWriter().write(sb.toString());			
		}
		
	}

	private void doDeleteAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int aid=Integer.parseInt(request.getParameter("aid"));
		AddressDao ad=new AddressDao();
		if (ad.delete(aid)==1) {
			doListaddress(request, response);
		}else {
			System.out.println("aaaaaaaa");
		}
		
	}

	private void doListaddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("user");
		AddressDao ad=new AddressDao();
		List<Address> las=ad.findByKey(username);
		request.setAttribute("las", las);
		request.getRequestDispatcher("useraddress.jsp").forward(request, response);
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
