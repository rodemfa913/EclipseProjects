package payment.action;

import payment.model.employee.Employee;
import payment.PaymentSystem;

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
      if (PaymentSystem.state.getMembers().containsKey(sid)) {
         System.out.println("<!> Id já existente.");
         return false;
      }

      PaymentSystem.save();
      member = PaymentSystem.state.getEmployees().get(member.getId());
      member.syndicateId = sid;
      PaymentSystem.state.setEmployee(member);

      System.out.print("Taxa sindical: ");
      member.setSyndicateFee(PaymentSystem.input.nextDouble());
      PaymentSystem.input.nextLine();

      System.out.println("Membro '" + member.memberInfo() +
            "' adicionado ao sindicato.");
      return true;
   }

   @Override public String toString() {
      return "entrar no sindicato";
   }
}