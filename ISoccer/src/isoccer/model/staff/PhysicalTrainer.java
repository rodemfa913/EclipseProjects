package isoccer.model.staff;

public class PhysicalTrainer extends Member {
   public PhysicalTrainer() {}

   public PhysicalTrainer(int id) {
      super(id);
   }

   @Override
   public PhysicalTrainer create(int id) {
      return new PhysicalTrainer(id);
   }

   @Override
   public String getType() {
      return "preparador físico";
   }
}