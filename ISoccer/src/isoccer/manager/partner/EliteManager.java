package isoccer.manager.partner;

import isoccer.model.partner.Elite;

public class EliteManager extends FanPartnerManager {
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
}