package payment.action;

import payment.model.*;
import payment.model.employee.*;
import payment.PaymentSystem;

public class LaunchCard extends Action {
   @Override public boolean doAction() {
      Employee employee = getEmployee();
      if (employee == null)
         return false;
      if (!(employee instanceof Hourly)) {
         System.out.println("<!> Não é " + (new Hourly()).getType() + ".");
         return false;
      }

      SimpleDate date = getDate();

      System.out.print("Horas trabalhadas: ");
      int hours = PaymentSystem.input.nextInt();
      PaymentSystem.input.nextLine();

      PaymentSystem.save();
      Hourly hourly = (Hourly) PaymentSystem.
            state.getEmployee(employee.getId());
      hourly.getPointCards().add(new PointCard(date, hours));

      System.out.println("Cartão de ponto associado a '" +
            hourly.employeeInfo() + "' lançado.");
      return true;
   }

   @Override public String toString() {
      return "lançar cartão de ponto";
   }
}