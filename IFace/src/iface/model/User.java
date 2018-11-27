package iface.model;

public class User {
	private String login;
	private String name;
	
	public User(String login) {
		this.login = login;
	}
	
	public String getLogin() { return this.login; }
	
	public String getName() { return this.name; }
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) this.name = "none";
		else this.name = name;
	}
}