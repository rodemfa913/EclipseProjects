package isoccer.action;

import isoccer.ISoccer;
import isoccer.manager.partner.*;
import isoccer.model.partner.FanPartner;

public class AddPartner extends Action {
   private FanPartnerManager[] builders;

   public AddPartner() {
      builders = new FanPartnerManager[] {
         new JuniorManager(), new SeniorManager(), new EliteManager()
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