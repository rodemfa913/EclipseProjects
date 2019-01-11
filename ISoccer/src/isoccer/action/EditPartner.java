package isoccer.action;

import isoccer.model.partner.FanPartner;

public class EditPartner extends Action {
   @Override
   public void doAction() throws Exception {
      FanPartner partner = this.getPartner();
      this.editPartnerInfo(partner);
      System.out.println("Sócio-torcedor '" + partner.id +
            ": " + partner.getName() + "' editado.");
   }

   @Override
   public String toString() {
      return "editar sócio-torcedor";
   }
}