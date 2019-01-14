package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.staff.Member;

public class EditMember extends Action {
   @Override
   public void doAction() throws Exception {
      System.out.print("Id do funcionário: ");
      int id = Integer.parseInt(ISoccer.input.nextLine());

      Member member = ISoccer.members.get(id);
      if (member == null)
         throw notFoundException;

      memberInfo(member);

      System.out.println("Funcionário '" + member.id +
            ": " + member.getName() + "' editado.");
   }

   @Override
   public String toString() {
      return "editar funcionário";
   }
}