package isoccer.builder.staff;

import isoccer.model.staff.Lawyer;

public class LawyerBuilder extends MemberBuilder {
   @Override
   public Lawyer build() {
      return new Lawyer(memberCount++);
   }

   @Override
   public String getType() {
      return "advogado";
   }
}