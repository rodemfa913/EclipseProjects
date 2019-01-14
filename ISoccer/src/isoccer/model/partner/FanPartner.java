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

   protected FanPartner(int id) {
      address = cpf = email = name = "-";
      this.id = id;
   }

   public String getAddress() {
      return address;
   }

   public abstract double getContribution();

   public String getCPF() {
      return cpf;
   }

   public String getEmail() {
      return email;
   }

   public String getName() {
      return name;
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