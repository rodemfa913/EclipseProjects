package isoccer;

import isoccer.action.*;
import java.util.Scanner;

public class ISoccer {
   public static final Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      System.out.print("Login: ");
      if (!input.nextLine().equals("admin")) {
         System.out.println("<!> Login incorreto.");
         System.exit(1);
      }

      System.out.print("Senha: ");
      if (!input.nextLine().equals("12345")) {
         System.out.println("<!> Senha incorreta.");
         System.exit(2);
      }

      Action[] actions = new Action[] {
         new AddMember(), new AddPartner(), new AddResource(),
         new ManagePlayer(), new ManagePartner(),
         new ManageResource(), new GenerateReport()
      };

      while (true) {
         System.out.println("---\n0 - sair");
         int a;
         for (a = 1; a <= actions.length; a++)
            System.out.println(a + " - " + actions[a - 1]);
         System.out.print("---\nAção: ");

         try {
            a = Integer.parseInt(input.nextLine());
            if (a == 0)
               break;

            actions[a - 1].doAction();
         }

         catch (NumberFormatException | IndexOutOfBoundsException ex) {
            System.out.println("<!> Entrada inválida.");
         }
         catch (Exception ex) {
            System.out.println("<!> " + ex.getMessage());
         }
      }
   }
}