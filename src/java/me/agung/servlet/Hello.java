package me.agung.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.agung.domain.UserSession;

/**
 * Servlet implementation class Hello
 */
@SuppressWarnings("serial")
@WebServlet("/")
public class Hello extends HttpServlet {	
       
	public void handlePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		
		HttpSession sess = request.getSession(false);
		
		if(sess != null){
			UserSession session = (UserSession)sess.getAttribute(UserSession.sessionName);
			
			out.println("<html><body>");		
			out.println("<h1> You are : " + session.getName() + " </h1>");
			out.println("<form method=POST action='logout'>");	
			out.println("<input type=submit value=Logout>");
			out.println("</form>");
			out.println("</body></html>");
		} else {
			out.println("<html><body>");		
			out.println("<h1> You are not login yet </h1>");
			out.println("<form method=POST action='login' >");
			out.println("Username : <br>");
			out.println("<input type=text name='name'/><br>");
			out.println("Password : <br>");
			out.println("<input type=password name='password'/><br>");
			out.println("<input type=submit value=Login>");
			out.println("</form>");
			out.println("</body></html>");
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handlePage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handlePage(request, response);
	}

}
