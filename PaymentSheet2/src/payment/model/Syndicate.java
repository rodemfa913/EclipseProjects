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
	
	public HashMap<String, Employee> getMembers() { return this.members; }
	
	public HashMap<String, Double> getServices() { return this.services; }
	
	@Override public String toString() {
		String s = "---";
		
		if (!this.members.isEmpty()) {
			s += "\nMembros:";
			for (String id : this.members.keySet()) {
				Employee member = this.members.get(id);
				s += "\n  " + id + ": " + member.name;
			}
		}
		
		if (!this.services.isEmpty()) {
			s += "\nServiços: ";
			for (String service : this.services.keySet()) {
				double fee = this.services.get(service);
				s += "\n  " + service + ": " + fee;
			}
		}
		
		s += "\n---";
		return s;
	}
}