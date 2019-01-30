package isoccer.action.builder;

import isoccer.model.staff.Coach;

public class CoachBuilder implements Builder<Coach> {
   @Override
   public Coach build() {
      return new Coach();
   }

   @Override
   public String getType() {
      return "técnico";
   }
}