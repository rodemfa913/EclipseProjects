package isoccer.model.partner;

public class Junior extends FanPartner {
   public Junior() {}

   public Junior(int id) {
      super(id);
   }

   @Override
   public Junior create(int id) {
      return new Junior(id);
   }

   @Override
   public String getType() {
      return "júnior";
   }
}