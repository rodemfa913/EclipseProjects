package payment.model;

import java.util.ArrayList;

public class Employee {
	public enum Type {
		HOURLY, SALARIED, COMMISSIONED;
		
		@Override public String toString() {
			switch (this) {
			case HOURLY:
				return "horista";
			case SALARIED:
				return "assalariado";
			default:
				return "comissionado";
			}
		}
	}
	
	public String address;
	private ArrayList<PointCard> cards;
	private double commission;
	private int id;
	public String name;
	public PaymentMethod paymentMethod;
	public double salary;
	private ArrayList<SaleResult> sales;
	private ArrayList<String> services;
	public double syndicateFee;
	public String syndicateId;
	public Type type;
	
	public Employee(int id) {
		super();
		
		this.id = id;
		this.cards = new ArrayList<>();
		this.sales = new ArrayList<>();
		this.services = new ArrayList<>();
	}
	
	public Employee(Employee other) {
		super();
		
		this.address = other.address;
		this.cards = new ArrayList<>(other.cards);
		this.commission = other.commission;
		this.id = other.id;
		this.name = other.name;
		this.paymentMethod = other.paymentMethod;
		this.salary = other.salary;
		this.sales = new ArrayList<>(other.sales);
		this.services = new ArrayList<>(other.services);
		this.syndicateFee = other.syndicateFee;
		this.syndicateId = other.syndicateId;
		this.type = other.type;
	}
	
	public double getCommission() { return this.commission; }
	
	public void setCommission(double commission) {
		if (commission < 0.0) this.commission = 0.0;
		else if (commission <= 1.0) this.commission = commission;
		else this.commission = 1.0;
	}
	
	public int getId() { return this.id; }
	
	public ArrayList<PointCard> getPointCards() {
		return this.cards;
	}
	
	public ArrayList<SaleResult> getSaleResults() { return this.sales; }
	
	public void setService(String service) {
		if (!this.services.contains(service)) this.services.add(service);
	}
	
	public String employeeInfo() {
		return "'" + this.id + ": " + this.name + "'";
	}
	
	public String memberInfo() {
		return "'" + this.syndicateId + ": " + this.name + "'";
	}
	
	@Override public String toString() {
		String s =
				"---\nId: " + this.id + "Nome: " +
				this.name + "\nTipo: " + this.type
		;
		
		s += "\nCartões de ponto:";
		for (PointCard card : this.cards) s += "\n  " + card;
		
		s += "\nResultados de venda:";
		for (SaleResult sale : this.sales) s += "\n  " + sale;
		
		s += "\n---";
		return s;
	}
}