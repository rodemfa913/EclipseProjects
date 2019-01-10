package iface.action;

import iface.IFace;
import iface.model.*;

public class SignOut extends Action {
   @Override public void doAction() {
      User user = this.signIn();
      if (user == null)
         return;

      String name;

      for (Community community : user.getOwnCommunities()) {
         name = community.getName();
         for (User member : community.getMembers()) {
            member.removeCommunity(community);
            System.out.println("Membro " + member.getName() +
                  " removido da comunidade " + name + ".");
         }

         IFace.communities.remove(name);
         System.out.println("Comunidade " + name + " removida.");
      }

      name = user.getName();

      for (Community community : user.getCommunities()) {
         community.removeMember(user);
         System.out.println("Membro " + name +
               " removido da comunidade " + community.getName() + ".");
      }

      for (User friend : user.getFriends()) {
         friend.removeFriend(user);
         System.out.println("Amizade entre " + name +
               " e " + friend.getName() + " removida.");
      }

      for (Message message : user.getMessages()) {
         User fromTo = message.getFrom();
         if (fromTo.equals(user))
            fromTo = message.getTo();
         fromTo.removeMessages(user);
         System.out.println("Mensagens enviadas/recebidas por " +
               name + " para/de " + fromTo.getName() + " removidas.");
      }

      IFace.users.remove(user.getLogin());
      System.out.println("Conta de usuário " + user.getName() + " removida.");
   }

   @Override public String toString() {
      return "remover conta";
   }
}