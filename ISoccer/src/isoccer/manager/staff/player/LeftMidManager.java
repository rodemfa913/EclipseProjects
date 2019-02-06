package isoccer.manager.staff.player;

import isoccer.model.staff.player.LeftMid;

public class LeftMidManager extends AbsPlayerManager {
   @Override
   public LeftMid build() throws Exception {
      LeftMid leftMid = new LeftMid(playerCount++);
      setInfo(leftMid);
      put(leftMid);

      return leftMid;
   }

   @Override
   public String getType() {
      return "lateral esquerdo";
   }
}