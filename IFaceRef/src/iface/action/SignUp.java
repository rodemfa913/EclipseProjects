package iface.action;

import iface.IFace;
import iface.model.User;

public class SignUp extends Action {
   @Override public void doAction() {
      System.out.print("Login: ");
      String login = IFace.input.nextLine();
      if (login.isEmpty())
         login = "0";
      if (IFace.users.containsKey(login)) {
         System.out.println("<!> Login já existe.");
         return;
      }

      User user = new User(login);

      System.out.print("Senha: ");
      IFace.passwords.put(login, IFace.input.nextLine());

      System.out.print("Nome de usuário: ");
      user.setName(IFace.input.nextLine());

      IFace.users.put(login, user);

      System.out.println("Conta de usuário " + user.getName() + " criada.");
   }

   @Override public String toString() {
      return "criar conta";
   }
}