package isoccer.manager.staff.player;

import isoccer.model.staff.player.Defender;

public class DefenderManager extends AbsPlayerManager {
   @Override
   public Defender build() throws Exception {
      Defender defender = new Defender(playerCount++);
      setInfo(defender);
      put(defender);

      return defender;
   }

   @Override
   public String getType() {
      return "zagueiro";
   }
}