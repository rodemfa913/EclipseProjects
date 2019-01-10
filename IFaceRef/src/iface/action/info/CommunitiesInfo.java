package iface.action.info;

import iface.model.*;
import java.util.ArrayList;

public class CommunitiesInfo implements Info {
   @Override public void view(User user) {
      System.out.println("Comunidades:");
      ArrayList<Community> communities = user.getCommunities();
      if (communities.isEmpty())
         System.out.println("nenhuma.");
      else for (Community community : communities)
         System.out.println("---\n" + community);
   }

   @Override public String toString() {
      return "comunidades";
   }
}