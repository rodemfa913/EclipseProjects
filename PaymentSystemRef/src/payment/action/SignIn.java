package payment.action;

import payment.PaymentSystem;
import payment.model.employee.Employee;

public class SignIn implements Action {
   @Override public boolean doAction() {
      Employee member = PaymentSystem.getEmployee();
      if (member == null)
         return false;
      if (member.syndicateId != null) {
         System.out.println("<!> Já é membro do sindicato.");
         return false;
      }

      System.out.print("Id do membro do sindicato: ");
      String sid = PaymentSystem.input.nextLine();
      if (PaymentSystem.getSyndicate().getMembers().containsKey(sid)) {
         System.out.println("<!> Id já existente.");
         return false;
      }

      PaymentSystem.copyData();
      member = member.clone();
      member.syndicateId = sid;

      System.out.print("Taxa sindical: ");
      member.setSyndicateFee(PaymentSystem.input.nextDouble());
      PaymentSystem.input.nextLine();

      PaymentSystem.setEmployee(member);

      System.out.println("Membro '" + member.memberInfo() +
            "' adicionado ao sindicato.");
      return true;
   }

   @Override public String toString() {
      return "entrar no sindicato";
   }
}