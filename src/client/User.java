package client;

public class User {
	private int Id;
	private String Fname;
	private String Lname;
	private String Email;
	private int Phone;
	private int DateEntered;
	private String password;
	
	public User(String Fname, String password) {
		this.Fname = Fname;
		this.password = password;
	}
	
	
	public int getID(){
		return this.Id;
	}
	
	public String getPass(){
		return this.password;
	}
	
	public String getFname(){
		return this.Fname;
	}
	
	public void setFname(String Fname){
		this.Fname = Fname;
	}
	
	public String getLname(){
		return this.Lname;
	}
	
	public void setLname(String Lname){
		this.Lname = Lname;
	}
	
	public String getEmail(){
		return this.Email;
	}
	
	public void setEmail(String Email){
		this.Email = Email;
	}
	
	public int getPhone(){
		return this.Phone;
	}
	
	public void setPhone(int Phone){
		this.Phone = Phone;
	}
	
	public int getDateEntered(){
		return this.DateEntered;
	}

}
