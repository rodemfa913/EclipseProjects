package isoccer.model.partner;

import isoccer.model.Creator;
import isoccer.model.RegEx;

public abstract class FanPartner implements Creator {
   private String address, cpf, email, name;
   public boolean defaulting;
   private static final Exception formatException =
         new Exception("Formato incorreto.");
   public final int id;
   public long phone;

   public FanPartner() {
      this(-1);
   }

   public FanPartner(int id) {
      this.address = this.cpf = this.email = this.name = "-";
      this.id = id;
   }

   public String getAddress() {
      return this.address;
   }

   public abstract double getContribution();

   public String getCPF() {
      return this.cpf;
   }

   public String getEmail() {
      return this.email;
   }

   public String getName() {
      return this.name;
   }

   public void setAddress(String address) {
      if (address.isEmpty())
         address = "-";
      this.address = address;
   }

   public abstract void setContribution(double contribution);

   public void setCPF(String cpf) throws Exception {
      if (!cpf.matches(RegEx.cpf))
         throw formatException;
      this.cpf = cpf;
   }

   public void setEmail(String email) throws Exception {
      if (!email.matches(RegEx.email))
         throw formatException;
      this.email = email;
   }

   public void setName(String name) {
      if (name.isEmpty())
         name = "-";
      this.name = name;
   }
}