package isoccer.builder.staff.player;

import isoccer.builder.staff.MemberBuilder;
import isoccer.ISoccer;
import isoccer.model.staff.player.Player;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbsPlayerBuilder extends MemberBuilder {
   protected static int playerCount;
   private static final HashMap<Integer, Player> players = new HashMap<>();

   public static Player getPlayer() throws Exception {
      System.out.println("Id: ");
      int id = Integer.parseInt(ISoccer.input.nextLine());

      return players.get(id);
   }

   public static ArrayList<Player> getPlayers() {
      return new ArrayList<>(players.values());
   }

   protected Player put(Player player) {
      return players.put(player.id, player);
   }
}