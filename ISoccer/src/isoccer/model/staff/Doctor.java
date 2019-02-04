package isoccer.model.staff;

import isoccer.model.RegEx;

public class Doctor extends Member {
   private String crm;

   public Doctor() {
      this(-1);
   }

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