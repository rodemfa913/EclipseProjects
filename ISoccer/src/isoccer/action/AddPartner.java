package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.partner.*;

public class AddPartner extends Action {
   @Override
   public void doAction() throws Exception {
      FanPartner[] creators = new FanPartner[] {
         new Junior(), new Senior(), new Elite()
      };

      System.out.println("---");
      int t;
      for (t = 0; t < creators.length; t++)
         System.out.println(t + " - " + creators[t].getType());
      System.out.print("---\nTipo: ");
      t = Integer.parseInt(ISoccer.input.nextLine());

      FanPartner partner = (FanPartner)
            creators[t].create(ISoccer.partners.size());

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

      System.out.print("Valor de contribuição (" + partner.getType() + "): ");
      partner.setContribution(Double.parseDouble(ISoccer.input.nextLine()));

      System.out.print("Inadiplente? (s/n): ");
      partner.defaulting = ISoccer.input.nextLine().toLowerCase().equals("s");

      ISoccer.partners.add(partner);

      System.out.println("Sócio-torcedor '" + partner.id +
            ": " + partner.getName() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar sócio-torcedor";
   }
}