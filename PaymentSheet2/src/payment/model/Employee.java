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
	public ArrayList<SaleResult> sales;
	public double syndicateFee;
	public String syndicateId;
	public Type type;
	
	public Employee() {
		super();
		
		this.cards = new ArrayList<>();
		this.sales = new ArrayList<>();
	}
	
	public Employee(Employee other) {
		super();
		
		this.address = other.address;
		this.cards = new ArrayList<>(other.cards);
		this.commission = other.commission;
		this.name = other.name;
		this.paymentMethod = other.paymentMethod;
		this.salary = other.salary;
		this.sales = new ArrayList<>(other.sales);
		this.syndicateFee = other.syndicateFee;
		this.syndicateId = other.syndicateId;
		this.type = other.type;
	}
	
	public void setPointCard(int hours) { this.cards.add(hours); }
	
	public void setSaleResult(SaleResult sale) { this.sales.add(sale); }
	
	@Override public String toString() {
		String s = "---\nNome: " + this.name + "\nTipo: " + this.type;
		
		s += "\nCartões de ponto:";
		for (int hour : this.cards) s += " " + hour;
		
		s += "\nResultados de venda:";
		for (SaleResult sale : sales) s += "\n  " + sale;
		s += "\n---";
		return s;
	}
}