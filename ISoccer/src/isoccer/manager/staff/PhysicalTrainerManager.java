package isoccer.manager.staff;

import isoccer.model.staff.PhysicalTrainer;

public class PhysicalTrainerManager extends MemberManager {
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