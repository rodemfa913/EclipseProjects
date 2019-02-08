package isoccer.manager.staff;

import isoccer.model.staff.President;

public class PresidentManager extends MemberManager {
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