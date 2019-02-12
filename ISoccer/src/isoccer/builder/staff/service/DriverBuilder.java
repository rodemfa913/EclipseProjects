package isoccer.builder.staff.service;

import isoccer.ISoccer;
import isoccer.model.staff.Member;
import isoccer.model.staff.service.Driver;

public class DriverBuilder extends AbsServiceBuilder {
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