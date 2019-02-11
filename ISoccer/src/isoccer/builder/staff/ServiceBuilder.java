package isoccer.builder.staff;

import isoccer.builder.staff.service.*;
import isoccer.ISoccer;
import isoccer.model.staff.Member;

public class ServiceBuilder extends MemberBuilder {
   private AbsServiceBuilder[] builders;

   public ServiceBuilder() {
      builders = new AbsServiceBuilder[] {
         new PresidentBuilder(), new DoctorBuilder(),
         new PhysicalTrainerBuilder(), new DriverBuilder(),
         new CookBuilder(), new LawyerBuilder()
      };
   }

   @Override
   public Member build() throws Exception {
      System.out.println("---");
      int s;
      for (s = 0; s < builders.length; s++)
         System.out.println(s + " - " + builders[s].getType());
      System.out.print("---\nFunção: ");
      s = Integer.parseInt(ISoccer.input.nextLine());

      return builders[s].build();
   }

   @Override
   public String getType() {
      return "serviços gerais";
   }
}