package payment.action;

import payment.model.employee.Employee;
import payment.PaymentSystem;

public class Add implements Action {
   private static int nEmployee;

   @Override public boolean doAction() {
      PaymentSystem.save();

      Employee employee = PaymentSystem.editInfo(nEmployee++);

      System.out.println("Empregado '" +
            employee.employeeInfo() + "' adicionado.");
      return true;
   }

   @Override public String toString() {
      return "adicionar empregado";
   }
}