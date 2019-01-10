package iface.action;

import iface.IFace;
import iface.model.*;

public class AddCommunity extends Action {
   @Override public void doAction() {
      User owner = this.signIn();
      if (owner == null)
         return;

      System.out.print("Nome da comunidade: ");
      String name = IFace.input.nextLine();
      if (name.isEmpty())
         name = "0";
      if (IFace.communities.containsKey(name)) {
         System.out.println("<!> Comunidade já existe.");
         return;
      }

      Community community = new Community(name, owner);
      owner.setCommunity(community);

      System.out.print("Descrição: ");
      community.setDescription(IFace.input.nextLine());

      IFace.communities.put(name, community);
      System.out.println("Comunidade " + name + " criada.");
   }

   @Override public String toString() {
      return "criar comunidade";
   }
}