package payment.model;

public class Employee {
	public enum Type { COMMISSIONED, HOURLY, MONTHLY }
	
	public String address;
	public double commission;
	public String name;
	public PaymentMethod paymentMethod;
	public double salary;
	public Type type;
}