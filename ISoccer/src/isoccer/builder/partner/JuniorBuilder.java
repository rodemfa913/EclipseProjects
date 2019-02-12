package isoccer.builder.partner;

import isoccer.model.partner.Junior;

public class JuniorBuilder extends FanPartnerBuilder {
   @Override
   public Junior build() throws Exception {
      Junior junior = new Junior(partnerCount++);
      setInfo(junior);
      put(junior);

      return junior;
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