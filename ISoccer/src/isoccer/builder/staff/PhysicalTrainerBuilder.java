package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Member;
import isoccer.model.staff.PhysicalTrainer;

public class PhysicalTrainerBuilder extends MemberBuilder {
   @Override
   public PhysicalTrainer build() {
      return new PhysicalTrainer(memberCount++);
   }

   @Override
   public String getType() {
      return "preparador físico";
   }

   @Override
   public Member put(Member member) {
      return ISoccer.members.put(member.id, member);
   }
}