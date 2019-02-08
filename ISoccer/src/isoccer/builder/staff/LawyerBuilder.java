package isoccer.builder.staff;

import isoccer.model.staff.Lawyer;

public class LawyerBuilder extends MemberBuilder {
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