package com.group6.b2c.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.b2c.service.CommentService;
import com.group6.b2c.viewbean.CommentVo;
import com.sun.org.apache.bcel.internal.generic.NEW;



public class CommentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommentServlet() {
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
		HttpSession session = request.getSession();
		String username= (String)session.getAttribute("user");
		if(username==null){
			out.write("请先登录！");
		}else{
			String score = request.getParameter("score");
			String cc = request.getParameter("commentcontent");
	
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

			String pid = request.getParameter("pid");
			
			
			cc =   new String(cc.getBytes("iso-8859-1"), "utf-8" ); 
			
			
			
			
			CommentVo cv = new CommentVo();
			cv.setContent(cc);
			cv.setPid(Integer.parseInt(pid));
			cv.setScore(Integer.parseInt(score));
			cv.setTime(date);
			cv.setName(username);
			
			
			
			
			CommentService cs = new CommentService();
			String res = cs.addComment(cv);
			if(res==""){
				out.write("评论提交失败！");
			}else{
				out.write("评论提交成功！|"+res);
			}
		}
	
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
