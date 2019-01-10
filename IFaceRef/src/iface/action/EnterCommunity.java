package iface.action;

import iface.model.*;

public class EnterCommunity extends Action {
   @Override public void doAction() {
      User member = this.signIn();
      if (member == null)
         return;

      Community community = this.getCommunity();
      if (community == null)
         return;

      community.setMemberRequest(member);
      System.out.println("Solocitação de participação enviada para " +
            community.getName());
   }

   @Override public String toString() {
      return "entrar em comunidade";
   }
}