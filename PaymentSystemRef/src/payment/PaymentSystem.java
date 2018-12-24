package payment;

import java.util.Scanner;
import payment.action.*;
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
      System.out.println("Original:\n---\n" + state);
      System.out.println("---\nCópia:\n---\n" + lastState);
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