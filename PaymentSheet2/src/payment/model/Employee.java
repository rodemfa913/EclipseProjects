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
	private ArrayList<Integer> cards;
	public double commission;
	public String name;
	public PaymentMethod paymentMethod;
	public double salary;
	private ArrayList<SaleResult> sales;
	public double syndicateFee;
	public String syndicateId;
	public Type type;
	
	public Employee() {
		this.cards = new ArrayList<>();
		this.sales = new ArrayList<>();
	}
	
	public Employee(Employee other) {
		this();
		
		this.address = other.address;
		for (int hours : other.cards) this.setPointCard(hours);
		this.commission = other.commission;
		this.name = other.name;
		this.paymentMethod = other.paymentMethod;
		this.salary = other.salary;
		for (SaleResult sale : other.sales) this.setSaleResult(sale);
		this.syndicateFee = other.syndicateFee;
		this.syndicateId = other.syndicateId;
		this.type = other.type;
	}
	
	public void setPointCard(int hours) {
		this.cards.add(hours);
	}
	
	public void setSaleResult(SaleResult sale) {
		if (!this.sales.contains(sale)) this.sales.add(sale);
	}
	
	@Override public String toString() {
		return this.name + ", " + this.type + ", " +
				this.paymentMethod + ", " + this.salary;
	}
}