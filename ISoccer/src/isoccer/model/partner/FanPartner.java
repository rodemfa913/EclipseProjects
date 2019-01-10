package isoccer.model.partner;

import isoccer.RegEx;
import isoccer.model.Creator;

public abstract class FanPartner implements Creator {
   public String address, name;
   private double contribution;
   private String cpf, email;
   public boolean defaulting;
   public final int id;
   public long phone;

   public FanPartner() {
      this(-1);
   }

   public FanPartner(int id) {
      this.id = id;
   }

   public double getContribution() {
      return this.contribution;
   }

   public String getCPF() {
      return this.cpf;
   }

   public String getEmail() {
      return this.email;
   }

   public void setContribution(double contribution) {
      if (contribution < 0.0)
         contribution = 0.0;
      this.contribution = contribution;
   }

   public boolean setCPF(String cpf) {
      if (!cpf.matches(RegEx.cpf))
         return false;
      this.cpf = cpf;
      return true;
   }

   public boolean setEmail(String email) {
      if (!email.matches(RegEx.email))
         return false;
      this.email = email;
      return true;
   }
}