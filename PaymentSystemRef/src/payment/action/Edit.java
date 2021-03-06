package payment.action;

import payment.model.employee.Employee;
import payment.PaymentSystem;

public class Edit extends Action {
   @Override public boolean doAction() {
      Employee employee = this.getEmployee();
      if (employee == null)
         return false;

      PaymentSystem.save();
      employee = this.editInfo(employee.getId());

      System.out.println("Empregado '" + employee.employeeInfo() + "' editado");
      return true;
   }

   @Override public String toString() {
      return "editar empregado";
   }
}