package firma.usermanagment.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import firma.usermanagment.model.User;

public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/firma?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456aa";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" +
	"(EmpId, Firstname, Lastname, Age, Dob, Adress, Sex, post, branchId,Email) VALUES" + "(?,?,?,?,?,?,?,?,?);";

	
	private static final String SELECT_USER_BY_ID = "select EmpId, Firstname, Lastname, Age, Dob, Adress, Sex, post, branchId,Email from zaposleni where id=?";
	private static final String SELECT_ALL_USERS = "select * from zaposleni";
	private static final String DELETE_USERES_SQL = "delete from zaposleni where id =?;";
	private static final String UPDATE_USERS_SQL = "update zaposleni set EmpId = ?,Firstname= ?,"
			+ " Lastname= ?, Age= ?, Dob= ?, Adress= ?, Sex= ?, post= ?, branchId= ? where EmpId = ?, Email=?;";
	
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
				preparedStatement.setString(3, user.getEmail());
				preparedStatement.setString(4, user.getAdress());
				preparedStatement.setString(5, user.getPost());
				preparedStatement.setString(6, user.getSex());
				preparedStatement.setInt(7, user.getAge());
				preparedStatement.setInt(8, user.getDob());
				preparedStatement.setInt(9, user.getBranchId());
			    preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//update user
	public boolean updateUser(User user) throws SQLException{
		boolean rowUpdate;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_USERS_SQL);){
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastname());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAdress());
		    statement.setString(5, user.getPost());
			statement.setString(6, user.getSex());
			statement.setInt(7, user.getAge());
			statement.setInt(8, user.getDob());
			statement.setInt(9, user.getBranchId());
		    statement.setInt(10, user.getEmpId());
		    
		    rowUpdate = statement.executeUpdate() > 0;
		}
		return rowUpdate;
	}
	
	
	//select user by id
	
	public User selectUser(int EmpId) {
		User user = null;
		// establishing connection
		try(Connection conn = getConnection();
				//create statement using connection object
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);){
			preparedStatement.setInt(1, EmpId);
			System.out.println(preparedStatement);
			// execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			//process the resultset object
			while (rs.next()) {
				String Firstname = rs.getString("Firstname");
				String Lastname=  rs.getString("Lastname");
				String Email = rs.getString("Email");
				String adress = rs.getString("adress");
				String post = rs.getString("post");
                int age = rs.getInt("age");
                int dob = rs.getInt("dob");
                String sex = rs.getString("sex");
				
				user = new User(EmpId, Firstname,  Lastname, age,  dob, adress,  sex,  post,  Email);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return user;	
			
		}
	
	
	
	
	
	//select users
	
	public List<User> selectUsers() {
         List<User> users = new ArrayList<>();
		// establish connection
		try (Connection conn = getConnection();
				//create a statement using conn object
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_USERS);){
			System.out.println(preparedStatement);
			//execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// process the reset object
			while(rs.next()) {
				int EmpId = rs.getInt("empId");
				String Firstname = rs.getString("Firstname");
				String Lastname=  rs.getString("Lastname");
				String Email = rs.getString("Email");
				String adress = rs.getString("adress");
				String post = rs.getString("post");
                int age = rs.getInt("age");
                int dob = rs.getInt("dob");
                String sex = rs.getString("sex");
				
				users.add(new User(EmpId, Firstname,  Lastname, age,  dob, adress,  sex,  post,  Email));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	
	//delete user
	
	public boolean deleteUser(int EmpId) throws SQLException {
		boolean rowDeleted;
		try(Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_USERES_SQL);){
			statement.setInt(1,EmpId);
			rowDeleted = statement.executeUpdate() > 0;	
			}
	
	return rowDeleted;
	
	
	
}
	
	
}
