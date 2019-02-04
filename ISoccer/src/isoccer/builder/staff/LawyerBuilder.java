package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Lawyer;
import isoccer.model.staff.Member;

public class LawyerBuilder extends MemberBuilder {
   @Override
   public Lawyer build() {
      return new Lawyer(memberCount++);
   }

   @Override
   public String getType() {
      return "advogado";
   }

   @Override
   public Member put(Member member) {
      return ISoccer.members.put(member.id, member);
   }
}