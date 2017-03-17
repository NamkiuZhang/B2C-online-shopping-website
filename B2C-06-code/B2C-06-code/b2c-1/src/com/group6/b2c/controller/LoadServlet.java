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

import com.group6.b2c.service.CodeService;
import com.group6.b2c.service.LoadService;
import com.group6.b2c.viewbean.CodeVo;
import com.group6.b2c.viewbean.IndexVo;
import com.group6.b2c.viewbean.ProductTypeVo;
import com.group6.b2c.viewbean.ProductVo;
import com.group6.b2c.viewbean.RecommendVo;



public class LoadServlet extends HttpServlet {
	public static final String PARENT = "http://localhost:8080/b2c2/imgs/";
	/**
	 * Constructor of the object.
	 */
	public LoadServlet() {
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
		ServletContext application = getServletContext();
		CodeService cs=new CodeService();
		List<CodeVo> lcs=cs.find(4);				
		application.setAttribute("lcs", lcs);
		List<CodeVo> lcvsq = cs.find(2);
		application.setAttribute("lcvsq", lcvsq);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("action");
			LoadService ls = new LoadService();
			HttpSession session = request.getSession();
			IndexVo iv = ls.getIndexVo();	
			String res = "";
			if("index".equals(type)){				
				List<ProductTypeVo> lptv = iv.getFirstTypes();
				if(lptv!=null){
					for(int i=0;i<lptv.size() && i<6;i++){//6 is the max number of first type
						res += lptv.get(i).getT_name()+","+lptv.get(i).getId();					
						if(!(i==lptv.size()-1 || i==5)){
							res += ";";
						}
					}
					session.setAttribute("tpid", "nima");
				}
				res += "|";
				List<RecommendVo> lrv = iv.getRecommends();
				if(lrv!=null){
					for(int i=0;i<5;i++){
						if(i<lrv.size()){
							res += lrv.get(i).getImgPath()+","+lrv.get(i).getId();
						}else{
							res += lrv.get(lrv.size()-1).getImgPath()+","+lrv.get(lrv.size()-1).getId();	
						}
						if(i!=4){
							res += ";";
						}
					}
				}
				res += "|";
				List<ProductVo> hots = iv.getHots();
				if(hots!=null){
					for(int i=0;i<30;i++){
						if(i<hots.size()){
							res += hots.get(i).getImgPath()+"," +
									hots.get(i).getDesc()+"," +
									hots.get(i).getPrice()+","+hots.get(i).getId();
						}else{
							res += hots.get(hots.size()-1).getImgPath()+"," +
									hots.get(hots.size()-1).getDesc()+"," +
									hots.get(hots.size()-1).getPrice()+","+hots.get(hots.size()-1).getId();
						}
						if(i!=29){
							res += ";";
						}
					}
				}	
			}else if("list_detail".equals(type)){
				List<ProductTypeVo> lptv = iv.getFirstTypes();
				if(lptv!=null){
					for(int i=0;i<lptv.size() && i<6;i++){//6 is the max number of first type
						res += lptv.get(i).getT_name()+","+lptv.get(i).getId();
						if(!(i==lptv.size()-1 || i==5)){
							res += ";";
						}
					}
				}
			}else{
				System.out.println("LoadServlet,doPost,Wrong parameter!");
			}
		out.write(res);	
		
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
