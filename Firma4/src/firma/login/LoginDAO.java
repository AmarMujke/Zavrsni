package firma.login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAO {
	String sql = "select * from login where Username=? and PassW=?";
	String url = "jdbc:mysql://localhost:3306/firma?allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password = "123456aa";
	public boolean check(String Uname, String PassW) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, Uname);
		st.setString(2, PassW);
		ResultSet rs = st.executeQuery();
		if(rs.next()) 
		{
			return true;
	}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	}
	}
	



	

	


