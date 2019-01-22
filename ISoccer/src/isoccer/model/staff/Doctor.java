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

   @Override
   public Doctor create(int id) {
      return new Doctor(id);
   }

   public String getCRM() {
      return crm;
   }

   @Override
   public String getType() {
      return "médico";
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