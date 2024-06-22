package API.functions;

public class User {

	private String email;
	private String password;

	public User(String email, String password) {
	
		this.email=email;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String Password) {
		password = Password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		email = Email;
	}

	public void printUser()
	{
		System.out.println("-----User details-----");
		System.out.println("Email : "+email);
		System.out.println("Password : "+password);
		System.out.println("-----------------------");
	}
}
