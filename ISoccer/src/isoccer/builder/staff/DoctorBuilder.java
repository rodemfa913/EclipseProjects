package isoccer.builder.staff;

import isoccer.ISoccer;
import isoccer.model.staff.Doctor;
import isoccer.model.staff.Member;

public class DoctorBuilder extends MemberBuilder {
   @Override
   public Doctor build() throws Exception {
      Doctor doctor = new Doctor(memberCount++);
      setInfo(doctor);
      put(doctor);

      return doctor;
   }

   @Override
   public String getType() {
      return "médico";
   }

   @Override
   protected void setInfo(Member member) throws Exception {
      super.setInfo(member);

      Doctor doctor = (Doctor) member;
      System.out.print("CRM: ");
      doctor.setCRM(ISoccer.input.nextLine());
   }
}