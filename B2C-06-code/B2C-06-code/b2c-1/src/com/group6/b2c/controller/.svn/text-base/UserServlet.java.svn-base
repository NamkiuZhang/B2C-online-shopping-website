package com.group6.b2c.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.omg.CORBA.Request;

import com.group6.b2c.service.CartService;
import com.group6.b2c.service.CodeService;
import com.group6.b2c.service.ProductTypeService;
import com.group6.b2c.service.UserService;
import com.group6.b2c.viewbean.CodeVo;
import com.group6.b2c.viewbean.Ordervo;
import com.group6.b2c.viewbean.ProductTypeVo;
import com.group6.b2c.viewbean.UserVo;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class UserServlet extends HttpServlet {

	private final static char[] cs = { '1', '2', '3', '4', '5', '6', '7', '8',
			'9', '0' };
	Random random = new Random();
	String randomString;

	private String getRandomStirng() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int r = random.nextInt(cs.length);
			sb.append(cs[r]);
		}
		return sb.toString();
	}

	private Color getRandomColor() {
		Color c = new Color(random.nextInt(256), random.nextInt(256), random
				.nextInt(256));
		return c;
	}

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String code = req.getParameter("code");
		UserVo uvo = new UserVo();
		uvo.setAction(req.getParameter("action"));
		uvo.setQuestion(req.getParameter("question"));
		uvo.setAnswer(req.getParameter("answer"));
		if ("code".equals(code)) {
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doCode(req, resp);
		}
		if ("login".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doLogin(req, resp, uvo);
		} else if ("register".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doRegister(req, resp, uvo);
		} else if ("checkUserName".equals(uvo.getAction())) {
			UserVo uVo = new UserVo();
			uVo.setU_name(req.getParameter("username"));
			uVo.setLog_pwd(req.getParameter("password"));
			doCheckUserName(req, resp);
		} else if ("checkcode".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doCheckCode(req, resp);
		} else if ("logout".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doLogout(req, resp);
		} else if ("fpwd".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doFpwd(req, resp, uvo);
		} else if ("modpwd".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doModpwd(req, resp, uvo);
		} else if ("userinfo".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doUserinfo(req, resp);
		} else if ("setuserinfo".equals(uvo.getAction())) {
			uvo.setAction(req.getParameter("action"));
			uvo.setU_name(req.getParameter("username"));
			uvo.setLog_pwd(req.getParameter("password"));
			doSetUserinfo(req, resp);
		} else if ("listManager".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("managerName"));
			uvo.setLog_pwd(req.getParameter("managerPwd"));
			doLsManager(req, resp, uvo);
		} else if ("addManager".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("managerName"));
			uvo.setLog_pwd(req.getParameter("managerPwd"));
			doAddManager(req, resp, uvo);
		} else if ("queryCustomer".equals(uvo.getAction())) {
			uvo.setU_name(req.getParameter("managerName"));
			uvo.setLog_pwd(req.getParameter("managerPwd"));
			doQueryCustomer(req, resp, uvo);
		} else if ("deleteManager".equals(uvo.getAction())) {

			uvo.setU_name(req.getParameter("managerName"));
			uvo.setLog_pwd(req.getParameter("managerPwd"));
			doDeleteManager(req, resp, uvo);
		} else if ("listManagerDetails".equals(uvo.getAction())) {

			uvo.setU_name(req.getParameter("managerName"));
			uvo.setLog_pwd(req.getParameter("managerPwd"));
			doLsManagerDetails(req, resp, uvo);
		} else if ("deleteUser".equals(uvo.getAction())) {

			uvo.setU_name(req.getParameter("managerName"));
			uvo.setLog_pwd(req.getParameter("managerPwd"));
			doDeleteUser(req, resp, uvo);
		} else if ("listUserDetails".equals(uvo.getAction())) {

			uvo.setU_name(req.getParameter("managerName"));
			uvo.setLog_pwd(req.getParameter("managerPwd"));
			doLsUserDetails(req, resp, uvo);
		}
	}

	private void doSetUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserService();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		String gender = request.getParameter("gender");
		String realname = request.getParameter("realname");
		if (us.setUserinfo(username, gender, realname)) {
			request.getRequestDispatcher("/myHome.jsp").forward(request,
					response);
		}
	}

	private void doUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserService();
		CodeService cs = new CodeService();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		List<CodeVo> lcvs = cs.find(1);
		request.setAttribute("lcvs", lcvs);
		String ui[] = us.userinfo(username);
		if (ui[0] != null && ui[1] != null) {
			request.setAttribute("genderid", ui[0]);
			request.setAttribute("realname", ui[1]);
		}
		request.getRequestDispatcher("/userinfo.jsp")
				.forward(request, response);
	}

	private void doModpwd(HttpServletRequest request,
			HttpServletResponse response, UserVo uVo) throws ServletException,
			IOException {
		UserService us = new UserService();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		String password = uVo.getLog_pwd();
		if (us.modpwd(username, password)) {
			int role_id=UserService.login(username, password);
			if(role_id==3){
				request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			}else if (role_id==2) {
				request.getRequestDispatcher("/managerIndex.jsp").forward(request,
						response);
			}else{
				request.getRequestDispatcher("/adminIndex.jsp").forward(request,
						response);
			}
		} else {
			session.removeAttribute("user");
		}
	}

	private void doFpwd(HttpServletRequest request,
			HttpServletResponse response, UserVo uVo) throws ServletException,
			IOException {
		UserService us = new UserService();
		String pa[] = us.fpwd(uVo.getU_name());
		HttpSession session = request.getSession();
		session.setAttribute("user", uVo.getU_name());
		request.setAttribute("question", pa[0]);
		request.setAttribute("answer", pa[1]);
		request.getRequestDispatcher("/fpwd2.jsp").forward(request, response);
	}

	private void doLogout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try{
		session.removeAttribute("user");
		int roleid=Integer.parseInt(session.getAttribute("roleid").toString());
		if (roleid==3) {
			String sessionid = session.getAttribute("sessionid").toString();
			CartService cs = new CartService();
			List<Ordervo> lsvs =new ArrayList<Ordervo>();
			lsvs =cs.findProductsIntourCart(sessionid);
			if(lsvs==null){
				session.setAttribute("inumber",0);}
				else{
				session.setAttribute("inumber", lsvs.size());
			}   
		//	request.getRequestDispatcher("/i.jsp").forward(request, response);
			response.sendRedirect("/b2c-1/i.jsp");
		
		}else{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		}catch (Exception e) {
			response.sendRedirect("/b2c-1/i.jsp");
		}
		
	}

	private void doCheckCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("autocode");
		String result = "false";
		if (code.equals(randomString)) {
			result = "true";
		}
		System.out.println(randomString);
		response.getWriter().write(result);
	}

	private void doCode(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 1�������
		randomString = getRandomStirng();
		System.out.println(randomString);
		// 2��session r

		// 3������ͼƬ
		BufferedImage bi = new BufferedImage(50, 30, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.fillRect(0, 0, 50, 30);
		g.setColor(Color.RED);
		g.drawString(randomString, 5, 20);
		for (int i = 0; i < 10; i++) {
			g.setColor(getRandomColor());
			g.drawLine(random.nextInt(50), random.nextInt(30), random
					.nextInt(50), random.nextInt(30));
		}
		// 4����ӦͼƬ
		response.setContentType("image/JPEG");
		ServletOutputStream stream = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(stream);
		encoder.encode(bi);
		stream.flush();
		stream.close();

	}

	private void doCheckUserName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserService us = new UserService();
		String userName = request.getParameter("userName");
		String check = Boolean.toString(us.isUserExist(userName));
		response.getWriter().write(check);
	}

	private void doRegister(HttpServletRequest request,
			HttpServletResponse response, UserVo uVo) throws ServletException,
			IOException {
		UserService us = new UserService();
		HttpSession session=request .getSession();
		boolean b = us.register(uVo);
		if (b) {
			session.setAttribute("user", uVo.getU_name());
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else {
			System.out.println("false");
		}
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response, UserVo uVo) throws ServletException,
			IOException {
		String username = uVo.getU_name();
		String password = uVo.getLog_pwd();
		int role_id=UserService.login(username, password);
		if (role_id!=-1) {
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			ServletContext application = getServletContext();
			session.setAttribute("roleid", role_id);
			List<Ordervo> lsvs =new ArrayList<Ordervo>();
			CartService c = new CartService();
			lsvs = c.findall(username);
			if(lsvs==null){
				session.setAttribute("inumber",0);}
				else{
				session.setAttribute("inumber", lsvs.size());
			}   
			if (role_id == 3) {
				if ("mark".equals(request.getParameter("cookietime"))) {
					int seconds = 7 * 24 * 60 * 60;
					Cookie cookie = new Cookie("user", username + "=="
							+ password);
					cookie.setMaxAge(seconds);
					response.addCookie(cookie);
				}
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} else if (role_id == 2) {
				ProductTypeService pts=new ProductTypeService();
				List<ProductTypeVo> lptv=pts.find(0);
				application.setAttribute("lptv", lptv);
				request.getRequestDispatcher("/managerIndex.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher("/adminIndex.jsp").forward(
						request, response);
			}

		} else {
			String tip = "用户名与密码不匹配";
			request.setAttribute("tip", tip);
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

	// user details 收信地址什么的 没完工
	private void doLsUserDetails(HttpServletRequest req,
			HttpServletResponse resp, UserVo uvo) throws ServletException,
			IOException {

		UserService us = new UserService();
		UserVo uservo = us.findOneUser(uvo.getU_name());
		req.setAttribute("uservo", uservo);
		req.getRequestDispatcher("userDetails.jsp").forward(req, resp);
	}

	// 删除用户
	private void doDeleteUser(HttpServletRequest req, HttpServletResponse resp,
			UserVo uvo) throws ServletException, IOException {
		UserService us = new UserService();
		us.deleteUser(uvo.getU_name());
		req.getRequestDispatcher("queryCustomer.jsp").forward(req, resp);

	}

	// 查看管理员详细信息
	private void doLsManagerDetails(HttpServletRequest req,
			HttpServletResponse resp, UserVo uvo) throws ServletException,
			IOException {
		UserService us = new UserService();
		UserVo uservo = us.findOneUser(uvo.getU_name());
		req.setAttribute("uservo", uservo);
		req.getRequestDispatcher("managerDetails.jsp").forward(req, resp);
	}

	// 添加管理员
	private void doAddManager(HttpServletRequest req, HttpServletResponse resp,
			UserVo uvo) throws ServletException, IOException {
		//HttpSession session = req.getSession();
		UserService us = new UserService();
		if (us.addManager(uvo.getU_name(), uvo.getLog_pwd(), uvo.getQuestion(),
				uvo.getAnswer())) {
			
			PrintWriter out = resp.getWriter();	
			resp.setContentType("text/html");
            out.println("<SCRIPT   LANGUAGE='JavaScript'>");   	         
              out.println("alert('添加成功!');");   
              out.println("document.location.href='/b2c-1/addManager.jsp';");
            out.println("</SCRIPT>"); 
			//req.getRequestDispatcher("addManager.jsp").forward(req, resp);

		} else {
			PrintWriter out = resp.getWriter();	
			resp.setContentType("text/html");
            out.println("<SCRIPT   LANGUAGE='JavaScript'>");   	         
              out.println("alert('添加失败!');");   
              out.println("document.location.href='/b2c-1/addManager.jsp';");
            out.println("</SCRIPT>"); 
			
		}

	}

	// 查询所有管理员
	private void doLsManager(HttpServletRequest req, HttpServletResponse resp,
			UserVo svo) throws ServletException, IOException {
		UserService us = new UserService();
		List<UserVo> lsvm = us.findAllManager();
		req.setAttribute("lsvm", lsvm);
		req.getRequestDispatcher("queryManager.jsp").forward(req, resp);
	}

	// 删除管理员
	private void doDeleteManager(HttpServletRequest req,
			HttpServletResponse resp, UserVo uvo) throws ServletException,
			IOException {
		UserService us = new UserService();
		if(us.deleteUser(uvo.getU_name())){
			PrintWriter out = resp.getWriter();	
			resp.setContentType("text/html");
            out.println("<SCRIPT   LANGUAGE='JavaScript'>");   	         
              out.println("alert('删除成功!');");   
              out.println("document.location.href='/b2c-1/adminIndex.jsp';");
            out.println("</SCRIPT>"); 
		}else{
			PrintWriter out = resp.getWriter();	
			resp.setContentType("text/html");
            out.println("<SCRIPT   LANGUAGE='JavaScript'>");   	         
              out.println("alert('删除失败!');");   
              out.println("document.location.href='/b2c-1/adminIndex.jsp';");
            out.println("</SCRIPT>"); 
		  
		}
	}

	// 查询用户
	private void doQueryCustomer(HttpServletRequest req,
			HttpServletResponse resp, UserVo uvo) throws ServletException,
			IOException {
		UserService us = new UserService();
		List<UserVo> lsvc = us.queryCustomer(uvo.getU_name());
		req.setAttribute("lsvc", lsvc);
		req.getRequestDispatcher("listCustomer.jsp").forward(req, resp);
	}

}
