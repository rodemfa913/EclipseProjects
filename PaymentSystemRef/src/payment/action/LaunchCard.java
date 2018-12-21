package payment.action;

import payment.model.*;
import payment.model.employee.*;
import payment.PaymentSystem;

public class LaunchCard implements Action {
   @Override public boolean doAction() {
      Employee employee = PaymentSystem.getEmployee();
      if (employee == null)
         return false;
      if (!(employee instanceof Hourly)) {
         System.out.println("<!> Não é " + (new Hourly()).getType() + ".");
         return false;
      }

      SimpleDate date = PaymentSystem.getDate();

      System.out.print("Horas trabalhadas: ");
      int hours = PaymentSystem.input.nextInt();
      PaymentSystem.input.nextLine();

      PaymentSystem.save();
      Hourly hourly = (Hourly) PaymentSystem.state.
            getEmployees().get(employee.getId());
      hourly.getPointCards().add(new PointCard(date, hours));

      System.out.println("Cartão de ponto associado a '" +
            hourly.employeeInfo() + "' lançado.");
      return true;
   }

   @Override public String toString() {
      return "lançar cartão de ponto";
   }
}