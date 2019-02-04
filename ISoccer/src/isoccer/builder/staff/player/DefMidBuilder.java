package isoccer.builder.staff.player;

import isoccer.model.staff.player.DefMid;

public class DefMidBuilder extends AbsPlayerBuilder {
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