package isoccer.manager.staff;

import isoccer.model.staff.Cook;

public class CookManager extends MemberManager {
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