package payment.action;

import payment.PaymentSystem;
import payment.model.*;

public class LaunchFee implements Action {
   @Override public boolean doAction() {
      Employee member = PaymentSystem.getMember();
      if (member == null)
         return false;

      System.out.print("Serviço: ");
      String service = PaymentSystem.input.nextLine();

      PaymentSystem.copyData();
      member = member.clone();

      System.out.print("Taxa: ");
      double fee = PaymentSystem.input.nextDouble();
      PaymentSystem.input.nextLine();

      Syndicate syndicate = PaymentSystem.getSyndicate();
      syndicate.setService(service, fee);
      for (Employee mb : syndicate.getMembers().values())
         if (mb.getServices().containsKey(service))
            mb.setService(service, fee);
      member.setService(service, fee);

      PaymentSystem.setEmployee(member);

      System.out.println("Taxa de serviço associada a '" +
            member.memberInfo() + "' lançada");
      return true;
   }

   @Override public String toString() {
      return "lançar taxa de serviço";
   }
}