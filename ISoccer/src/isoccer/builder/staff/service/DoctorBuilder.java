package isoccer.builder.staff.service;

import isoccer.ISoccer;
import isoccer.model.staff.Member;
import isoccer.model.staff.service.Doctor;

public class DoctorBuilder extends AbsServiceBuilder {
   @Override
   public Doctor build() throws Exception {
      Doctor doctor = new Doctor(servMemberCount++);
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