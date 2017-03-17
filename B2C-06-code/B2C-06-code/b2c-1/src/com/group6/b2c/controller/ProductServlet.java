package com.group6.b2c.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.b2c.service.ProductService;
import com.group6.b2c.service.ViewProductService;
import com.group6.b2c.viewbean.ProductVo;

public class ProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ProductVo pvo = new ProductVo();
		pvo.setAction(req.getParameter("action"));
		if (req.getParameter("pro_id") != null) {

			int id = Integer.parseInt(req.getParameter("pro_id"));
			ViewProductService vp = new ViewProductService();
			HttpSession session = req.getSession();
			session.setAttribute("vpv", vp.getProductDetail(id));
			resp.sendRedirect("/b2c-1/product_detail.jsp");

		}
		if ("addProduct".equals(pvo.getAction())) {
			pvo.setPicPath(req.getParameter("img"));
			pvo.setTypeId(Integer.parseInt(req.getParameter("secondType")));
			pvo.setPname(req.getParameter("productName"));
			pvo.setPprice(Double.parseDouble(req.getParameter("price")));
			pvo.setStorage(Integer.parseInt(req.getParameter("amount")));
			doAddProdcut(req, resp, pvo);
		} else if ("listSellout".equals(pvo.getAction())) {
			dofindSellout(req, resp, pvo);
		} else if ("queryProduct".equals(pvo.getAction())) {
			pvo.setPname(req.getParameter("productName"));
			pvo.setTypeId(Integer.parseInt(req.getParameter("secondType")));
			doQueryProduct(req, resp, pvo);
		} else if ("listProductDetails".equals(pvo.getAction())) {
			pvo.setId(Integer.parseInt(req.getParameter("productId")));
			doListProductDetails(req, resp, pvo);
		} else if ("deleteProduct".equals(pvo.getAction())) {
			pvo.setId(Integer.parseInt(req.getParameter("productId")));
			doDeleteProduct(req, resp, pvo);
		} else if ("modifyProductInfo".equals(pvo.getAction())) {
			pvo.setId(Integer.parseInt(req.getParameter("productId")));
			doModifyProductInfo(req, resp, pvo);
		} else if ("updateProductInfo".equals(pvo.getAction())) {
			pvo.setId(Integer.parseInt(req.getParameter("productId")));
			System.out.println(req.getParameter("productId"));
			pvo.setPicPath(req.getParameter("img"));
			pvo.setTypeId(Integer.parseInt(req.getParameter("secondType")));
			pvo.setBrand(req.getParameter("brand"));
			pvo.setPname(req.getParameter("pname"));
			pvo.setPprice(Double.parseDouble(req.getParameter("pprice")));
			pvo.setStorage(Integer.parseInt(req.getParameter("storage")));
			doUpdateProductInfo(req, resp, pvo);
		}// 查询某分类下所有商品
		else if ("findAllPros".equals(pvo.getAction())) {
			pvo.setTypeId(Integer.parseInt(req.getParameter("secondType")));
			doFindAllPros(req, resp, pvo);
		}

	}

	private void doFindAllPros(HttpServletRequest req,
			HttpServletResponse resp, ProductVo pvo) throws ServletException,
			IOException {
		ProductService ps = new ProductService();
		List<ProductVo> lsvp = ps.findAllPros(pvo.getTypeId());
		req.setAttribute("lsvp", lsvp);
		req.getRequestDispatcher("queryProdClass.jsp").forward(req, resp);
	}

	// 得到修改后信息
	private void doUpdateProductInfo(HttpServletRequest req,
			HttpServletResponse resp, ProductVo pvo) throws ServletException,
			IOException {
		ProductService ps = new ProductService();
		
		if(ps.modifyProductInfo(pvo.getPicPath(), pvo.getPname(), pvo.getTypeId(),
				pvo.getPprice(), pvo.getStorage(), pvo.getBrand(), pvo.getId())){
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('修改成功!');");
			out.println("document.location.href='/b2c-1/queryProduct.jsp';");
			out.println("</SCRIPT>");
		}else{
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('修改失败!');");
			out.println("document.location.href='/b2c-1/queryProduct.jsp';");
			out.println("</SCRIPT>");
		//req.getRequestDispatcher("queryProduct.jsp").forward(req, resp);
		}
	}

	// 修改商品详细信息
	private void doModifyProductInfo(HttpServletRequest req,
			HttpServletResponse resp, ProductVo pvo) throws ServletException,
			IOException {
		ProductService ps = new ProductService();
		ProductVo productvo = ps.findOneProduct(pvo.getId());
		req.setAttribute("productvo", productvo);
		// ps.modifyProductInfo(pvo.getPicPath(), pvo.getPname(),
		// pvo.getTypeId(), pvo.getPprice(), pvo.getStorage(),
		// pvo.getBrand(),pvo.getPid());
		req.getRequestDispatcher("modifyProductInfo.jsp").forward(req, resp);
	}

	// 删除某个商品
	private void doDeleteProduct(HttpServletRequest req,
			HttpServletResponse resp, ProductVo pvo) throws ServletException,
			IOException {
		ProductService ps = new ProductService();
		if (ps.deleteProductByAdmin(pvo.getId())) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('删除成功!');");
			out.println("document.location.href='/b2c-1/queryProduct.jsp';");
			out.println("</SCRIPT>");
		} else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('在购物车中，不能删除!');");
			out.println("document.location.href='/b2c-1/queryProduct.jsp';");
			out.println("</SCRIPT>");
		}
	}

	// 查看某个产品详细信息
	private void doListProductDetails(HttpServletRequest req,
			HttpServletResponse resp, ProductVo pvo) throws ServletException,
			IOException {
		ProductService ps = new ProductService();
		ProductVo productvo = ps.findOneProduct(pvo.getId());
		req.setAttribute("productvo", productvo);
		req.getRequestDispatcher("productDetails.jsp").forward(req, resp);

	}

	// 查询特定商品--根据名称和分类
	private void doQueryProduct(HttpServletRequest req,
			HttpServletResponse resp, ProductVo pvo) throws ServletException,
			IOException {
		ProductService ps = new ProductService();
		List<ProductVo> lsvp = ps.queryProduct(pvo.getPname(), pvo.getTypeId());
		req.setAttribute("lsvp", lsvp);
		req.getRequestDispatcher("listProduct.jsp").forward(req, resp);

	}

	// 查询脱销产品
	private void dofindSellout(HttpServletRequest req,
			HttpServletResponse resp, ProductVo pvo) throws ServletException,
			IOException {
		ProductService ps = new ProductService();
		List<ProductVo> lsvp = ps.findSellout();
		req.setAttribute("lsvp", lsvp);
		req.getRequestDispatcher("querySoldout.jsp").forward(req, resp);

	}

	// 添加商品
	private void doAddProdcut(HttpServletRequest req, HttpServletResponse resp,
			ProductVo pvo) throws ServletException, IOException {
		ProductService ps = new ProductService();
		if (ps.addProduct(pvo.getPname(), pvo.getPprice(), pvo.getTypeId(), pvo
				.getStorage(), pvo.getPicPath())) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('添加成功!');");
			out.println("document.location.href='/b2c-1/addProduct.jsp';");
			out.println("</SCRIPT>");

		} else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('添加失败!');");
			out.println("document.location.href='/b2c-1/addProduct.jsp';");
			out.println("</SCRIPT>");
		}
	}

}
