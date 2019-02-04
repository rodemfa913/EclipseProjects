package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Coach;
import isoccer.model.staff.Member;

public class CoachBuilder extends MemberBuilder {
   @Override
   public Coach build() {
      return new Coach(0);
   }

   @Override
   public String getType() {
      return "técnico";
   }

   @Override
   public Coach put(Member member) {
      Coach prevCoach = ISoccer.coach;
      ISoccer.coach = (Coach) member;
      return prevCoach;
   }
}