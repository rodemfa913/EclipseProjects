package isoccer.builder.staff.service;

import isoccer.builder.staff.MemberBuilder;
import isoccer.ISoccer;
import isoccer.model.staff.Member;

public abstract class AbsServiceBuilder extends MemberBuilder {
   protected static int servMemberCount;

   protected Member put(Member member) {
      return ISoccer.members.put(member.id, member);
   }
}