package isoccer.model.staff;

public class Forward extends Player {
   public Forward() {}

   public Forward(int id) {
      super(id);
   }

   @Override
   public Forward create(int id) {
      return new Forward(id);
   }

   @Override
   public String getType() {
      return "atacante";
   }
}