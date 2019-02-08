package isoccer.manager.staff.player;

import isoccer.ISoccer;
import isoccer.manager.staff.MemberManager;
import isoccer.model.staff.Member;
import isoccer.model.staff.player.Player;

public abstract class AbsPlayerManager extends MemberManager {
   protected static int playerCount;

   @Override
   protected Player put(Member member) {
      return ISoccer.players.put(member.id, (Player) member);
   }

   @Override
   protected void setInfo(Member member) throws Exception {
      super.setInfo(member);

      Player player = (Player) member;
      System.out.print("Inapto? (s/n): ");
      player.unable = ISoccer.input.nextLine().toLowerCase().equals("s");
   }
}