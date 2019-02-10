package isoccer.action;

import isoccer.builder.partner.*;
import isoccer.ISoccer;
import isoccer.model.partner.FanPartner;

public class AddPartner implements Action {
   private FanPartnerBuilder[] builders;

   public AddPartner() {
      builders = new FanPartnerBuilder[] {
         new JuniorBuilder(), new SeniorBuilder(), new EliteBuilder()
      };
   }

   @Override
   public void doAction() throws Exception {
      System.out.println("---");
      int p;
      for (p = 0; p < builders.length; p++)
         System.out.println(p + " - " + builders[p].getType());
      System.out.print("---\nTipo: ");
      p = Integer.parseInt(ISoccer.input.nextLine());

      FanPartner partner = builders[p].build();

      System.out.println("Sócio-torcedor '" + partner.id +
            ": " + partner.getName() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar sócio-torcedor";
   }
}