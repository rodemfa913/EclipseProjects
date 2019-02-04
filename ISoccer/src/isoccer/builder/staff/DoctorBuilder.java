package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Doctor;
import isoccer.model.staff.Member;

public class DoctorBuilder extends MemberBuilder {
   @Override
   public Doctor build() {
      return new Doctor(memberCount++);
   }

   @Override
   public String getType() {
      return "médico";
   }

   @Override
   public Member put(Member member) {
      return ISoccer.members.put(member.id, member);
   }

   @Override
   public void setInfo(Member member) throws Exception {
      super.setInfo(member);

      Doctor doctor = (Doctor) member;
      System.out.print("CRM: ");
      doctor.setCRM(ISoccer.input.nextLine());
   }
}