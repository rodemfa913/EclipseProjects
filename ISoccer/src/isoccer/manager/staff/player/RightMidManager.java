package isoccer.manager.staff.player;

import isoccer.model.staff.player.RightMid;

public class RightMidManager extends AbsPlayerManager {
   @Override
   public RightMid build() throws Exception {
      RightMid rightMid = new RightMid(playerCount++);
      setInfo(rightMid);
      put(rightMid);

      return rightMid;
   }

   @Override
   public String getType() {
      return "lateral direito";
   }
}