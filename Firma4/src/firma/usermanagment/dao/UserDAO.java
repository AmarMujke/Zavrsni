package firma.usermanagment.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import firma.usermanagment.model.*;



public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/firma?allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456aa";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO zaposleni" +
	"(Firstname, Lastname, Age, Adress, Sex, post, branchId,Salary,Email,Phone) VALUES" + "(?,?,?,?,?,?,?,?,?,?);";
    private static final String BRANCH= "select * from gp";
	private static final String SELECT_USER_BY_ID = "select  Firstname, Lastname, Age, Adress, Sex, post, branchId,Salary,Email,Phone from zaposleni where EmpId=?";
	private static final String SELECT_ALL_USERS = "select * from zaposleni";
	private static final String DELETE_USERES_SQL = "delete from zaposleni where Empid =?;";
	private static final String UPDATE_USERS_SQL = "update zaposleni set Firstname=?, Lastname=?, Age=?,  Adress=?, Sex=?, post=?, branchId=?, Salary=?, Email=?, Phone=? where EmpId =?;";

	
	
	protected Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	//Create user or insert user
	public void insertUser(User user) throws SQLException{
		try(Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)){
				preparedStatement.setString(1, user.getFirstname());
				preparedStatement.setString(2, user.getLastname());
				preparedStatement.setInt(3, user.getAge());
				preparedStatement.setString(4, user.getAdress());
				preparedStatement.setString(5, user.getSex());
				preparedStatement.setString(6, user.getPost());
				preparedStatement.setInt(7, user.getBranchId());
				preparedStatement.setInt(8, user.getSalary());
				preparedStatement.setString(9, user.getEmail());
				preparedStatement.setInt(10, user.getPhone());
				
			    preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	//update user
	public boolean updateUser(User user) throws SQLException{
		boolean rowUpdated;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_USERS_SQL);){
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastname());
			statement.setInt(3, user.getAge());
			statement.setString(9, user.getEmail());
			statement.setString(4, user.getAdress());
		    statement.setString(6, user.getPost());
			statement.setString(5, user.getSex());
			statement.setInt(7, user.getBranchId());
			statement.setInt(8, user.getSalary());
			statement.setInt(10, user.getPhone());
	     	statement.setInt(11, user.getEmpId());

		    
		    rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	//select user by id
	
	public User selectUser(int EmpId) {
		User user = null;
		try(Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);){
			preparedStatement.setInt(1, EmpId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String Firstname = rs.getString("Firstname");
				String Lastname=  rs.getString("Lastname");
				String Email = rs.getString("Email");
				String Adress = rs.getString("Adress");
				String post = rs.getString("post");
                int Age = rs.getInt("Age");
                
                int Salary = rs.getInt("Salary");
                int Phone = rs.getInt("Phone");
                int branchId = rs.getInt("branchId");
                String Sex = rs.getString("Sex");
				
				user = new User(Firstname, Lastname, Age, Adress,  Sex,  post, branchId, Salary, Email, Phone, EmpId);
				
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return user;	
			
		}
	
	
	
	
	
	//select users
	
	public List<User> selectUsers() {
         List<User> users = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_USERS);){
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				
				String Firstname = rs.getString("Firstname");
				String Lastname=  rs.getString("Lastname");
				String Email = rs.getString("Email");
				String Adress = rs.getString("Adress");
				String post = rs.getString("post");
                int Age = rs.getInt("age");
               
                String Sex = rs.getString("Sex");
                int branchId = rs.getInt("branchId");
                int Salary = rs.getInt("salary");
                int Phone = rs.getInt("Phone");
				int EmpId = rs.getInt("EmpId");
				users.add(new User(Firstname,  Lastname, Age, Adress,  Sex,  post, branchId, Salary, Email,Phone,EmpId));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	

	
	
	
	//delete user
	
	public boolean deleteUser(int empId) throws SQLException {
		boolean rowDeleted;
		try(Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_USERES_SQL);){
			statement.setInt(1,empId);
			rowDeleted = statement.executeUpdate() > 0;	
			}
	
	return rowDeleted;
	
	}
	// branches 
	
	public List<branch> Branch() {
        List<branch> Branch = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(BRANCH);){
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				
				String BranchName = rs.getString("BranchName");
				int BranchId = rs.getInt("BranchId");
				
				Branch.add(new branch (BranchId, BranchName));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return Branch;
	}



	
}
	
	

