package payment.model;

import java.util.HashMap;

public class Syndicate {
	private HashMap<String, Employee> members;
	
	public Syndicate() {
		super();		
		this.members = new HashMap<>();
	}
	
	public Syndicate(Syndicate other) {
		super();
		this.members = new HashMap<>(other.members);
	}
	
	public Employee getMember(String id) { return this.members.get(id);	}
	public void setMember(String id, Employee member) {
		this.members.put(id, member);
	}
	
	public boolean hasMember(String id) { return this.members.containsKey(id); }
	
	public Employee removeMember(String id) {
		return this.members.remove(id);
	}
}