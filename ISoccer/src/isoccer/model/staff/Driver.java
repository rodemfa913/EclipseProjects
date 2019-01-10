package isoccer.model.staff;

public class Driver extends Member {
   public long cnh;

   public Driver() {}

   public Driver(int id) {
      super(id);
   }

   @Override
   public Driver create(int id) {
      return new Driver(id);
   }

   @Override
   public String getType() {
      return "motorista";
   }
}