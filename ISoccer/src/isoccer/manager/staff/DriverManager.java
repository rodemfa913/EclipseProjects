package isoccer.manager.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Driver;
import isoccer.model.staff.Member;

public class DriverManager extends MemberManager {
   @Override
   public Driver build() throws Exception {
      Driver driver = new Driver(memberCount++);
      setInfo(driver);
      put(driver);

      return driver;
   }

   @Override
   public String getType() {
      return "motorista";
   }

   @Override
   protected void setInfo(Member member) throws Exception {
      super.setInfo(member);

      Driver driver = (Driver) member;
      System.out.print("CNH: ");
      driver.cnh = Long.parseLong(ISoccer.input.nextLine());
   }
}