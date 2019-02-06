package isoccer.manager.staff;

import isoccer.model.staff.Lawyer;

public class LawyerManager extends MemberManager {
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