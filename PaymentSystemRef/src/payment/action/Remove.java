package payment.action;

import payment.PaymentSystem;
import payment.model.Employee;

public class Remove implements Action {
   @Override public boolean doAction() {
      Employee employee = PaymentSystem.getEmployee();
      if (employee == null)
         return false;

      PaymentSystem.copyData();
      PaymentSystem.getEmployees().remove(employee.getId());
      PaymentSystem.getSyndicate().getMembers().remove(employee.syndicateId);

      System.out.println("Empregado '" +
            employee.employeeInfo() + "' removido.");
      return true;
   }

   @Override public String toString() {
      return "remover empregado";
   }
}