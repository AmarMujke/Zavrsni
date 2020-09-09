package firma.usermanagment.web;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import firma.usermanagment.dao.UserDAO;
import firma.usermanagment.model.*;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
  
	
	public UserServlet(){
		this.userDAO = new UserDAO();
	}
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 this.doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request,response);
			break;
		case "/branch":
			try {
			Branch(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/insert":
			try{
				insertUser(request,response);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try{
				deleteUser(request,response);
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
		List<User> list = userDAO.selectUsers();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
	             throws SQLException,IOException{
	   int EmpId = Integer.parseInt(request.getParameter("empId"));
		String Firstname = request.getParameter("Firstname");
		String Lastname=  request.getParameter("Lastname");
		String Email = request.getParameter("Email");
		String post = request.getParameter("post");

        int Age =  Integer.parseInt(request.getParameter("age"));
   
        String Adress = request.getParameter("Adress");
        String Sex = request.getParameter("Sex");
        int branchId = Integer.parseInt(request.getParameter("branchId"));
        int Salary =  Integer.parseInt(request.getParameter("salary"));
        int Phone = Integer.parseInt(request.getParameter("phone"));
        
        
        User user =  new User(Firstname,  Lastname, Age , Adress,  Sex,  post, branchId, Salary, Email, Phone,EmpId);
        userDAO.updateUser(user);
        response.sendRedirect("list");
        		}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException,IOException{
		int empId = Integer.parseInt(request.getParameter("empId"));
		userDAO.deleteUser(empId);
		response.sendRedirect("list");
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException{
		int EmpId = Integer.parseInt(request.getParameter("empId"));
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
		private void Branch(HttpServletRequest request, HttpServletResponse response)
				throws ServletException,IOException, SQLException {
			List<branch> branch = userDAO.Branch();
			request.setAttribute("branch", branch);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Branch.jsp");
			dispatcher.forward(request, response);
		}
		
	
	
		
		private void insertUser(HttpServletRequest request, HttpServletResponse response)
		throws SQLException,IOException{
		  
			String Firstname = request.getParameter("Firstname");
			String Lastname=  request.getParameter("Lastname");
			String Email = request.getParameter("Email");
			String Adress = request.getParameter("Adress");
			String post = request.getParameter("post");
	        String Sex = request.getParameter("Sex");
	        int Age = Integer.parseInt(request.getParameter("age"));
	        int branchId = Integer.parseInt(request.getParameter("branchId"));
	        int Salary =  Integer.parseInt(request.getParameter("salary"));
	        int Phone = Integer.parseInt(request.getParameter("phone"));
            User newUser = new User(Firstname, Lastname, Age , Adress,  Sex,  post, branchId, Salary, Email, Phone);
            userDAO.insertUser(newUser);
            response.sendRedirect("list");
		}
}
