package isoccer.model.staff.service;

import isoccer.model.RegEx;
import isoccer.model.staff.Member;

public class Doctor extends Member {
   private String crm;

   public Doctor(int id) {
      super(id);
      crm = "-";
   }

   public String getCRM() {
      return crm;
   }

   public void setCRM(String crm) throws Exception {
      if (!crm.matches(RegEx.crm))
         throw formatException;
      this.crm = crm;
   }

   @Override
   public String toString() {
      return super.toString() + "\nCRM: " + crm;
   }
}