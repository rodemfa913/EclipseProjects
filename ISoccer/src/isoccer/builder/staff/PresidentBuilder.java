package isoccer.builder.staff;

import isoccer.model.staff.President;

public class PresidentBuilder extends MemberBuilder {
   @Override
   public President build() {
      return new President(memberCount++);
   }

   @Override
   public String getType() {
      return "presidente";
   }
}