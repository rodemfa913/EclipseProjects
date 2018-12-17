package payment;

import java.util.*;
import payment.model.*;

public class PaymentSystem {
   private static HashMap<Integer, Employee> bkpEmployees;
   private static Syndicate bkpSyndicate;
   static HashMap<Integer, Employee> employees;
   static Scanner input;
   private static Action lastAction;
   private static boolean redo;
   static Syndicate syndicate;

   public static void main(String[] args) {
      employees = new HashMap<>();
      input = new Scanner(System.in);
      syndicate = new Syndicate();

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
            undoLastAction();
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

   static void copyData() {
      bkpEmployees = new HashMap<>(employees);
      bkpSyndicate = syndicate.clone();
   }

   private static void debug() {
      System.out.println("Empregados:");
      for (Employee employee : employees.values())
         System.out.println("---\n" + employee);

      if (bkpEmployees != null) {
         System.out.println("---\nEmpregados (backup):");
         for (Employee employee : bkpEmployees.values())
            System.out.println("---\n" + employee);
      }

      System.out.println("---\nSindicato:\n---\n" + syndicate);

      if (bkpSyndicate != null)
         System.out.println("Sindicato (backup):\n---\n" + bkpSyndicate);
   }

   static Employee editInfo(int id) {
      Employee[] creators = new Employee[] {
         new Hourly(), new Salaried(), new Commissioned()
      };
      String[] types = new String[] {
            Hourly.getType(), Salaried.getType(), Commissioned.getType()
      };

      System.out.println("---");
      int t;
      for (t = 0; t < types.length; t++)
         System.out.println(t + " - " + types[t]);
      System.out.print("---\nTipo: ");
      t = input.nextInt();
      input.nextLine();
      if (t < 0 || t >= types.length)
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

      return employee;
   }

   static SimpleDate getDate() {
      System.out.print("Data (DD MM YYYY): ");
      int day = input.nextInt();
      int month = input.nextInt();
      int year = input.nextInt(); input.nextLine();

      return new SimpleDate(year, month, day);
   }

   static Employee getEmployee() {
      System.out.print("Id do empregado: ");
      Employee employee = employees.get(input.nextInt());
      input.nextLine();

      if (employee == null) {
         System.out.println("<!> Não encontrado.");
         return null;
      }

      return employee;
   }

   static Employee getMember() {
      System.out.print("Id do membro do sindicato: ");
      Employee member = syndicate.getMembers().get(input.nextLine());

      if (member == null)
         System.out.println("<!> Não encontrado.");

      return member;
   }

   static void setEmployee(Employee employee) {
      employees.put(employee.getId(), employee);
      if (employee.syndicateId != null)
         syndicate.getMembers().put(employee.syndicateId, employee);
   }

   private static void undoLastAction() {
      if (lastAction == null) {
         System.out.println("<!> Nenhuma ação para desfazer.");
         return;
      }

      HashMap<Integer, Employee> eSwap = employees;
      Syndicate sSwap = syndicate;
      employees = bkpEmployees;
      syndicate = bkpSyndicate;
      bkpEmployees = eSwap;
      bkpSyndicate = sSwap;
      
      System.out.print("Ação '" + lastAction + "' ");
      if (redo) {
         System.out.println("refeita.");
         redo = false;
      } else {
         System.out.println("desfeita.");
         redo = true;
      }
   }
}