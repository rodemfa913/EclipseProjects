package isoccer.model.partner;

public class Junior extends FanPartner {
   private static double contribution;

   public Junior() {}

   public Junior(int id) {
      super(id);
   }

   @Override
   public Junior create(int id) {
      return new Junior(id);
   }

   @Override
   public double getContribution() {
      return Junior.contribution;
   }

   @Override
   public String getType() {
      return "júnior";
   }

   @Override
   public void setContribution(double contribution) {
      if (contribution < 0.0)
         contribution = 0.0;
      Junior.contribution = contribution;
   }
}