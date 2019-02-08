package isoccer.builder.staff.player;

import isoccer.model.staff.player.Defender;

public class DefenderBuilder extends AbsPlayerBuilder {
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