package iface.action;

import iface.model.User;

public class AddFriend extends Action {
   @Override public void doAction() {
      User user = this.signIn();
      if (user == null)
         return;

      User friend = this.getUser("Login do amigo");
      if (friend == null)
         return;

      friend.setFriendRequest(user);
      System.out.println("Solicitação de amizade enviada para " +
            friend.getName() + ".");
   }

   @Override public String toString() {
      return "adicionar amigo";
   }
}