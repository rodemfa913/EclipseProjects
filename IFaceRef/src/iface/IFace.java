package iface;

import iface.action.*;
import iface.model.*;
import java.util.*;

public class IFace {
   public static final HashMap<String, Community> communities = new HashMap<>();
   public static final Scanner input = new Scanner(System.in);
   public static final HashMap<String, String> passwords = new HashMap<>();
   public static final HashMap<String, User> users = new HashMap<>();

   public static void main(String[] args) {
      Action[] actions = new Action[] {
         new SignUp(), new SignOut(), new EditProfile(), new AddFriend(),
         new AcceptFriends(), new AddCommunity(), new EnterCommunity(),
         new AcceptMembers(), new SendMessage(), new ViewInfo()
      };

      while (true) {
         System.out.println("---\n 0 - sair");
         int a;
         for (a = 1; a <= actions.length; a++)
            System.out.printf("%2d - %s\n", a, actions[a - 1]);
         System.out.print("---\nAção: ");
         a = input.nextInt();
         input.nextLine();
         if (a == -1)
            debug();
         else if (a >= 1 && a <= actions.length)
            actions[a - 1].doAction();
         else {
            System.out.println("Fim.");
            break;
         }
      }
   }

   private static void debug() {
      System.out.println("Usuários:");
      for (User user : users.values()) {
         System.out.println("---\n" + user);
         System.out.println("Senha: " + passwords.get(user.getLogin()));
      }

      System.out.println("---\nComunidades:");
      for (Community community : communities.values())
         System.out.println("---\n" + community);
   }
}
