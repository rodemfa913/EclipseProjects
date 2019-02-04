package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Member;
import isoccer.model.staff.President;

public class PresidentBuilder extends MemberBuilder {
   @Override
   public President build() {
      return new President(memberCount++);
   }

   @Override
   public String getType() {
      return "presidente";
   }

   @Override
   public Member put(Member member) {
      return ISoccer.members.put(member.id, member);
   }
}