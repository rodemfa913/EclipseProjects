package isoccer.model.partner;

public class Senior extends FanPartner {
   private static double contribution;

   public Senior(int id) {
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
      Senior.contribution = contribution;
   }
}