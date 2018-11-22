package payment.model;

import java.util.ArrayList;

public class Employee {
	public enum Type { COMMISSIONED, HOURLY, SALARIED }
	
	public String address;
	private ArrayList<Integer> cards;
	public double commission;
	public String name;
	public PaymentMethod paymentMethod;
	public double salary;
	private ArrayList<SaleResult> sales;
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
		this.type = other.type;
	}
	
	public void setPointCard(int hours) {
		this.cards.add(hours);
	}
	
	public void setSaleResult(SaleResult sale) {
		if (!this.sales.contains(sale)) this.sales.add(sale);
	}
	
	@Override public String toString() {
		return this.name + " (" + this.type.toString().toLowerCase() + ")";
	}
}