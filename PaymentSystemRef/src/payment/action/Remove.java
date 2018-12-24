package payment.action;

import payment.model.employee.Employee;
import payment.PaymentSystem;

public class Remove extends Action {
   @Override public boolean doAction() {
      Employee employee = getEmployee();
      if (employee == null)
         return false;

      PaymentSystem.save();
      PaymentSystem.state.removeEmployee(employee);

      System.out.println("Empregado '" +
            employee.employeeInfo() + "' removido.");
      return true;
   }

   @Override public String toString() {
      return "remover empregado";
   }
}