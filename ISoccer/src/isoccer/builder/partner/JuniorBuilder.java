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
}