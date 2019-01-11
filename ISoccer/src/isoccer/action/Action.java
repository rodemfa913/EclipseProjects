package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.partner.FanPartner;
import isoccer.model.staff.Doctor;
import isoccer.model.staff.Driver;
import isoccer.model.staff.Member;
import isoccer.model.staff.Player;

public abstract class Action {
   private static final Exception notFoundException =
         new Exception("Não encontrado.");

   public abstract void doAction() throws Exception;

   protected void editMemberInfo(Member member) throws Exception {
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

      if (member instanceof Doctor) {
         Doctor doctor = (Doctor) member;
         System.out.print("CRM\n  atual: " + doctor.getCRM() + "\n   novo: ");
         doctor.setCRM(ISoccer.input.nextLine());
      } else if (member instanceof Driver) {
         Driver driver = (Driver) member;
         System.out.print("CNH\n atual: " + driver.cnh + "\n   novo: ");
         driver.cnh = Long.parseLong(ISoccer.input.nextLine());
      } else if (member instanceof Player) {
         Player player = (Player) member;
         String unable = player.unable ? "s" : "n";
         System.out.print("Inapto? (s/n)\n  atual: " + unable + "\n   novo: ");
         unable = ISoccer.input.nextLine().toLowerCase();
         player.unable = unable.equals("s");
      }
   }

   protected void editPartnerInfo(FanPartner partner) throws Exception {
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

   protected Member getMember() throws Exception {
      System.out.print("Id do funcionário: ");
      int id = Integer.parseInt(ISoccer.input.nextLine());

      Member member = ISoccer.members.get(id);
      if (member == null)
         throw notFoundException;

      return member;
   }

   protected FanPartner getPartner() throws Exception {
      System.out.print("Id do sócio-torcedor: ");
      int id = Integer.parseInt(ISoccer.input.nextLine());

      FanPartner partner = ISoccer.partners.get(id);
      if (partner == null)
         throw notFoundException;

      return partner;
   }
}