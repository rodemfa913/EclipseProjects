package payment.action;

import java.util.ArrayList;
import payment.model.*;
import payment.model.employee.Employee;
import payment.PaymentSystem;

public class Roll implements Action {
   @Override public boolean doAction() {
      SimpleDate date = PaymentSystem.getDate();
      ArrayList<Payment> payments = new ArrayList<>();
      PaymentSystem.save();

      for (Employee employee : PaymentSystem.state.getEmployees()) {
         if (!employee.isPaymentDay(date))
            continue;

         double value = employee.receivePayment();

         if (employee.syndicateId != null) {
            value -= employee.getSyndicateFee();
            for (double fee : employee.getServices().values())
               value -= fee;
         }

         payments.add(new Payment(employee, value));
      }

      if (payments.isEmpty()) {
         System.out.println("<!> Nenhum pagamento agendado.");
         return false;
      }

      System.out.println("Folha de pagamento para " + date + ":");
      for (Payment payment : payments)
         System.out.println("---\n" + payment);
      return true;
   }

   @Override public String toString() {
      return "rodar folha de pagamento";
   }
}