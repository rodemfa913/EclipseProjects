package isoccer.builder.staff;

import isoccer.builder.Builder;
import isoccer.ISoccer;
import isoccer.model.staff.Member;

public abstract class MemberBuilder extends Builder<Member> {
   protected static int memberCount;

   @Override
   protected Member put(Member member) {
      return ISoccer.members.put(member.id, member);
   }

   @Override
   protected void setInfo(Member member) throws Exception {
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
}