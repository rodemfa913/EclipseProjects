package payment.model;

public class Payment {
	public enum Method {
		MAIL, HANDS, DEPOSIT;
		
		@Override public String toString() {
			switch (this) {
			case MAIL:
				return "cheque por correios";
			case HANDS:
				return "cheque em mãos";
			default:
				return "depósito em conta";
			}
		}
	}
	
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
		return this.employee.employeeInfo() + "\nValor: " + this.value +
				"\nMétodo: " + this.employee.paymentMethod;
	}
}