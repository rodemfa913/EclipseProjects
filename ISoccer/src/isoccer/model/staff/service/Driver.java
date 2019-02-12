package isoccer.model.staff.service;

import isoccer.model.staff.Member;

public class Driver extends Member {
   public long cnh;

   public Driver(int id) {
      super(id);
   }

   @Override
   public String toString() {
      return super.toString() + "\nCNH: " + cnh;
   }
}