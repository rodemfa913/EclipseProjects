package isoccer.builder.staff.service;

import isoccer.model.staff.service.PhysicalTrainer;

public class PhysicalTrainerBuilder extends AbsServiceBuilder {
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