package iface.action;

import iface.IFace;
import iface.model.User;
import java.util.HashMap;

public class EditProfile extends Action {
   @Override public void doAction() {
      User user = this.signIn();
      if (user == null)
         return;

      HashMap<String, String> profile = user.getProfile();
      while (true) {
         System.out.print("Atributo ('-' para encerrar): ");
         String attribute = IFace.input.nextLine();
         if (attribute.isEmpty() || attribute.equals("-"))
            break;

         System.out.print("Valor: ");
         String value = IFace.input.nextLine();

         if (attribute.toLowerCase().equals("nome"))
            user.setName(value);
         else
            profile.put(attribute, value);
      }
   }

   @Override public String toString() {
      return "editar perfil";
   }
}