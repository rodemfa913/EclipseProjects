package payment.action;

import payment.model.employee.Employee;
import payment.PaymentSystem;

public class Add extends Action {
   private static int nEmployee;

   @Override public boolean doAction() {
      PaymentSystem.save();

      Employee employee = this.editInfo(nEmployee++);

      System.out.println("Empregado '" +
            employee.employeeInfo() + "' adicionado.");
      return true;
   }

   @Override public String toString() {
      return "adicionar empregado";
   }
}