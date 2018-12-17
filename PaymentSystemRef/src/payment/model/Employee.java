package payment.model;

import java.util.HashMap;

public abstract class Employee implements Cloneable {
   public String address, name, syndicateId;
   private int id;
   public Payment.Method paymentMethod;
   private double salary, syndicateFee;
   private HashMap<String, Double> services;

   public Employee() {
      this(-1);
   }

   public Employee(int id) {
      this.id = id;
      this.services = new HashMap<>();
   }

   @Override public Employee clone() {
      try {
         Employee other = (Employee) super.clone();
         other.services = new HashMap<>(this.services);
         return other;
      } catch (CloneNotSupportedException ce) {
         return null;
      }
   }

   public abstract Employee create(int id);

   public String employeeInfo() {
      return this.id + ": " + this.name;
   }

   public int getId() {
      return this.id;
   }

   public double getSalary() {
      return this.salary;
   }

   public HashMap<String, Double> getServices() {
      return new HashMap<>(this.services);
   }

   public double getSyndicateFee() {
      return this.syndicateFee;
   }

   public static String getType() {
      return null;
   }

   public abstract boolean isPaymentDay(SimpleDate date);

   public String memberInfo() {
      return this.syndicateId + ": " + this.name;
   }

   public abstract double receivePayment();

   public void removeService(String service) {
      this.services.remove(service);
   }

   public void setSalary(double salary) {
      if (salary < 0.0)
         salary = 0.0;
      this.salary = salary;
   }

   public void setService(String service, double fee) {
      if (fee < 0.0)
         fee = 0.0;
      this.services.put(service, fee);
   }

   public void setSyndicateFee(double fee) {
      if (fee < 0.0)
         fee = 0.0;
      this.syndicateFee = fee;
   }

   @Override public String toString() {
      return "Id: " + this.id + "\nNome: " + this.name +
            "\nTipo: " + getType() + "\nSalário: " + this.salary;
   }
}