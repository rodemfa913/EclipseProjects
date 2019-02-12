package isoccer.builder.staff;

import isoccer.model.staff.Coach;

public class CoachBuilder extends MemberBuilder {
   private static Coach coach;

   @Override
   public Coach build() throws Exception {
      coach = new Coach(0);
      setInfo(coach);

      return coach;
   }

   public static Coach getCoach() {
      return coach;
   }

   @Override
   public String getType() {
      return "técnico";
   }
}