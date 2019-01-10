package isoccer.model.partner;

public class Elite extends FanPartner {
   public Elite() {}

   public Elite(int id) {
      super(id);
   }

   @Override
   public Elite create(int id) {
      return new Elite(id);
   }

   @Override
   public String getType() {
      return "elite";
   }
}