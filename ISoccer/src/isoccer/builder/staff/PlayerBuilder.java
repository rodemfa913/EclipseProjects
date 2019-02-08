package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.builder.staff.player.*;
import isoccer.model.staff.player.Player;

public class PlayerBuilder extends MemberBuilder {
   private AbsPlayerBuilder[] builders;

   public PlayerBuilder() {
      builders = new AbsPlayerBuilder[] {
         new GoalKeeperBuilder(), new DefenderBuilder(),
         new DefMidBuilder(), new CentreMidBuilder(), new LeftMidBuilder(),
         new RightMidBuilder(), new ForwardBuilder()
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