package isoccer.builder.staff.service;

import isoccer.model.staff.service.President;

public class PresidentBuilder extends AbsServiceBuilder {
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