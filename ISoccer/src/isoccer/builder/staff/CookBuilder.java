package isoccer.builder.staff;

import isoccer.model.staff.Cook;

public class CookBuilder extends MemberBuilder {
   @Override
   public Cook build() throws Exception {
      Cook cook = new Cook(memberCount++);
      setInfo(cook);
      put(cook);

      return cook;
   }

   @Override
   public String getType() {
      return "cozinheiro";
   }
}