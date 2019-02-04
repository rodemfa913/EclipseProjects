package isoccer.builder.staff.player;

import isoccer.builder.staff.MemberBuilder;
import isoccer.ISoccer;
import isoccer.model.staff.Member;
import isoccer.model.staff.player.*;

public class PlayerBuilder extends MemberBuilder {
   protected static int playerCount;

   @Override
   public Player build() {
      AbsPlayerBuilder[] builders = new AbsPlayerBuilder[] {
         new GoalKeeperBuilder()
      };

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

   @Override
   public Player put(Member member) {
      return ISoccer.players.put(member.id, (Player) member);
   }

   @Override
   public void setInfo(Member member) throws Exception {
      super.setInfo(member);

      Player player = (Player) member;
      System.out.print("Inapto? (s/n): ");
      player.unable = ISoccer.input.nextLine().toLowerCase().equals("s");
   }
}