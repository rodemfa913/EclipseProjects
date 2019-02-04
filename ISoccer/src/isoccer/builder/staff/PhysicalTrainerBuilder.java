package isoccer.builder.staff;

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
}