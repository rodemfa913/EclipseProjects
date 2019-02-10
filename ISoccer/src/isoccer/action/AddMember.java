package isoccer.action;

import isoccer.builder.staff.*;
import isoccer.ISoccer;
import isoccer.model.staff.Member;

public class AddMember implements Action {
   private MemberBuilder[] builders;

   public AddMember() {
      builders = new MemberBuilder[] {
         new PresidentBuilder(), new DoctorBuilder(), new CoachBuilder(),
         new PhysicalTrainerBuilder(), new DriverBuilder(),
         new CookBuilder(), new LawyerBuilder(), new PlayerBuilder()
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