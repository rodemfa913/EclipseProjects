package isoccer.model.partner;

public class Elite extends FanPartner {
   private static double contribution;

   public Elite() {}

   public Elite(int id) {
      super(id);
   }

   @Override
   public Elite create(int id) {
      return new Elite(id);
   }

   @Override
   public double getContribution() {
      return Elite.contribution;
   }

   @Override
   public String getType() {
      return "elite";
   }

   @Override
   public void setContribution(double contribution) {
      if (contribution < 0.0)
         contribution = 0.0;
      Elite.contribution = contribution;
   }
}