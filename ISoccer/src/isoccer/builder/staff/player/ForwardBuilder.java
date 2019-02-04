package isoccer.builder.staff.player;

import isoccer.model.staff.player.Forward;

public class ForwardBuilder extends AbsPlayerBuilder {
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