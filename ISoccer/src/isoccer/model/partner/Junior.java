package isoccer.model.partner;

public class Junior extends FanPartner {
   public static double contribution;

   public Junior(int id) {
      super(id);
   }

   @Override
   protected double getContribution() {
      return contribution;
   }
}