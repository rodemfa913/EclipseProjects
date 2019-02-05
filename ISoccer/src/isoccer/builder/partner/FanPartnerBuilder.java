package isoccer.builder.partner;

import isoccer.builder.Builder;
import isoccer.ISoccer;
import isoccer.model.partner.FanPartner;

public abstract class FanPartnerBuilder extends Builder<FanPartner> {
   protected static int partnerCount;

   @Override
   protected FanPartner put(FanPartner partner) {
      return ISoccer.partners.put(partner.id, partner);
   }

   @Override
   protected void setInfo(FanPartner partner) throws Exception {
      System.out.print("Nome: ");
      partner.setName(ISoccer.input.nextLine());

      System.out.print("E-mail: ");
      partner.setEmail(ISoccer.input.nextLine());

      System.out.print("CPF: ");
      partner.setCPF(ISoccer.input.nextLine());

      System.out.print("Telefone: ");
      partner.phone = Long.parseLong(ISoccer.input.nextLine());

      System.out.print("Endereço: ");
      partner.setAddress(ISoccer.input.nextLine());

      System.out.print("Valor de contribuição (" + getType() + "): ");
      partner.setContribution(Double.parseDouble(ISoccer.input.nextLine()));

      System.out.print("Inadiplente? (s/n): ");
      partner.defaulting = ISoccer.input.nextLine().toLowerCase().equals("s");
   }
}