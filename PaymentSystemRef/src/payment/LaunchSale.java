package payment;

import payment.model.*;

class LaunchSale implements Action {
   @Override public boolean doAction() {
      Employee employee = PaymentSystem.getEmployee();
      if (employee == null)
         return false;
      if (!(employee instanceof Commissioned)) {
         System.out.println("<!> Não é " +
               (new Commissioned()).getType() + ".");
         return false;
      }

      SimpleDate date = PaymentSystem.getDate();

      System.out.print("Valor: ");
      double value = PaymentSystem.input.nextDouble();
      PaymentSystem.input.nextLine();

      PaymentSystem.copyData();
      Commissioned commissioned = ((Commissioned) employee).clone();
      commissioned.getSaleResults().add(new SaleResult(date, value));
      PaymentSystem.setEmployee(commissioned);

      System.out.println("Resultado de venda associado a '" +
            commissioned.employeeInfo() + "' lançado.");
      return true;
   }

   @Override public String toString() {
      return "lançar resultado de venda";
   }
}