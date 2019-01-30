package isoccer.action;

import isoccer.action.builder.Builder;
import isoccer.action.builder.CoachBuilder;
import isoccer.ISoccer;
import isoccer.model.staff.Member;
import java.util.ArrayList;

public class AddMbr extends Action {
   @Override
   public void doAction() throws Exception {
      ArrayList<Builder<? extends Member>> builders = new ArrayList<>();
      builders.add(new CoachBuilder());

      System.out.println("---");
      int m = 0;
      for (Builder<? extends Member> builder : builders)
         System.out.println((m++) + " - " + builder.getType());
      System.out.print("---\nTipo: ");
      m = Integer.parseInt(ISoccer.input.nextLine());

      Member member = builders.get(m).build();

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

      System.out.println("Funcionário " + member.getName() + " adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}