package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDAO;
import com.Bean.LoginBean;

/**
 * Login Servlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  public LoginServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException 
		{

			String uName = request.getParameter("uName_");
			String pWord = request.getParameter("pass_");

			LoginBean bean = null;
			LoginDAO dao = null; 
			RequestDispatcher rd = null;

			bean = new LoginBean();
			bean.setUName(uName);
			bean.setPWord(pWord);

			dao = new LoginDAO();

			try 
			{
				String result = dao.validateUser(bean);
				System.out.println("servlet:" +" " + result);
				if(result.equals("Admin_role"))
				{ 
					System.out.print(result);
					HttpSession session = request.getSession();//create session
					session.setAttribute("Admin", uName);
					request.setAttribute("uName", uName);
					rd = request.getRequestDispatcher("admin_home.jsp");
				}
				else if(result.equals("User_role"))
				{
					System.out.print(result);
					HttpSession session = request.getSession();//create session
					session.setMaxInactiveInterval(10*60);
					session.setAttribute("User", uName);
					request.setAttribute("uName", uName);
					rd = request.getRequestDispatcher("/WEB-INF/jsp/user_page.jsp");
				}

				else 
				{
					System.out.print("login-eronr:" + result);
					request.setAttribute("errMessage", result);
					rd=request.getRequestDispatcher("login.jsp");
				}

				rd.forward(request, response);
				
			} 
			catch (Exception e) {e.printStackTrace();}
			finally {dao.close();}

		}
	}
