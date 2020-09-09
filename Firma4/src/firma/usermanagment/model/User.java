package firma.usermanagment.model;

public class User {
	private int EmpId;	
	private String Firstname;
	private String Lastname;
	private int Age;

	private String Adress;
	private String Sex;
	private String post;
	private int branchId;
	private String Email;
	private int Phone;
	private int Salary;
	
	
	
	public User(String Firstname, String Lastname, int Age, String Adress, String Sex, String post, int branchId,
		int Salary, String Email,int Phone,int EmpId) {
		super();
		this.EmpId = EmpId;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.Age = Age;
		this.Email = Email;
		this.Adress = Adress;
		this.Sex = Sex;
		this.Phone = Phone;
		this.Salary= Salary;
		this.post = post;
		this.branchId = branchId;
	}
	public User(String Firstname, String Lastname, int Age, String Adress, String Sex, String post, int branchId,
			int Salary, String Email,int Phone) {
			super();
			
			this.Firstname = Firstname;
			this.Lastname = Lastname;
			this.Age = Age;
			this.Email = Email;
			this.Adress = Adress;
			this.Sex = Sex;
			this.Phone = Phone;
			this.Salary= Salary;
			this.post = post;
			this.branchId = branchId;
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
	public void setEmail(String email) {
		this.Email = email;
	}
    public void setPhone(int phone) {
    	this.Phone = phone;
    }
    public int getPhone() {
    	return Phone;
    }
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
}
