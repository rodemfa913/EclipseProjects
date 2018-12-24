package payment.action;

import payment.model.employee.Employee;
import payment.PaymentSystem;

public class LaunchFee extends Action {
   @Override public boolean doAction() {
      Employee member = this.getMember();
      if (member == null)
         return false;

      System.out.print("Serviço: ");
      String service = PaymentSystem.input.nextLine();

      PaymentSystem.save();
      member = PaymentSystem.state.getMember(member.syndicateId);

      System.out.print("Taxa: ");
      double fee = PaymentSystem.input.nextDouble();
      PaymentSystem.input.nextLine();

      PaymentSystem.state.setService(service, fee);
      member.setService(service, fee);

      System.out.println("Taxa de serviço associada a '" +
            member.memberInfo() + "' lançada");
      return true;
   }

   @Override public String toString() {
      return "lançar taxa de serviço";
   }
}