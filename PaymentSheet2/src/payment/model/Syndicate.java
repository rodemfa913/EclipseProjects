package payment.model;

import java.util.HashMap;

public class Syndicate {
	private HashMap<String, Employee> members;
	private HashMap<String, Double> services;
	
	public Syndicate() {
		super();		
		this.members = new HashMap<>();
		this.services = new HashMap<>();
	}
	
	public Syndicate(Syndicate other) {
		super();
		this.members = new HashMap<>(other.members);
		this.services = new HashMap<>(other.services);
	}
	
	public Employee getMember(String id) { return this.members.get(id);	}
	public void setMember(String id, Employee member) {
		this.members.put(id, member);
	}
	
	public double getServiceFee(String id) { return this.services.get(id); }
	public void setService(String id, double fee) {
		this.services.put(id, fee);
	}
	
	public boolean hasMember(String id) { return this.members.containsKey(id); }
	
	public boolean hasService(String id) {
		return this.services.containsKey(id);
	}
	
	public Employee removeMember(String id) {
		return this.members.remove(id);
	}
	
	@Override public String toString() {
		String s = "---\nMembros:";
		
		for (String id : this.members.keySet()) {
			Employee member = this.members.get(id);
			s += "\n  " + id + ": " + member.name;
		}
		
		s += "\n---";
		return s;
	}
}