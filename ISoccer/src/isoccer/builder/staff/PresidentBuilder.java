package isoccer.builder.staff;

import isoccer.model.staff.President;

public class PresidentBuilder extends MemberBuilder {
   @Override
   public President build() throws Exception {
      President president = new President(memberCount++);
      setInfo(president);
      put(president);

      return president;
   }

   @Override
   public String getType() {
      return "presidente";
   }
}