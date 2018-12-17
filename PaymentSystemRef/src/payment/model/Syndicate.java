package payment.model;

import java.util.*;

public class Syndicate implements Cloneable {
   private HashMap<String, Employee> members;
   private HashMap<String, Double> services;

   public Syndicate() {
      this.members = new HashMap<>();
      this.services = new HashMap<>();
   }

   @Override public Syndicate clone() {
      try {
         Syndicate other = (Syndicate) super.clone();
         other.members = new HashMap<>(this.members);
         other.services = new HashMap<>(this.services);
         return other;
      } catch (CloneNotSupportedException ce) {
         return new Syndicate();
      }
   }

   public HashMap<String, Employee> getMembers() {
      return this.members;
   }

   public HashMap<String, Double> getServices() {
      return new HashMap<>(this.services);
   }

   public void setService(String service, double fee) {
      if (fee < 0.0)
         fee = 0.0;
      this.services.put(service, fee);
   }

   @Override public String toString() {
      String s = "Membros:";
      for (Employee member : this.members.values())
         s += "\n  " + member.memberInfo();
      s += "\nServiços:";
      for (Map.Entry<String, Double> service : this.services.entrySet())
         s += "\n  " + service.getKey() + ": " + service.getValue();
      return s;
   }
}