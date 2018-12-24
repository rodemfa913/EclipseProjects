package payment.action;

import payment.model.*;
import payment.model.employee.*;
import payment.PaymentSystem;

public class LaunchSale extends Action {
   @Override public boolean doAction() {
      Employee employee = getEmployee();
      if (employee == null)
         return false;
      if (!(employee instanceof Commissioned)) {
         System.out.println("<!> Não é " +
               (new Commissioned()).getType() + ".");
         return false;
      }

      SimpleDate date = getDate();

      System.out.print("Valor: ");
      double value = PaymentSystem.input.nextDouble();
      PaymentSystem.input.nextLine();

      PaymentSystem.save();
      Commissioned commissioned = (Commissioned)
            PaymentSystem.state.getEmployee(employee.getId());
      commissioned.getSaleResults().add(new SaleResult(date, value));

      System.out.println("Resultado de venda associado a '" +
            commissioned.employeeInfo() + "' lançado.");
      return true;
   }

   @Override public String toString() {
      return "lançar resultado de venda";
   }
}