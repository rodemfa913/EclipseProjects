package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Cook;
import isoccer.model.staff.Member;

public class CookBuilder extends MemberBuilder {
   @Override
   public Cook build() {
      return new Cook(memberCount++);
   }

   @Override
   public String getType() {
      return "cozinheiro";
   }

   @Override
   public Member put(Member member) {
      return ISoccer.members.put(member.id, member);
   }
}