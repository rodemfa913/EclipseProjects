package iface.action;

import iface.IFace;
import iface.model.*;
import java.util.ArrayList;

public class AcceptMembers extends Action {
   @Override public void doAction() {
      User owner = this.signIn();
      if (owner == null)
         return;

      ArrayList<Community> communities = owner.getOwnCommunities();
      if (communities.isEmpty()) {
         System.out.println("<!> Nenhuma comunidade criada.");
         return;
      }

      for (Community community : communities) {
         ArrayList<User> memberRequests = community.getMemberRequests();
         if (memberRequests.isEmpty())
            continue;

         System.out.println("Solicitações de participação pendentes para " +
               community.getName() + ":");
         for (User member : memberRequests) {
            String name = member.getName();
            System.out.print("Membro: " + name + "\nAceitar? (s/n): ");
            boolean accept = IFace.input.nextLine().equals("s");
            community.acceptMember(member, accept);
            if (accept)
               System.out.println("Membro " + name + " adicionado.");
         }
      }
   }

   @Override public String toString() {
      return "aceitar membros";
   }
}