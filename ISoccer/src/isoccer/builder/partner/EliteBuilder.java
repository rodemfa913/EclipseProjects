package isoccer.builder.partner;

import isoccer.model.partner.Elite;

public class EliteBuilder extends FanPartnerBuilder {
   @Override
   public Elite build() throws Exception {
      Elite elite = new Elite(partnerCount++);
      setInfo(elite);
      put(elite);

      return elite;
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