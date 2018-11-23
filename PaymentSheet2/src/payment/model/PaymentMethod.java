package payment.model;

public enum PaymentMethod {
	DEPOSIT, HANDS, MAIL;
	
	@Override public String toString() {
		switch (this) {
		case DEPOSIT:
			return "depósito em conta";
		case HANDS:
			return "cheque em mãos";
		default:
			return "cheque por correios";
		}
	}
}