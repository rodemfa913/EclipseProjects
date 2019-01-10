package iface.action.info;

import iface.model.User;

public class ProfileInfo implements Info {
   @Override public void view(User user) {
      System.out.println("Perfil:\n---\n" + user.getProfileAsString());
   }

   @Override public String toString() {
      return "perfil";
   }
}