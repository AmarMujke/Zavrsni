package firma.usermanagment.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import firma.usermanagment.dao.UserDAO;
import firma.usermanagment.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public UserServlet() {
        this.userDAO = new UserDAO();    
    }
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 this.doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			try{insertUser(request,response);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try{deleteUser(request,response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
		     try {
		    	 showEditForm(request,response);
		     } catch (SQLException e){
		    	 e.printStackTrace();
		     }
			break;
		case "/update":
			try {
				updateUser(request,response);
			}catch(SQLException e) {
					e.printStackTrace();
			}
			break;
		default:
			try {
				listUser(request,response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) 
	            throws SQLException, IOException, ServletException{
		List<User> listUser = userDAO.selectUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
	             throws SQLException,IOException{
		int EmpId = Integer.parseInt(request.getParameter("EmpId"));
		String Firstname = request.getParameter("Firstname");
		String Lastname=  request.getParameter("Lastname");
		String Email = request.getParameter("Email");
		String adress = request.getParameter("adress");
		String post = request.getParameter("post");
        String sex = request.getParameter("sex");
        User book =  new User(EmpId, Firstname,  Lastname, 0, 0, adress,  sex,  post,  Email);
        userDAO.updateUser(book);
        response.sendRedirect("list");
        		}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException,IOException{
		int EmpId = Integer.parseInt(request.getParameter("empId"));
		userDAO.deleteUser(EmpId);
		response.sendRedirect("list");
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException{
		int EmpId = Integer.parseInt(request.getParameter("EmpId"));
		User existingUser = userDAO.selectUser(EmpId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
		dispatcher.forward(request, response);
	}
		private void insertUser(HttpServletRequest request, HttpServletResponse response)
		throws SQLException,IOException{
			String Firstname = request.getParameter("Firstname");
			String Lastname=  request.getParameter("Lastname");
			String Email = request.getParameter("Email");
			String adress = request.getParameter("adress");
			String post = request.getParameter("post");
            String sex = request.getParameter("sex");
            User newUser = new User(0, Firstname,  Lastname, 0, 0, adress,  sex,  post,  Email);
            userDAO.insertUser(newUser);
            response.sendRedirect("list");
		}
}
