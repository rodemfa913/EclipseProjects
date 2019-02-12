package isoccer.action;

import isoccer.builder.staff.player.AbsPlayerBuilder;
import isoccer.ISoccer;
import isoccer.model.staff.player.Player;

public class ManagePlayer implements Action {
   private final Exception notFoundException = new Exception("Não encontrado.");

   @Override
   public void doAction() throws Exception {
      Player player = AbsPlayerBuilder.getPlayer();
      if (player == null)
         throw notFoundException;

      System.out.print("Inapto? (s/n): ");
      player.unable = ISoccer.input.nextLine().toLowerCase().equals("s");
   }

   @Override
   public String toString() {
      return "gerenciar jogador";
   }
}