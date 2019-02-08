package isoccer.action;

import isoccer.ISoccer;
import isoccer.manager.staff.*;
import isoccer.model.staff.Member;

public class AddMember extends Action {
   private MemberManager[] builders;

   public AddMember() {
      builders = new MemberManager[] {
         new PresidentManager(), new DoctorManager(), new CoachManager(),
         new PhysicalTrainerManager(), new DriverManager(),
         new CookManager(), new LawyerManager(), new PlayerManager()
      };
   }

   @Override
   public void doAction() throws Exception {
      System.out.println("---");
      int m;
      for (m = 0; m < builders.length; m++)
         System.out.println(m + " - " + builders[m].getType());
      System.out.print("---\nTipo: ");
      m = Integer.parseInt(ISoccer.input.nextLine());

      Member member = builders[m].build();

      System.out.println("Funcionário '" + member.id +
            ": " + member.getName() + " adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}