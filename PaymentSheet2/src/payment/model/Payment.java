package payment.model;

public class Payment {
	private Employee employee;
	private double value;
	
	public Payment(Employee employee, double value) {
		super();
		
		this.employee = employee;
		this.value = value;
	}
	
	public Employee getEmployee() { return this.employee; }
	
	public double getValue() { return this.value; }
	
	@Override public String toString() {
		return this.employee.employeeInfo() + " recebe " + this.value;
	}
}