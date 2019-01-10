package iface.action;

import iface.IFace;
import iface.model.*;

public abstract class Action {
   public abstract void doAction();

   protected Community getCommunity() {
      System.out.print("Nome da comunidade: ");
      Community community = IFace.communities.get(IFace.input.nextLine());
      if (community == null)
         System.out.println("<!> Comunidade não encontrada.");

      return community;
   }

   protected User getUser(String prompt) {
      System.out.print(prompt + ": ");
      User user = IFace.users.get(IFace.input.nextLine());
      if (user == null)
         System.out.println("<!> Usuário não encontrado.");

      return user;
   }

   protected User signIn() {
      User user = this.getUser("Login");
      if (user == null)
         return null;

      System.out.print("Senha: ");
      if (!IFace.passwords.get(user.getLogin()).
            equals(IFace.input.nextLine())) {
         System.out.println("<!> Senha incorreta.");
         return null;
      }

      return user;
   }
}