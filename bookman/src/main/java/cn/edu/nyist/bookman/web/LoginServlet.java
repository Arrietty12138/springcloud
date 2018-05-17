package cn.edu.nyist.bookman.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.nyist.Admin.Biz.AdimnBiz;
import cn.edu.nyist.Admin.Biz.impl.AdminBizImpl;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String vcode = request.getParameter("vcode");
		HttpSession session = request.getSession();
		String serverVcode = (String) session.getAttribute("Validcode");
		if (!serverVcode.equalsIgnoreCase(vcode)) {
			request.setAttribute("msg", "ÑéÖ¤Âë´íÎó");
			request.setAttribute("name", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		AdimnBiz adminBiz=new AdminBizImpl();
		boolean ret=adminBiz.findAdminByNameAndPwd(name,pwd);
		if(ret) {
			response.sendRedirect("main.jsp");
		}else {
			
			//µÇÂ¼Ê§°Ü
				request.setAttribute("msg", "ÃÜÂë´íÎó");
				request.setAttribute("name", name);
				request.getRequestDispatcher("login.jsp");
			}
		}
	}