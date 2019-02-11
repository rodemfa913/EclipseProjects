package isoccer.builder.staff.service;

import isoccer.model.staff.service.Cook;

public class CookBuilder extends AbsServiceBuilder {
   @Override
   public Cook build() throws Exception {
      Cook cook = new Cook(servMemberCount++);
      setInfo(cook);
      put(cook);

      return cook;
   }

   @Override
   public String getType() {
      return "cozinheiro";
   }
}