package isoccer.builder.staff;

import isoccer.model.staff.PhysicalTrainer;

public class PhysicalTrainerBuilder extends MemberBuilder {
   @Override
   public PhysicalTrainer build() throws Exception {
      PhysicalTrainer trainer = new PhysicalTrainer(memberCount++);
      setInfo(trainer);
      put(trainer);

      return trainer;
   }

   @Override
   public String getType() {
      return "preparador físico";
   }
}