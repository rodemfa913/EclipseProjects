package payment.action;

import payment.model.employee.Employee;
import payment.PaymentSystem;

public class Edit implements Action {
   @Override public boolean doAction() {
      Employee employee = PaymentSystem.getEmployee();
      if (employee == null)
         return false;

      PaymentSystem.save();
      employee = PaymentSystem.editInfo(employee.getId());

      System.out.println("Empregado '" + employee.employeeInfo() + "' editado");
      return true;
   }

   @Override public String toString() {
      return "editar empregado";
   }
}