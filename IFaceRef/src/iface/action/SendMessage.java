package iface.action;

import iface.IFace;
import iface.model.*;
import java.util.ArrayList;

public class SendMessage extends Action {
   @Override public void doAction() {
      User from = this.signIn();
      if (from == null)
         return;

      System.out.println("---\n0 - usuário\n1 - comunidade\n---");
      System.out.print("Enviar mensagem para: ");
      int t = IFace.input.nextInt();
      IFace.input.nextLine();

      ArrayList<User> toUsers;
      String toName;
      if (t == 1) {
         Community to = this.getCommunity();
         if (to == null)
            return;

         if (!to.hasMember(from)) {
            System.out.println("<!> Não é membro da comunidade.");
            return;
         }
         toUsers = to.getMembers();
         toName = to.getName();
      } else {
         User to = this.getUser("Login do destinatário");
         if (to == null)
            return;

         toUsers = new ArrayList<>();
         toUsers.add(to);
         toName = to.getName();
      }

      System.out.println("Conteúdo da mensagem ('.' para encerrar):");
      String content = "";
      while (true) {
         String line = IFace.input.nextLine();
         if (line.isEmpty() || line.equals("."))
            break;
         content += line + "\n";
      }

      for (User to : toUsers) {
         if (to.equals(from))
            continue;

         Message message = new Message(from, to);
         message.setContent(content);

         ArrayList<Message> messages = from.getMessages(to);
         if (messages == null) {
            messages = new ArrayList<>();
            from.setMessages(to, messages);
            to.setMessages(from, messages);
         }
         messages.add(message);
      }

      System.out.println("Mensagem enviada para " + toName);
   }

   @Override public String toString() {
      return "enviar mensagem";
   }
}