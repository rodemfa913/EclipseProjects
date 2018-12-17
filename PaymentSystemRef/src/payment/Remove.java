package payment;

import payment.model.Employee;

class Remove implements Action {
   @Override public boolean doAction() {
      Employee employee = PaymentSystem.getEmployee();
      if (employee == null)
         return false;

      PaymentSystem.copyData();
      PaymentSystem.employees.remove(employee.getId());
      PaymentSystem.syndicate.getMembers().remove(employee.syndicateId);

      System.out.println("Empregado '" +
            employee.employeeInfo() + "' removido.");
      return true;
   }

   @Override public String toString() {
      return "remover empregado";
   }
}