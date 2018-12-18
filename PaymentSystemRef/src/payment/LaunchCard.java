package payment;

import payment.model.*;

class LaunchCard implements Action {
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

      PaymentSystem.copyData();
      Hourly hourly = ((Hourly) employee).clone();
      hourly.getPointCards().add(new PointCard(date, hours));
      PaymentSystem.setEmployee(hourly);

      System.out.println("Cartão de ponto associado a '" +
            hourly.employeeInfo() + "' lançado.");
      return true;
   }

   @Override public String toString() {
      return "lançar cartão de ponto";
   }
}