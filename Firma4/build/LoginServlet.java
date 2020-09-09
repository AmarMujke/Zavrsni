package firma.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
		public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String Username = request.getParameter("Username");
		String PassW = request.getParameter("PassW");
		
		LoginDAO dao = new LoginDAO();
		
		if(dao.check(Username,PassW)) {
			HttpSession session = request.getSession();
			session.setAttribute("Username", Username);
			response.sendRedirect("UserList.jsp");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}
}