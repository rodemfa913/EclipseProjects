package payment;

import java.util.Scanner;
import payment.action.*;
import payment.model.*;
import payment.model.employee.*;
import payment.state.*;

public class PaymentSystem {
   public static final Scanner input = new Scanner(System.in);
   private static Action lastAction;
   private static Memento lastState;
   public static final Originator state = new Originator();
   private static boolean redo;

   public static void main(String[] args) {
      Action[] actions = new Action[] {
         new Add(), new Remove(), new Edit(), new SignIn(), new SignOut(),
         new LaunchCard(), new LaunchSale(), new LaunchFee(), new Roll()
      };

      while (true) {
         System.out.println("---\n 0 - sair");
         int a;
         for (a = 1; a <= actions.length; a++)
            System.out.printf("%2d - %s\n", a, actions[a - 1]);
         System.out.println("99 - desfazer/refazer\n---");
         System.out.print("Ação: ");
         a = input.nextInt();
         input.nextLine();

         if (a == -1)
            debug();
         else if (a == 99)
            //undoLastAction();
            restore();
         else if (a >= 1 && a <= actions.length) {
            Action action = actions[a - 1];
            if (action.doAction()) {
               lastAction = action;
               redo = true;
            }
         } else {
            System.out.println("Fim.");
            break;
         }
      }
   }

   private static void debug() {
      System.out.println("Original:\n" + state);
      System.out.println("Cópia:\n" + lastState);
   }

   public static Employee editInfo(int id) {
      Employee[] creators = new Employee[] {
         new Hourly(), new Salaried(), new Commissioned()
      };

      System.out.println("---");
      int t;
      for (t = 0; t < creators.length; t++)
         System.out.println(t + " - " + creators[t].getType());
      System.out.print("---\nTipo: ");
      t = input.nextInt();
      input.nextLine();
      if (t < 0 || t >= creators.length)
         t = 0;

      Employee employee = creators[t].create(id);

      System.out.print("Nome: ");
      employee.name = input.nextLine();

      System.out.print("Endereço: ");
      employee.address = input.nextLine();

      Payment.Method[] methods = Payment.Method.values();

      System.out.println("---");
      int m;
      for (m = 0; m < methods.length; m++)
         System.out.println(m + " - " + methods[m]);
      System.out.print("---\nMétodo de pagamento: ");
      m = input.nextInt();
      input.nextLine();
      if (m < 0 || m >= methods.length)
         m = 0;
      employee.paymentMethod = methods[m];

      System.out.print("Salário: ");
      employee.setSalary(input.nextDouble());
      input.nextLine();

      if (employee instanceof Commissioned) {
         System.out.print("Comissão: ");
         ((Commissioned) employee).setCommission(input.nextDouble());
         input.nextLine();
      }

      state.setEmployee(employee);

      return employee;
   }

   public static SimpleDate getDate() {
      System.out.print("Data (DD MM YYYY): ");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt(); input.nextLine();

      return new SimpleDate(year, month, day);
   }

   public static Employee getEmployee() {
      System.out.print("Id do empregado: ");
      Employee employee = state.getEmployees().get(input.nextInt());
      input.nextLine();

      if (employee == null)
         System.out.println("<!> Não encontrado.");

      return employee;
   }

   public static Employee getMember() {
      System.out.print("Id do membro do sindicato: ");
      Employee member = state.getMembers().get(input.nextLine());

      if (member == null)
         System.out.println("<!> Não encontrado.");

      return member;
   }

   private static void restore() {
      if (lastAction == null) {
         System.out.println("<!> Nenhuma ação para desfazer.");
         return;
      }

      Memento swap = state.save();
      state.restore(lastState);
      lastState = swap;

      System.out.print("Ação '" + lastAction + "' ");
      if (redo) {
         System.out.println("refeita.");
         redo = false;
      } else {
         System.out.println("desfeita.");
         redo = true;
      }
   }

   public static void save() {
      lastState = state.save();
   }
}