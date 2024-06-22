package API.functions;

public class Publisher {
	
	private String name;
	private String email;

	public Publisher(String name, String email) {
		this.name = name;
		this.email=email;
	}
	
	public String getName() {
		return name;
	}
	public void setId(String Name	) {
		name = Name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		email = Email;
	}

	public void printPublisher()
	{
		System.out.println("-----Publisher details-----");
		System.out.println("Name : "+name);
		System.out.println("Email : "+email);
		System.out.println("-------------------------");
	}
}
