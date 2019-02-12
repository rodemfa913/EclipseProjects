package isoccer.builder.staff.player;

import isoccer.model.staff.player.CentreMid;

public class CentreMidBuilder extends AbsPlayerBuilder {
   @Override
   public CentreMid build() throws Exception {
      CentreMid centreMid = new CentreMid(playerCount++);
      setInfo(centreMid);
      put(centreMid);

      return centreMid;
   }

   @Override
   public String getType() {
      return "meia";
   }
}