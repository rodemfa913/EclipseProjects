package isoccer.builder.staff.service;

import isoccer.model.staff.service.Lawyer;

public class LawyerBuilder extends AbsServiceBuilder {
   @Override
   public Lawyer build() throws Exception {
      Lawyer lawyer = new Lawyer(memberCount++);
      setInfo(lawyer);
      put(lawyer);

      return lawyer;
   }

   @Override
   public String getType() {
      return "advogado";
   }
}