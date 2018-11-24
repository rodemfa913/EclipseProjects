package payment.model;

public enum PaymentMethod {
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