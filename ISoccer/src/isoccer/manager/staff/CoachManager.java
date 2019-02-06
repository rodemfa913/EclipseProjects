package isoccer.manager.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Coach;
import isoccer.model.staff.Member;

public class CoachManager extends MemberManager {
   @Override
   public Coach build() throws Exception {
      Coach coach = new Coach(0);
      setInfo(coach);
      put(coach);

      return coach;
   }

   @Override
   public String getType() {
      return "técnico";
   }

   @Override
   protected Coach put(Member member) {
      Coach prevCoach = ISoccer.coach;
      ISoccer.coach = (Coach) member;
      return prevCoach;
   }
}