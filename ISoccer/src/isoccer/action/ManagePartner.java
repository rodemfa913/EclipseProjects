package isoccer.action;

import isoccer.builder.partner.FanPartnerBuilder;
import isoccer.ISoccer;
import isoccer.model.partner.FanPartner;

public class ManagePartner implements Action {
   private final Exception notFoundException = new Exception("Não encontrado.");

   @Override
   public void doAction() throws Exception {
      FanPartner partner = FanPartnerBuilder.getPartner();
      if (partner == null)
         throw notFoundException;

      System.out.print("Inadimplente? (s/n): ");
      partner.defaulting = ISoccer.input.nextLine().toLowerCase().equals("s");
   }

   @Override
   public String toString() {
      return "gerenciar sócio-torcedor";
   }
}