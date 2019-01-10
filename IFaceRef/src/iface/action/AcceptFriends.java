package iface.action;

import iface.IFace;
import iface.model.User;
import java.util.ArrayList;

public class AcceptFriends extends Action {
   @Override public void doAction() {
      User user = this.signIn();
      if (user == null)
         return;

      ArrayList<User> friendRequests = user.getFriendRequests();
      if (friendRequests.isEmpty()) {
         System.out.println("<!> Nenhuma solicitaçao de amizade.");
         return;
      }

      for (User friend : friendRequests) {
         String name = friend.getName();
         System.out.print("Usuário: " + name + "\nAceitar? (s/n): ");
         boolean accept = IFace.input.nextLine().equals("s");
         user.acceptFriend(friend, accept);

         if (accept) {
            friend.setFriendRequest(user);
            friend.acceptFriend(user, true);
            System.out.println("Amigo " + name + " adicionado.");
         }
      }
   }

   @Override public String toString() {
      return "aceitar amigo";
   }
}