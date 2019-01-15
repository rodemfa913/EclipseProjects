package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.staff.Coach;

public class AddCoach extends Action {
   @Override
   public void doAction() throws Exception {
      ISoccer.coach = new Coach();
      setMemberInfo(ISoccer.coach);
      System.out.println("Técnico " + ISoccer.coach.getName() + " adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar técnico";
   }
}