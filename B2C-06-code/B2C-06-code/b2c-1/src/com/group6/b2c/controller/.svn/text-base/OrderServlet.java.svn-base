package com.group6.b2c.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.b2c.dao.CartDao;
import com.group6.b2c.dao.PayDao;
import com.group6.b2c.pojo.Order;
import com.group6.b2c.pojo.Payment;
import com.group6.b2c.service.OrderService;
import com.group6.b2c.viewbean.Ordersvo;
import com.group6.b2c.viewbean.Ordervo;

public class OrderServlet extends HttpServlet {

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

		Ordersvo svoOrdersvo = new Ordersvo();
		svoOrdersvo.setAction(request.getParameter("action"));
	
		if (request.getParameter("search") != null) {
			int orderid = request.getParameter("orderid") == null ? 0 : Integer
					.parseInt(request.getParameter("orderid"));
			svoOrdersvo.setOrderID(orderid);
			
			doSearch(request, response);
		} else if (request.getParameter("printit") != null) {
			int orderid = request.getParameter("orderid") == null ? 0 : Integer
					.parseInt(request.getParameter("orderid"));
			svoOrdersvo.setOrderID(orderid);
			doPrint(request, response, svoOrdersvo);
		} else if (request.getParameter("comfirm") != null) {
			int orderid = request.getParameter("orderid") == null ? 0 : Integer
					.parseInt(request.getParameter("orderid"));
			svoOrdersvo.setOrderID(orderid);
			doConfirm(request, response, svoOrdersvo);
		} else if (request.getParameter("move") != null) {
			int orderid = request.getParameter("orderid") == null ? 0 : Integer
					.parseInt(request.getParameter("orderid"));
			svoOrdersvo.setOrderID(orderid);
			doMove(request, response, svoOrdersvo);
		} else if (request.getParameter("create") != null) {
			int orderid = request.getParameter("orderid") == null ? 0 : Integer
					.parseInt(request.getParameter("orderid"));
			svoOrdersvo.setOrderID(orderid);
			doCreate(request, response);
		} else if (request.getParameter("action") != null) {
			if ("findOrder".equals(svoOrdersvo.getAction())) {
				if (!request.getParameter("orderId").equals(""))
					svoOrdersvo.setOrderID(Integer.parseInt(request
							.getParameter("orderId")));
				doLsOrder(request, response, svoOrdersvo.getOrderID());
			} else if ("findMSOrder".equals(svoOrdersvo.getAction())) {
				if (!request.getParameter("orderId").equals(""))
					svoOrdersvo.setOrderID(Integer.parseInt(request
							.getParameter("orderId")));
				doLsMSOrder(request, response, svoOrdersvo.getOrderID());
			} else if ("findDeOrder".equals(svoOrdersvo.getAction())) {
				if (!request.getParameter("orderId").equals(""))
					svoOrdersvo.setOrderID(Integer.parseInt(request
							.getParameter("orderId")));
				doLsDeOrder(request, response, svoOrdersvo.getOrderID());
			} else if ("deleteOrder".equals(svoOrdersvo.getAction())) {
				if (!request.getParameter("orderId").equals(""))
					svoOrdersvo.setOrderID(Integer.parseInt(request
							.getParameter("orderId")));
				doDeleteOrder(request, response, svoOrdersvo);
			} else if ("changeStatus".equals(svoOrdersvo.getAction())) {
				if (!request.getParameter("orderId").equals(""))
					svoOrdersvo.setOrderID(Integer.parseInt(request
							.getParameter("orderId")));
				// svoOrdersvo.setHasBornDays(Integer.parseInt(request.getParameter("")));
				svoOrdersvo.setStatus(request.getParameter("status"));
				doChangeOrderStatus(request, response, svoOrdersvo);
			} else {
				int orderid = request.getParameter("orderid") == null ? 0
						: Integer.parseInt(request.getParameter("orderid"));
				svoOrdersvo.setOrderID(orderid);
				int oid = Integer.parseInt(request.getParameter("action"));
				doDetails(request, response, oid);
			}
		} else if (request.getParameter("payit") != null) {
			int orderid = request.getParameter("orderid") == null ? 0 : Integer
					.parseInt(request.getParameter("orderid"));
			svoOrdersvo.setOrderID(orderid);
			
			doPay(request, response, svoOrdersvo);
		} else {
			doListOrders(request, response);

		}

	}

	private void doPrint(HttpServletRequest request,
			HttpServletResponse response, Ordersvo svo) throws IOException {
		HttpSession session = request.getSession();
		List<Ordervo> odList = new ArrayList<Ordervo>();
		OrderService oService = new OrderService();
		odList = oService.findProductInOrder(svo.getOrderID());
		session.setAttribute("printorder", odList);
		response.sendRedirect("/b2c-1/print.jsp");
	}

	private void doPay(HttpServletRequest request,
			HttpServletResponse response, Ordersvo svo) throws IOException {
		OrderService os = new OrderService();
		int id = svo.getOrderID();

		if (os.findByKey(id).getStatus().equals("未支付")) {
			HttpSession session = request.getSession();
			session.setAttribute("porderid", id);
			Double  sum=0.0;
			List<Ordervo> or=new ArrayList<Ordervo>();
			or=os.findProductInOrder(id);
			for(Ordervo o:or){
				sum+=o.getTotal();
			}
			session.setAttribute("sumvalue", sum);
			session.setAttribute("selectedpro", or);
			response.sendRedirect("/b2c-1/ipay.jsp");
		

		} else if (os.findByKey(id).getStatus().equals("未支付,已发货")) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('宝贝正在路上!');");
			out.println("document.location.href='/b2c-1/iorders.jsp';");
			out.println("</SCRIPT>");
		} else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('您已支付!');");
			out.println("document.location.href='/b2c-1/iorders.jsp';");
			out.println("</SCRIPT>");
		}

	}

	private void doDetails(HttpServletRequest request,
			HttpServletResponse response, int orderid) throws IOException {
		HttpSession session = request.getSession();
		List<Ordervo> odList = new ArrayList<Ordervo>();
		OrderService oService = new OrderService();
		odList = oService.findProductInOrder(orderid);
		session.setAttribute("orderdetail", odList);
		response.sendRedirect("/b2c-1/ordetail.jsp");
	}

	private void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		OrderService osOrderService = new OrderService();
		Order order = new Order();
		order.setAddress_id(Integer.parseInt(session.getAttribute("postid")
				.toString()));
		String[] resString = session.getAttribute("postin").toString().split(
				" ");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		order.setBorn_time(df.format(new Date()));
		CartDao cDao = new CartDao();

		String userName = session.getAttribute("user").toString();
		order.setCart_id(cDao.findCartIDByUser(userName));
		order.setReceiver(resString[2]);
		order.setReceriver_phone(resString[3]);
		order.setStatus("未支付");
		order.setUser_name(userName);
		String[] ids = request.getParameterValues("proid");
		String[] quas = request.getParameterValues("quantities");
		int orderid = osOrderService.addOrder(order, ids, quas);
		CartDao cdCartDao = new CartDao();
		for (int j = 0; j < ids.length; j++) {
			cdCartDao.removeProductFromCart(Integer.parseInt(ids[j]));
		}
		session.setAttribute("porderid", orderid);
		response.sendRedirect("/b2c-1/ipay.jsp");
	}

	private void doConfirm(HttpServletRequest request,
			HttpServletResponse response, Ordersvo o) throws IOException {
		int id = o.getOrderID();
		OrderService orderService = new OrderService();
		int i = orderService.changeStatusToConfirm(id);
		if (i == -2) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('您还未支付!');");
			out.println("document.location.href='/b2c-1/iorders.jsp';");
			out.println("</SCRIPT>");
		} else if (i == -3) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('您已确认!');");
			out.println("document.location.href='/b2c-1/iorders.jsp';");
			out.println("</SCRIPT>");
		} else if (i == -4) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('还未发货!');");
			out.println("document.location.href='/b2c-1/iorders.jsp';");
			out.println("</SCRIPT>");
		} else {
			response.sendRedirect("OrderServlet");
		}

	}

	private void doMove(HttpServletRequest request,
			HttpServletResponse response, Ordersvo o) throws IOException {
		OrderService os = new OrderService();
		os.RemoveById(o.getOrderID());
		response.sendRedirect("OrderServlet");
	}

	private void doListOrders(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			String userName = session.getAttribute("user").toString();
			OrderService ss = new OrderService();
			List<Ordersvo> ors = ss.findall(userName);

			HttpSession s = request.getSession();
			s.setAttribute("orders", ors);
			response.sendRedirect("/b2c-1/iorders.jsp");
		} else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('您还未登陆!');");
			out.println("document.location.href='/b2c-1/login.jsp';");
			out.println("</SCRIPT>");
		}

	}

	private void doSearch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();

		String userName = session.getAttribute("user").toString();
		OrderService OS = new OrderService();
		try {
			int oid = request.getParameter("searchid") == null ? 0 : Integer
					.parseInt(request.getParameter("searchid").toString());
			if (oid != 0) {
				HttpSession s = request.getSession();
				ArrayList<Ordersvo> ors = new ArrayList<Ordersvo>();
				OrderService osOrderService = new OrderService();
				Ordersvo nOrdersvo = osOrderService.findByKey(oid);
				if (nOrdersvo != null) {
					ors.add(nOrdersvo);
					s.setAttribute("orders", ors);
					response.sendRedirect("/b2c-1/iorders.jsp");
				} else {
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<SCRIPT   LANGUAGE='JavaScript'>");
					out.println("alert('该订单不存在!');");
					out.println("document.location.href='/b2c-1/iorders.jsp';");
					out.println("</SCRIPT>");
				}
			} else {
				response.sendRedirect("/b2c-1/iorders.jsp");
			}
		} catch (NumberFormatException e) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('请输入数字!');");
			out.println("document.location.href='/b2c-1/iorders.jsp';");
			out.println("</SCRIPT>");
		}

	}

	// 梦娇的部分
	private void doLsDeOrder(HttpServletRequest req, HttpServletResponse resp,
			int id) throws ServletException, IOException {
		OrderService os = new OrderService();
		Ordersvo ovo = new Ordersvo();

		System.out.println("status == " + req.getParameterValues("status"));
		System.out.println("id == " + req.getParameter("orderId"));
		if (req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") == null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('请输入订单号或选择订单类型!');");
			out.println("</SCRIPT>");
			System.out.println("no input");
		} else if (!req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") == null) {
			HttpSession session = req.getSession();
			ovo.setOrderID(Integer.parseInt(req.getParameter("orderId")));
			List<Ordersvo> lsvodelete = os.findOrderById(id);
			session.setAttribute("lsvodelete", lsvodelete);
			System.out.println("only ID！");
			resp.sendRedirect("/b2c-1/listFinishedOrder.jsp");
		} else if (req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") != null) {
			HttpSession session = req.getSession();
			String[] values = req.getParameterValues("status");
			List<Ordersvo> lsvodelete = os.findOrderByStatus(values);
			session.setAttribute("lsvodelete", lsvodelete);
			System.out.println("only status！");
			resp.sendRedirect("/b2c-1/listFinishedOrder.jsp");
		} else if (!req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") != null) {
			HttpSession session = req.getSession();
			ovo.setOrderID(Integer.parseInt(req.getParameter("orderId")));
			String[] values = req.getParameterValues("status");
			List<Ordersvo> lsvodelete = os.findOrder(id, values);
			session.setAttribute("lsvodelete", lsvodelete);
			System.out.println("both！");
			resp.sendRedirect("/b2c-1/listFinishedOrder.jsp");
		}
		//resp.sendRedirect("/b2c-1/listFinishedOrder.jsp");
		// req.getRequestDispatcher("listFinishedOrder.jsp").forward(req, resp);
	}

	// 查询可以修改状态的订单
	private void doLsMSOrder(HttpServletRequest req, HttpServletResponse resp,
			int id) throws IOException, ServletException {
		OrderService os = new OrderService();
		Ordersvo ovo = new Ordersvo();

		System.out.println("status == " + req.getParameterValues("status"));
		System.out.println("id == " + req.getParameter("orderId"));
		if (req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") == null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('请输入订单号或选择订单类型!');");
			out.println("</SCRIPT>");
			out.println("<a href='../modifyOrderStatus.jsp'>点击返回</a>");
			System.out.println("no input");
		} else if (!req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") == null) {
			HttpSession session = req.getSession();
			ovo.setOrderID(Integer.parseInt(req.getParameter("orderId")));
			List<Ordersvo> lsvomodify = os.findOrderById(id);
			session.setAttribute("lsvomodify", lsvomodify);
			System.out.println("only ID！");
			resp.sendRedirect("/b2c-1/listOrderWithSC.jsp");
			// req.getRequestDispatcher("listOrderWithSC.jsp").forward(req,
			// resp);
		} else if (req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") != null) {
			HttpSession session = req.getSession();
			String[] values = req.getParameterValues("status");
			List<Ordersvo> lsvomodify = os.findOrderByStatus(values);
			session.setAttribute("lsvomodify", lsvomodify);

			System.out.println("only status！");
			resp.sendRedirect("/b2c-1/listOrderWithSC.jsp");
			// req.getRequestDispatcher("listOrderWithSC.jsp").forward(req,
			// resp);
		} else if (!req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") != null) {
			HttpSession session = req.getSession();
			ovo.setOrderID(Integer.parseInt(req.getParameter("orderId")));
			String[] values = req.getParameterValues("status");
			List<Ordersvo> lsvomodify = os.findOrder(id, values);
			session.setAttribute("lsvomodify", lsvomodify);
			System.out.println("both！");
			resp.sendRedirect("/b2c-1/listOrderWithSC.jsp");
			// req.getRequestDispatcher("listOrderWithSC.jsp").forward(req,
			// resp);
		}

	}

	// 查询订单
	private void doLsOrder(HttpServletRequest req, HttpServletResponse resp,
			int id) throws ServletException, IOException {
		OrderService os = new OrderService();
		Ordersvo ovo = new Ordersvo();

		System.out.println("status == " + req.getParameterValues("status"));
		System.out.println("id == " + req.getParameter("orderId"));
		if (req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") == null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('请输入订单号或选择订单类型!');");
			out.println("</SCRIPT>");
			out.println("<a href='../queryOrder.jsp'>点击返回</a>");

			System.out.println("no input");
		} else if (!req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") == null) {
			ovo.setOrderID(Integer.parseInt(req.getParameter("orderId")));
			HttpSession session = req.getSession();
			List<Ordersvo> lsvo = os.findOrderById(id);
			session.setAttribute("lsvo", lsvo);
			System.out.println("only ID！");
			resp.sendRedirect("/b2c-1/listOrder.jsp");
			// req.getRequestDispatcher("listOrder.jsp").forward(req, resp);
		} else if (req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") != null) {
			HttpSession session = req.getSession();
			String[] values = req.getParameterValues("status");
			List<Ordersvo> lsvo = os.findOrderByStatus(values);
			session.setAttribute("lsvo", lsvo);
			System.out.println("only status！");
			resp.sendRedirect("/b2c-1/listOrder.jsp");
			// req.getRequestDispatcher("listOrder.jsp").forward(req, resp);
		} else if (!req.getParameter("orderId").equals("")
				&& req.getParameterValues("status") != null) {
			HttpSession session = req.getSession();
			ovo.setOrderID(Integer.parseInt(req.getParameter("orderId")));
			String[] values = req.getParameterValues("status");
			List<Ordersvo> lsvo = os.findOrder(id, values);
			session.setAttribute("lsvo", lsvo);
			System.out.println("both！");
			resp.sendRedirect("/b2c-1/listOrder.jsp");
			// req.getRequestDispatcher("listOrder.jsp").forward(req, resp);
		}

	}

	private void doChangeOrderStatus(HttpServletRequest req,
			HttpServletResponse resp, Ordersvo ovo) throws ServletException,
			IOException {
		OrderService os = new OrderService();
		System.out.println(ovo.getStatus());
		System.out.println(ovo.getHasBornDays());
		if (ovo.getStatus().equals("已支付")) {
			os.changeStatus(ovo.getStatus(), ovo.getOrderID());

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			PayDao pDao = new PayDao();
			String time = df.format(new Date());
			pDao.addPayment(time, 10);
			int payid = pDao.findId(time, 10);
			os.addPayment(payid, ovo.getOrderID());
			os.changeStatus(ovo.getStatus(), ovo.getOrderID());
		}
		if (ovo.getStatus().equals("已作废")) {
			if (ovo.getHasBornDays() < 10) {
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html");
				out.println("<SCRIPT   LANGUAGE='JavaScript'>");
				out.println("alert('还未超过十天');");		
				out.println("</SCRIPT>");
				
			}else{
				os.changeStatus(ovo.getStatus(), ovo.getOrderID());
			}

		}
		
		HttpSession s = req.getSession();
		List<Ordersvo> lsvomodify = os.findOrderById(ovo.getOrderID());

		s.setAttribute("lsvomodify", lsvomodify);
		resp.sendRedirect("/b2c-1/listOrderWithSC.jsp");

		// req.getRequestDispatcher("listOrderWithSC.jsp").forward(req, resp);
	}

	private void doDeleteOrder(HttpServletRequest req,
			HttpServletResponse resp, Ordersvo ovo) throws ServletException,
			IOException {
		OrderService os = new OrderService();
		if (os.deleteOrder(ovo.getOrderID())) {
			HttpSession session=req.getSession();
			String[] aStrings=new String[2];
			aStrings[0]=ovo.getStatus();
			List<Ordersvo> lsvodelete = os.findOrder(ovo.getOrderID(),aStrings );
			session.setAttribute("lsvodelete", lsvodelete);
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('删除成功!');");
			out.println("document.location.href='/b2c-1/deleteOrder.jsp';");
			out.println("</SCRIPT>");
		} else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<SCRIPT   LANGUAGE='JavaScript'>");
			out.println("alert('删除失败!');");
			out.println("document.location.href='/b2c-1/deleteOrder.jsp';");
			out.println("</SCRIPT>");
			// req.getRequestDispatcher("listFinishedOrder.jsp").forward(req,
			// resp);
			// resp.sendRedirect("/b2c-1/listFinishedOrder.jsp");
		}
	}

}
