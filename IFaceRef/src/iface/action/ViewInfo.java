package iface.action;

import iface.IFace;
import iface.action.info.*;
import iface.model.User;

public class ViewInfo extends Action {
   @Override public void doAction() {
      User user = this.signIn();
      if (user == null)
         return;

      Info[] infos = new Info[] {
         new ProfileInfo(), new CommunitiesInfo(),
         new FriendsInfo(), new MessagesInfo()
      };

      System.out.println("---");
      int i;
      for (i = 0; i < infos.length; i++)
         System.out.println(i + " - " + infos[i]);
      System.out.print("---\nInformação: ");
      i = IFace.input.nextInt();
      IFace.input.nextLine();
      if (i < 0 || i >= infos.length)
         i = 0;

      infos[i].view(user);
   }

   @Override public String toString() {
      return "visualizar informações";
   }
}