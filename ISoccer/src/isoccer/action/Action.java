package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.staff.*;

public abstract class Action {
   public abstract void doAction() throws Exception;

   protected void editInfo(Member member) throws Exception {
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
         System.out.print("Inapto? (s/n): ");
         ((Player) member).unable = ISoccer.input.
               nextLine().toLowerCase().equals("s");
      }
   }
}