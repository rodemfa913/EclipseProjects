package isoccer.model.partner;

public class Junior extends FanPartner {
   private static double contribution;

   public Junior(int id) {
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
      Junior.contribution = contribution;
   }
}