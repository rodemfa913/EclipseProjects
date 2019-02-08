package isoccer.manager.staff.player;

import isoccer.model.staff.player.Forward;

public class ForwardManager extends AbsPlayerManager {
   @Override
   public Forward build() throws Exception {
      Forward forward = new Forward(playerCount++);
      setInfo(forward);
      put(forward);

      return forward;
   }

   @Override
   public String getType() {
      return "atacante";
   }
}