package payment.action;

import payment.PaymentSystem;
import payment.model.Employee;

public class Edit implements Action {
   @Override public boolean doAction() {
      Employee employee = PaymentSystem.getEmployee();
      if (employee == null)
         return false;

      PaymentSystem.copyData();
      employee = PaymentSystem.editInfo(employee.getId());
      PaymentSystem.setEmployee(employee);

      System.out.println("Empregado '" + employee.employeeInfo() + "' editado");
      return true;
   }

   @Override public String toString() {
      return "editar empregado";
   }
}