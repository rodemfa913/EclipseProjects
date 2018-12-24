package payment.action;

import payment.model.employee.Employee;
import payment.PaymentSystem;

public class SignOut extends Action {
   @Override public boolean doAction() {
      Employee member = getMember();
      if (member == null)
         return false;

      PaymentSystem.save();
      member = PaymentSystem.state.removeEmployee(member);
      member.syndicateId = null;
      PaymentSystem.state.setEmployee(member);

      System.out.println("Membro '" + member.memberInfo() +
            "' removido do sindicato.");
      return true;
   }

   @Override public String toString() {
      return "sair do sindicato";
   }
}