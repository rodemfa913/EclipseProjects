package isoccer.builder.staff.service;

import isoccer.builder.staff.MemberBuilder;
import isoccer.model.staff.Member;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbsServiceBuilder extends MemberBuilder {
   protected static int memberCount;
   private static final HashMap<Integer, Member> members = new HashMap<>();

   public static ArrayList<Member> getMembers() {
      return new ArrayList<>(members.values());
   }

   protected Member put(Member member) {
      return members.put(member.id, member);
   }
}