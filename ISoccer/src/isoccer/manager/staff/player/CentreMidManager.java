package isoccer.manager.staff.player;

import isoccer.model.staff.player.CentreMid;

public class CentreMidManager extends AbsPlayerManager {
   @Override
   public CentreMid build() throws Exception {
      CentreMid centreMid = new CentreMid(playerCount++);
      setInfo(centreMid);
      put(centreMid);

      return centreMid;
   }

   @Override
   public String getType() {
      // TODO Auto-generated method stub
      return null;
   }
}