package payment.model.employee;

import payment.model.SimpleDate;

public class Salaried extends Employee {
   public Salaried() {
      this(-1);
   }

   public Salaried(int id) {
      super(id);
   }

   public Salaried create(int id) {
      return new Salaried(id);
   }

   @Override public String getType() {
      return "assalariado";
   }

   public boolean isPaymentDay(SimpleDate date) {
      return date.isLastBusinessDay();
   }

   public double receivePayment() {
      return this.getSalary();
   }
}