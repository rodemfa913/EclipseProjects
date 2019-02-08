package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Coach;

public class CoachBuilder extends MemberBuilder {
   @Override
   public Coach build() throws Exception {
      Coach coach = new Coach(0);
      setInfo(coach);
      ISoccer.coach = coach;

      return coach;
   }

   @Override
   public String getType() {
      return "técnico";
   }
}