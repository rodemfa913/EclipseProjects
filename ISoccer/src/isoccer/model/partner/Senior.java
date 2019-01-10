package isoccer.model.partner;

public class Senior extends FanPartner {
   public Senior() {}

   public Senior(int id) {
      super(id);
   }

   @Override
   public Senior create(int id) {
      return new Senior(id);
   }

   @Override
   public String getType() {
      return "sênior";
   }
}