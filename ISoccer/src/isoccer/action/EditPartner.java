package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.partner.FanPartner;

public class EditPartner extends Action {
   @Override
   public void doAction() throws Exception {
      System.out.print("Id do sócio-torcedor: ");
      int id = Integer.parseInt(ISoccer.input.nextLine());

      FanPartner partner = ISoccer.partners.get(id);
      if (partner == null)
         throw notFoundException;

      partnerInfo(partner);

      System.out.println("Sócio-torcedor '" + partner.id +
            ": " + partner.getName() + "' editado.");
   }

   @Override
   public String toString() {
      return "editar sócio-torcedor";
   }
}