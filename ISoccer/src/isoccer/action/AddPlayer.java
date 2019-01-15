package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.staff.player.*;

public class AddPlayer extends Action {
   @Override
   public void doAction() throws Exception {
      Player[] creators = new Player[] {
         new GoalKeeper(), new Defender(), new DefensiveMid(),
         new CentreMid(), new LeftMid(), new RightMid(), new Forward()
      };

      System.out.println("---");
      int p;
      for (p = 0; p < creators.length; p++)
         System.out.println(p + " - " + creators[p].getType());
      System.out.print("---\nPosição: ");
      p = Integer.parseInt(ISoccer.input.nextLine());

      Player player = (Player) creators[p].create(ISoccer.players.size());

      setMemberInfo(player);
      String unable = player.unable ? "s" : "n";
      System.out.print("Inapto? (s/n)\n  atual: " + unable + "\n   novo: ");
      unable = ISoccer.input.nextLine().toLowerCase();
      player.unable = unable.equals("s");

      ISoccer.players.add(player);

      System.out.println("Jogador '" + player.id +
            ": " + player.getName() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar jogador";
   }
}