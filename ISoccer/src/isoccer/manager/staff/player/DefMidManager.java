package isoccer.manager.staff.player;

import isoccer.model.staff.player.DefMid;

public class DefMidManager extends AbsPlayerManager {
   @Override
   public DefMid build() throws Exception {
      DefMid defMid = new DefMid(playerCount++);
      setInfo(defMid);
      put(defMid);

      return defMid;
   }

   @Override
   public String getType() {
      return "volante";
   }
}