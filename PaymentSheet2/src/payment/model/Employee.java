package payment.model;

public class Employee {
	public enum Type { COMMISSIONED, HOURLY, SALARIED }
	
	public String address;
	public double commission;
	public String name;
	public PaymentMethod paymentMethod;
	public double salary;
	public Type type;
	
	public Employee() {
		super();
	}
	
	public Employee(Employee other) {
		this.address = other.address;
		this.commission = other.commission;
		this.name = other.name;
		this.paymentMethod = other.paymentMethod;
		this.salary = other.salary;
		this.type = other.type;
	}
}