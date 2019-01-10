package isoccer.model.staff;

import isoccer.RegEx;

public class Doctor extends Member {
   private String crm;

   public Doctor() {
      this(-1);
   }

   public Doctor(int id) {
      super(id);
      this.crm = "-";
   }

   @Override
   public Doctor create(int id) {
      return new Doctor(id);
   }

   public String getCRM() {
      return this.crm;
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
}