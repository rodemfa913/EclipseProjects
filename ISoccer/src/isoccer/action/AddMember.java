package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.staff.*;

public class AddMember extends Action {
   private int memberCount;

   @Override
   public void doAction() throws Exception {
      Member[] mCreators = new Member[] {
            new President(), new Doctor(), new Coach(),
            new PhysicalTrainer(), new Driver(), new Cook(), new Lawyer()
      };

      System.out.println("---");
      int f;
      for (f = 0; f < mCreators.length; f++)
         System.out.println(f + " - " + mCreators[f].getType());
      System.out.print(mCreators.length + " - jogador\n---\nFunção: ");
      f = Integer.parseInt(ISoccer.input.nextLine());

      Member member;
      if (f == mCreators.length) {
         Player[] pCreators = new Player[] {
               new GoalKeeper(), new Defender(), new DefensiveMid(),
               new CentreMid(), new LeftMid(), new RightMid(), new Forward()
         };

         System.out.println("---");
         for (f = 0; f < pCreators.length; f++)
            System.out.println(f + " - " + pCreators[f].getType());
         System.out.print("---\nPosição: ");
         f = Integer.parseInt(ISoccer.input.nextLine());

         member = (Player) pCreators[f].create(memberCount++);
      } else {
         member = (Member) mCreators[f].create(memberCount++);
      }
      this.editInfo(member);
      ISoccer.members.put(member.id, member);

      System.out.println("Funcionário '" + member.id +
            ": " + member.getName() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}