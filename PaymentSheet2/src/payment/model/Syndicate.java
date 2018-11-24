package payment.model;

import java.util.HashMap;

public class Syndicate {
	private HashMap<String, Employee> members;
	
	public Syndicate() {
		this.members = new HashMap<>();
	}
	
	public Syndicate(Syndicate other) {
		this();
		
		for (String id : other.members.keySet()) {
			Employee member = other.members.get(id);
			this.members.put(id, member);
		}
	}
	
	public Employee getMember(String id) {
		return this.members.get(id);
	}
	
	public boolean hasMember(String id) {
		return this.members.containsKey(id);
	}
}