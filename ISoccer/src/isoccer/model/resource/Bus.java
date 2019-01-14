package isoccer.model.resource;

public class Bus extends Resource {
   public Bus() {
      super(-1);
   }

   public Bus(int id) {
      super(id);
   }

   @Override
   public Bus create(int id) {
      return new Bus(id);
   }

   @Override
   public String getType() {
      return "ônibus";
   }
}