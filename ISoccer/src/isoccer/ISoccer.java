package isoccer;

import isoccer.action.*;
import isoccer.model.partner.FanPartner;
import isoccer.model.resource.Bus;
import isoccer.model.resource.Stadium;
import isoccer.model.resource.TrainingCenter;
import isoccer.model.staff.Coach;
import isoccer.model.staff.Member;
import isoccer.model.staff.player.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class ISoccer {
   public static Coach coach;
   public static final ArrayList<Bus> fleet = new ArrayList<>();
   public static final Scanner input = new Scanner(System.in);
   public static final ArrayList<Member> members = new ArrayList<>();
   public static final ArrayList<FanPartner> partners = new ArrayList<>();
   public static final ArrayList<Player> players = new ArrayList<>();
   public static Stadium stadium;
   public static TrainingCenter trainingCenter;

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
         new AddMember(), new AddCoach(), new AddPlayer(), new AddPartner(),
         new AddBus(), new AddStadium(), new AddTrainingCenter()
      };

      while (true) {
         System.out.println("---\n 0 - sair");
         int a;
         for (a = 1; a <= actions.length; a++)
            System.out.printf("%2d - %s\n", a, actions[a - 1]);
         System.out.print("---\nAção: ");

         try {
            a = Integer.parseInt(input.nextLine());
            if (a == 0)
               break;

            actions[a - 1].doAction();
         }

         catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            System.out.println("<!> Entrada inválida.");
         }
         catch (Exception ex) {
            System.out.println("<!> " + ex.getMessage());
         }
      }
   }
}