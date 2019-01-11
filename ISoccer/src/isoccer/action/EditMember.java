package isoccer.action;

import isoccer.model.staff.Member;

public class EditMember extends Action {
   @Override
   public void doAction() throws Exception {
      Member member = this.getMember();
      this.editMemberInfo(member);
      System.out.println("Funcionário '" + member.id +
            ": " + member.getName() + "' editado.");
   }

   @Override
   public String toString() {
      return "editar funcionário";
   }
}