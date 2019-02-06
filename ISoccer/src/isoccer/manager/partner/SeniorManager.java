package isoccer.manager.partner;

import isoccer.model.partner.Senior;

public class SeniorManager extends FanPartnerManager {
   @Override
   public Senior build() throws Exception {
      Senior senior = new Senior(partnerCount++);
      setInfo(senior);
      put(senior);

      return senior;
   }

   @Override
   public String getType() {
      return "sênior";
   }
}