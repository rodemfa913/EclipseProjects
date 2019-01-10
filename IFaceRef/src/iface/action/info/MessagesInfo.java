package iface.action.info;

import iface.model.*;
import java.util.ArrayList;

public class MessagesInfo implements Info {
   @Override public void view(User user) {
      System.out.println("Mensagens:");
      ArrayList<Message> messages = user.getMessages();
      if (messages.isEmpty())
         System.out.println("nenhuma.");
      else for (Message message : messages) {
         System.out.println("---\n" + message);
      }
   }

   @Override public String toString() {
      return "mensagens";
   }
}