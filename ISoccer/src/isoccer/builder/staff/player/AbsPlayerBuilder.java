package isoccer.builder.staff.player;

import isoccer.ISoccer;
import isoccer.builder.staff.MemberBuilder;
import isoccer.model.staff.Member;
import isoccer.model.staff.player.Player;

public abstract class AbsPlayerBuilder extends MemberBuilder {
   protected static int playerCount;

   @Override
   public Player put(Member member) {
      return ISoccer.players.put(member.id, (Player) member);
   }
}