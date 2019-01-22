package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.staff.Cook;
import isoccer.model.staff.Doctor;
import isoccer.model.staff.Driver;
import isoccer.model.staff.Lawyer;
import isoccer.model.staff.Member;
import isoccer.model.staff.PhysicalTrainer;
import isoccer.model.staff.President;

public class AddMember extends Action {
   @Override
   public void doAction() throws Exception {
      Member[] creators = new Member[] {
         new President(), new Doctor(), new PhysicalTrainer(),
         new Driver(), new Cook(), new Lawyer()
      };

      System.out.println("---");
      int m;
      for (m = 0; m < creators.length; m++)
         System.out.println(m + " - " + creators[m].getType());
      System.out.print("---\nFunção: ");
      m = Integer.parseInt(ISoccer.input.nextLine());

      Member member = (Member) creators[m].create(ISoccer.members.size());

      setMemberInfo(member);
      if (member instanceof Doctor) {
         Doctor doctor = (Doctor) member;
         System.out.print("CRM: ");
         doctor.setCRM(ISoccer.input.nextLine());
      } else if (member instanceof Driver) {
         Driver driver = (Driver) member;
         System.out.print("CNH: ");
         driver.cnh = Long.parseLong(ISoccer.input.nextLine());
      }

      ISoccer.members.add(member);

      System.out.println("Funcionário '" + member.id +
            ": " + member.getName() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}