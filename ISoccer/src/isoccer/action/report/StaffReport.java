package isoccer.action.report;

import isoccer.builder.staff.CoachBuilder;
import isoccer.builder.staff.player.AbsPlayerBuilder;
import isoccer.builder.staff.service.AbsServiceBuilder;
import isoccer.model.staff.Member;
import isoccer.model.staff.Coach;
import isoccer.model.staff.player.Player;
import java.util.ArrayList;

public class StaffReport implements Report {
   @Override
   public void generate() {
      System.out.println("Técnico:");
      Coach coach = CoachBuilder.getCoach();
      if (coach != null)
         System.out.println("---\n" + coach);

      ArrayList<Player> ablePlayers = new ArrayList<>();
      ArrayList<Player> unablePlayers = new ArrayList<>();
      for (Player player : AbsPlayerBuilder.getPlayers())
         if (player.unable)
            unablePlayers.add(player);
         else
            ablePlayers.add(player);

      System.out.println("---\nJogadores:\n  Aptos:");
      for (Player player : ablePlayers)
         System.out.println("---\n" + player);
      System.out.println("---\n  Inaptos:");
      for (Player player : unablePlayers)
         System.out.println("---\n" + player);

      System.out.println("---\nFuncionários:");
      for (Member member : AbsServiceBuilder.getMembers())
         System.out.println("---\n" + member);
   }

   @Override
   public String toString() {
      return "funcionários";
   }
}