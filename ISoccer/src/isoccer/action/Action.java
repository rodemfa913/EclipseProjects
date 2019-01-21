package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.partner.FanPartner;
import isoccer.model.staff.Member;

public abstract class Action {
   protected static final Exception notFoundException =
         new Exception("Não encontrado.");

   public abstract void doAction() throws Exception;

   protected void setMemberInfo(Member member) throws Exception {
      System.out.print("Nome: ");
      member.setName(ISoccer.input.nextLine());

      System.out.print("E-mail: ");
      member.setEmail(ISoccer.input.nextLine());

      System.out.print("CPF: ");
      member.setCPF(ISoccer.input.nextLine());

      System.out.print("Salário: ");
      member.setSalary(Double.parseDouble(ISoccer.input.nextLine()));

      System.out.print("Telefone: ");
      member.phone = Long.parseLong(ISoccer.input.nextLine());
   }

   protected void setPartnerInfo(FanPartner partner) throws Exception {
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
   }
}