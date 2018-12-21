package payment.action;

import payment.PaymentSystem;
import payment.model.employee.Employee;

public class SignOut implements Action {
   @Override public boolean doAction() {
      Employee member = PaymentSystem.getEmployee();
      if (member == null)
         return false;

      PaymentSystem.copyData();
      PaymentSystem.getSyndicate().getMembers().remove(member.syndicateId);
      member = member.clone();
      member.syndicateId = null;
      PaymentSystem.setEmployee(member);

      System.out.println("Membro '" + member.memberInfo() +
            "' removido do sindicato.");
      return true;
   }

   @Override public String toString() {
      return "sair do sindicato";
   }
}