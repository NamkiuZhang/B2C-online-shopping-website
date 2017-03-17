package com.group6.b2c.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.b2c.service.ProductTypeService;
import com.group6.b2c.viewbean.ProductTypeVo;


public class ProductTypeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ProductTypeVo ptvo = new ProductTypeVo();
		ptvo.setAction(req.getParameter("action"));
		
		//if (req.getParameter("parentId") != null)
			//ptvo.setParent_id(Integer.parseInt(req.getParameter("parentId")));
		ptvo.setT_name(req.getParameter("type"));

		if ("addFirstType".equals(ptvo.getAction())) {
			ptvo.setParent_id(Integer.parseInt(req.getParameter("parentId")));
			doAddProdcutType(req, resp, ptvo);
		} if ("addSecondType".equals(ptvo.getAction())) {
			ptvo.setParent_id(Integer.parseInt(req.getParameter("firstType")));
			doAddProdcutType(req, resp, ptvo);
		}else if ("modifyFirstTypeName".equals(ptvo.getAction())) {
			ptvo.setId(Integer.parseInt(req.getParameter("firstType1")));
			doModifyTypeName(req, resp, ptvo);
		}else if ("modifySecondTypeName".equals(ptvo.getAction())) {
			ptvo.setId(Integer.parseInt(req.getParameter("secondType")));
			doModifyTypeName(req, resp, ptvo);
		} else if ("deleteFirstType".equals(ptvo.getAction())) {
			ptvo.setId(Integer.parseInt(req.getParameter("firstType3")));
			doDeleteType(req, resp, ptvo);
		}else if ("deleteSecondType".equals(ptvo.getAction())) {
			ptvo.setId(Integer.parseInt(req.getParameter("secondType")));
			doDeleteType(req, resp, ptvo);
		} else if("getSubType".equals(ptvo.getAction())){
			doGetSubtype(req, resp, ptvo);
		} else if("listFirstType".equals(ptvo.getAction())){
			doListFirstType(req,resp,ptvo);
		}/*列出一级分类下的二级目录
		else if("listSecondType".equals(ptvo.getAction())){
			ptvo.setT_name(req.getParameter("firstType"));
			doListSecondTy0pe(req,resp,ptvo);
		}*/
		
		
		/*else if("displaySubmenu".equals(ptvo.getAction())){
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			
			String fc = req.getParameter("ptid");
				ProductTypeService ss = new ProductTypeService();	
				List<ProductTypeVo> lptv = ss.getSubmenu(Integer.parseInt(fc));
				String res = "";
				if(lptv!=null){
					for(int i=0;i<lptv.size() && i<7;i++){
						res += lptv.get(i).getT_name()+","+lptv.get(i).getId();
						if(i!=lptv.size()-1 && i!=6){
							res += ";";
						}
					}
				}
			out.write(res);
			out.flush();
			out.close();
		}*/
	}
	/*列出一级分类下的二级目录
	private void doListSecondTy0pe(HttpServletRequest req,
			HttpServletResponse resp, ProductTypeVo ptvo) throws ServletException, IOException {
		ProductTypeService pts=new ProductTypeService();
		List<ProductTypeVo> lptv=pts.findSubByParenttypeName(ptvo.getT_name());
		req.setAttribute("lptv", lptv);
		req.getRequestDispatcher("queryProdClass.jsp").forward(req, resp);
	}*/

	// �޸ķ������
	private void doModifyTypeName(HttpServletRequest req,
			HttpServletResponse resp, ProductTypeVo ptvo)
			throws ServletException, IOException {
		ProductTypeService pts = new ProductTypeService();
		if (pts.modifyType(ptvo.getT_name(), ptvo.getId())) {
			//req.getRequestDispatcher("modiDelClass.jsp").forward(req, resp);
			ServletContext application = getServletContext();
			List<ProductTypeVo> lptv=pts.find(0);
			application.setAttribute("lptv", lptv);
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('修改成功!');");
			out.println("document.location.href='/b2c-1/modiDelClass.jsp';");
			out.println("</SCRIPT>");
		} else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('修改失败!');");
			out.println("document.location.href='/b2c-1/modiDelClass.jsp';");
			out.println("</SCRIPT>");

		}

	}

	// ��ӷ���
	private void doAddProdcutType(HttpServletRequest req,
			HttpServletResponse resp, ProductTypeVo ptvo)
			throws ServletException, IOException {
		ProductTypeService pts = new ProductTypeService();
		if (pts.addProductType(ptvo.getT_name(), ptvo.getParent_id())) {
			ServletContext application = getServletContext();
			List<ProductTypeVo> lptv=pts.find(0);
			application.setAttribute("lptv", lptv);
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('添加成功!');");
			out.println("document.location.href='/b2c-1/addProdClass.jsp';");
			out.println("</SCRIPT>");
			//req.getRequestDispatcher("addProdClass.jsp").forward(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('添加失败!');");
			out.println("document.location.href='/b2c-1/addProdClass.jsp';");
			out.println("</SCRIPT>");

		}

	}

	// ɾ�����
	private void doDeleteType(HttpServletRequest req, HttpServletResponse resp,
			ProductTypeVo ptvo) throws ServletException, IOException {
		ProductTypeService pts = new ProductTypeService();
		if (pts.deleteType(ptvo.getId())) {
			ServletContext application = getServletContext();
			List<ProductTypeVo> lptv=pts.find(0);
			application.setAttribute("lptv", lptv);
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('删除成功!');");
			out.println("document.location.href='/b2c-1/deleteProductType.jsp';");
			out.println("</SCRIPT>");
			//req.getRequestDispatcher("deleteProductType.jsp").forward(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('删除失败!');");
			out.println("document.location.href='/b2c-1/deleteProductType.jsp';");
			out.println("</SCRIPT>");
		}

	}
	
	private void doGetSubtype(HttpServletRequest request,
			HttpServletResponse response, ProductTypeVo ptvo) throws IOException {
		ProductTypeService pts=new ProductTypeService();
		List<ProductTypeVo> lptv=pts.find(Integer.parseInt(request.getParameter("id")));
		if (lptv.size()==0) {			
		}
		 else {
			StringBuffer sb = new StringBuffer(lptv.get(0).getT_name().toString());
			sb.append(",");
			sb.append(lptv.get(0).getId());			
			for (int i =1 ; i < lptv.size(); i++) {
				sb.append(";");
				sb.append(lptv.get(i).getT_name().toString());
				sb.append(",");
				sb.append(lptv.get(i).getId());
				System.out.println(sb);
			}
			response.getWriter().write(sb.toString());			
		}
		
	}
	private void doListFirstType(HttpServletRequest request,
			HttpServletResponse response, ProductTypeVo ptvo) throws ServletException, IOException {
		
		ProductTypeService pts=new ProductTypeService();
		List<ProductTypeVo> lptv=pts.find(0);
		System.out.print(lptv.get(1).getT_name());
		request.setAttribute("lptv", lptv);
		request.getRequestDispatcher("modiDelClass.jsp").forward(request, response);
	}

}
