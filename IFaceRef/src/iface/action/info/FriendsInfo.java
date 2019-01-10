package iface.action.info;

import iface.model.User;
import java.util.ArrayList;

public class FriendsInfo implements Info {
   @Override public void view(User user) {
      System.out.println("Amigos:");
      ArrayList<User> friends = user.getFriends();
      if (friends.isEmpty())
         System.out.println("nenhum.");
      else for (User friend : friends)
         System.out.println("---\n" + friend);
   }

   @Override public String toString() {
      return "amigos";
   }
}