package isoccer.model.partner;

public class Elite extends FanPartner {
   private static double contribution;

   public Elite(int id) {
      super(id);
   }

   @Override
   public double getContribution() {
      return contribution;
   }

   @Override
   public void setContribution(double contribution) {
      if (contribution < 0.0)
         contribution = 0.0;
      Elite.contribution = contribution;
   }
}