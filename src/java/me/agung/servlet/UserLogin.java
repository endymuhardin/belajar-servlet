package me.agung.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.agung.domain.UserList;
import me.agung.domain.UserSession;
import me.agung.listener.SessionListener;

/**
 * Servlet implementation class UserLogin
 */
@SuppressWarnings("serial")
@WebServlet("/login")
public class UserLogin extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();		
		
		out.println("<html><body>");		
		out.println("<h1> We don't support Get request </h1>");		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();		
		
		String name = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");
		
		if(name == "") {
			out.println(errorAppend("<h1> Name cannot be empty </h1>"));
		}
		
		if(password == "") {
			out.println(errorAppend("<h1> Password cannot be empty </h1>"));
		}
		
		if(UserList.getInstance().validUser(name, password)) 
		{
			if(!SessionListener.isUserLogin(name)) 
			{
				// create user session object
				UserSession userSession = new UserSession(name);
				
				HttpSession session = request.getSession(true);
				session.setAttribute(UserSession.sessionName, userSession);
				
				SessionListener.addLoginUser(name, session);
				
				response.sendRedirect("");
			} else {
				out.println(errorAppend("<h1> User is already login, you should wait for user logout first </h1>"));
			}
		} else {
			out.println(errorAppend("<h1> Invalid User </h1>"));
		}
	}
	
	private String errorAppend(String error)
	{
		StringBuffer buff = new StringBuffer();
		buff.append("<html><body>");
		buff.append(error);
		buff.append("<a href='' onClick='history.back()'> <- back </a>");
		buff.append("</body></html>");
		
		return buff.toString();		
	}

}
