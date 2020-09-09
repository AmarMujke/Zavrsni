package firma.usermanagment.model;

public class User {
	private int EmpId;	
	private String Firstname;
	private String Lastname;
	private int Age;
	private int Dob;
	private String Adress;
	private String Sex;
	private String post;
	private int branchId;
	private String Email;
	
	
	
	public User(int empId, String firstname, String Lastname, int age, int dob, String adress, String sex, String post, String Email,
			int branchId) {
		super();
		this.EmpId = empId;
		this.Firstname = firstname;
		this.Lastname = Lastname;
		this.Age = age;
		this.Dob = dob;
		this.Email = Email;
		this.Adress = adress;
		this.Sex = sex;
		this.post = post;
		this.branchId = branchId;
	}
	
	
	
	
	
	
	public User(int EmpId,String Firstname, String Lastname, int age, int dob, String adress, String sex, String post, String Email) {
		super();
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.Age = age;
		this.Dob = dob;
		this.Adress = adress;
		this.Sex = sex;
		this.post = post;
		this.Email = Email;
	}



	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getDob() {
		return Dob;
	}
	public void setDob(int dob) {
		Dob = dob;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}


}
