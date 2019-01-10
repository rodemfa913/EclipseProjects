package isoccer.model.staff;

import isoccer.RegEx;
import isoccer.model.Creator;

public abstract class Member implements Creator {
   private String cpf, email, name;
   protected static final Exception formatException =
         new Exception("Formato incorreto");
   public final int id;
   public long phone;
   private double salary;

   public Member() {
      this(-1);
   }

   public Member(int id) {
      this.cpf = this.email = this.name = "-";
      this.id = id;
   }

   public String getCPF() {
      return this.cpf;
   }

   public String getEmail() {
      return this.email;
   }

   public String getName() {
      return this.name;
   }

   public double getSalary() {
      return this.salary;
   }

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

   public void setSalary(double salary) {
      if (salary < 0.0)
         salary = 0.0;
      this.salary = salary;
   }
}