package payment;

import payment.model.Employee;

class Add implements Action {
   private static int nEmployee;

   @Override public boolean doAction() {
      PaymentSystem.copyData();

      Employee employee = PaymentSystem.editInfo(nEmployee++);
      PaymentSystem.setEmployee(employee);

      System.out.println("Empregado '" +
            employee.employeeInfo() + "' adicionado.");
      return true;
   }

   @Override public String toString() {
      return "adicionar empregado";
   }
}