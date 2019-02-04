package isoccer.action;

import isoccer.ISoccer;
import isoccer.builder.staff.*;
import isoccer.builder.staff.player.PlayerBuilder;
import isoccer.model.staff.Member;

public class AddMember extends Action {
   @Override
   public void doAction() throws Exception {
      MemberBuilder[] builders = new MemberBuilder[] {
         new PresidentBuilder(), new DoctorBuilder(), new CoachBuilder(),
         new PhysicalTrainerBuilder(), new DriverBuilder(), new CookBuilder(),
         new LawyerBuilder(), new PlayerBuilder()
      };

      System.out.println("---");
      int m;
      for (m = 0; m < builders.length; m++)
         System.out.println(m + " - " + builders[m].getType());
      System.out.print("---\nTipo: ");
      m = Integer.parseInt(ISoccer.input.nextLine());

      Member member = builders[m].build();
      builders[m].setInfo(member);
      builders[m].put(member);

      System.out.println("Funcionário '" + member.id +
            ": " + member.getName() + " adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}