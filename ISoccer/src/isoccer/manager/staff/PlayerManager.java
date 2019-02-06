package isoccer.manager.staff;

import isoccer.ISoccer;
import isoccer.manager.staff.player.*;
import isoccer.model.staff.player.Player;

public class PlayerManager extends MemberManager {
   private AbsPlayerManager[] builders;

   public PlayerManager() {
      builders = new AbsPlayerManager[] {
         new GoalKeeperManager(), new DefenderManager(),
         new DefMidManager(), new CentreMidManager(), new LeftMidManager(),
         new RightMidManager(), new ForwardManager()
      };
   }

   @Override
   public Player build() throws Exception {
      System.out.println("---");
      int p;
      for (p = 0; p < builders.length; p++)
         System.out.println(p + " - " + builders[p].getType());
      System.out.print("---\nPosição: ");
      p = Integer.parseInt(ISoccer.input.nextLine());

      return (Player) builders[p].build();
   }

   @Override
   public String getType() {
      return "jogador";
   }
}