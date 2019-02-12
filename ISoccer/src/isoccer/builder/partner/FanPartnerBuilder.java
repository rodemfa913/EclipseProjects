package isoccer.builder.partner;

import isoccer.builder.Builder;
import isoccer.ISoccer;
import isoccer.model.partner.FanPartner;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class FanPartnerBuilder implements Builder<FanPartner> {
   protected static int partnerCount;
   private static final HashMap<Integer, FanPartner> partners = new HashMap<>();

   public static ArrayList<FanPartner> getPartners() {
      return new ArrayList<>(partners.values());
   }

   protected FanPartner put(FanPartner partner) {
      return partners.put(partner.id, partner);
   }

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