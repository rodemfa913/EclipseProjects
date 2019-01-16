package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.partner.FanPartner;
import isoccer.model.staff.Member;

public abstract class Action {
   protected static final Exception notFoundException =
         new Exception("Não encontrado.");

   public abstract void doAction() throws Exception;

   protected void setMemberInfo(Member member) throws Exception {
      System.out.print("Nome\n  atual: " + member.getName() + "\n   novo: ");
      member.setName(ISoccer.input.nextLine());

      System.out.print("E-mail\n  atual: " + member.getEmail() + "\n   novo: ");
      member.setEmail(ISoccer.input.nextLine());

      System.out.print("CPF\n  atual: " + member.getCPF() + "\n   novo: ");
      member.setCPF(ISoccer.input.nextLine());

      System.out.print("Salário\n  atual: " +
            member.getSalary() + "\n   novo: ");
      member.setSalary(Double.parseDouble(ISoccer.input.nextLine()));

      System.out.print("Telefone\n  atual: " + member.phone + "\n   novo: ");
      member.phone = Long.parseLong(ISoccer.input.nextLine());
   }

   protected void setPartnerInfo(FanPartner partner) throws Exception {
      System.out.print("Nome\n  atual: " + partner.getName() + "\n   novo: ");
      partner.setName(ISoccer.input.nextLine());

      System.out.print("E-mail\n  atual: " + partner.getEmail() + "\n   novo: ");
      partner.setEmail(ISoccer.input.nextLine());

      System.out.print("CPF\n  atual: " + partner.getCPF() + "\n   novo: ");
      partner.setCPF(ISoccer.input.nextLine());

      System.out.print("Telefone\n  atual: " + partner.phone + "\n   novo: ");
      partner.phone = Long.parseLong(ISoccer.input.nextLine());

      System.out.print("Endereço\n  atual: " +
            partner.getAddress() + "\n   novo: ");
      partner.setAddress(ISoccer.input.nextLine());

      System.out.print("Valor de contribuição (" + partner.getType() +
            ")\n  atual: " + partner.getContribution() + "\n   novo: ");
      partner.setContribution(Double.parseDouble(ISoccer.input.nextLine()));

      String defaulting = partner.defaulting ? "s" : "n";
      System.out.print("Inadiplente? (s/n)\n  atual: " +
            defaulting + "\n   novo: ");
      defaulting = ISoccer.input.nextLine().toLowerCase();
      partner.defaulting = defaulting.equals("s");
   }
}