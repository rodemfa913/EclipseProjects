package isoccer.action.report;

import isoccer.ISoccer;
import isoccer.model.staff.Member;
import isoccer.model.staff.player.Player;

public class StaffReport implements Report {
   @Override
   public void generate() {
      System.out.println("Treinador:\n---\n" + ISoccer.coach);

      System.out.println("---\nJogadores:");
      for (Player player : ISoccer.players.values())
         System.out.println("---\n" + player);

      System.out.println("---\nFuncionários:");
      for (Member member : ISoccer.members.values())
         System.out.println("---\n" + member);
   }

   @Override
   public String toString() {
      return "funcionários";
   }
}