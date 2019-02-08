package isoccer.builder.partner;

import isoccer.model.partner.Senior;

public class SeniorBuilder extends FanPartnerBuilder {
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