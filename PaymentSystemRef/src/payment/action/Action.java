package payment.action;

import payment.model.employee.*;
import payment.model.*;
import payment.PaymentSystem;

public abstract class Action {
   public abstract boolean doAction();

   protected static Employee editInfo(int id) {
      Employee[] creators = new Employee[] {
         new Hourly(), new Salaried(), new Commissioned()
      };

      System.out.println("---");
      int i;
      for (i = 0; i < creators.length; i++)
         System.out.println(i + " - " + creators[i].getType());
      System.out.print("---\nTipo: ");
      i = PaymentSystem.input.nextInt();
      PaymentSystem.input.nextLine();
      if (i < 0 || i >= creators.length)
         i = 0;

      Employee employee = creators[i].create(id);

      System.out.print("Nome: ");
      employee.name = PaymentSystem.input.nextLine();

      System.out.print("Endereço: ");
      employee.address = PaymentSystem.input.nextLine();

      Payment.Method[] methods = Payment.Method.values();

      System.out.println("---");
      for (i = 0; i < methods.length; i++)
         System.out.println(i + " - " + methods[i]);
      System.out.print("---\nMétodo de pagamento: ");
      i = PaymentSystem.input.nextInt();
      PaymentSystem.input.nextLine();
      if (i < 0 || i >= methods.length)
         i = 0;
      employee.paymentMethod = methods[i];

      System.out.print("Salário: ");
      employee.setSalary(PaymentSystem.input.nextDouble());
      PaymentSystem.input.nextLine();

      if (employee instanceof Commissioned) {
         System.out.print("Comissão: ");
         ((Commissioned) employee).setCommission(
               PaymentSystem.input.nextDouble());
         PaymentSystem.input.nextLine();
      }

      PaymentSystem.state.setEmployee(employee);

      return employee;
   }

   protected static SimpleDate getDate() {
      System.out.print("Data (DD MM YYYY): ");
      int day = PaymentSystem.input.nextInt();
      int month = PaymentSystem.input.nextInt();
      int year = PaymentSystem.input.nextInt();
      PaymentSystem.input.nextLine();

      return new SimpleDate(year, month, day);
   }

   protected static Employee getEmployee() {
      System.out.print("Id do empregado: ");
      Employee employee = PaymentSystem.state.getEmployee(
            PaymentSystem.input.nextInt());
      PaymentSystem.input.nextLine();

      if (employee == null)
         System.out.println("<!> Não encontrado.");

      return employee;
   }

   protected static Employee getMember() {
      System.out.print("Id do membro do sindicato: ");
      Employee member = PaymentSystem.state.getMember(
            PaymentSystem.input.nextLine());

      if (member == null)
         System.out.println("<!> Não encontrado.");

      return member;
   }
}