package isoccer.builder.staff;

import isoccer.model.staff.Cook;

public class CookBuilder extends MemberBuilder {
   @Override
   public Cook build() {
      return new Cook(memberCount++);
   }

   @Override
   public String getType() {
      return "cozinheiro";
   }
}