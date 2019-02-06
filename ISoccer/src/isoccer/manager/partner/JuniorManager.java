package isoccer.manager.partner;

import isoccer.model.partner.Junior;

public class JuniorManager extends FanPartnerManager {
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
}