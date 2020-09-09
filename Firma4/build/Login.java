package firma.login;

public class Login {
 private static String Password;
 private static String Username;
 public boolean valid;
 
 public Login(String Username, String Password){
	 super();
	 this.Username = Username;
	 this.Password = Password;
 }
 
 
public static String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public static String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public boolean isValid() {
	return valid;
}
public void setValid(boolean newValid) {
	valid = newValid;
}



}


