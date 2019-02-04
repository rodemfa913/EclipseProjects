package isoccer.builder.staff.player;

import isoccer.model.staff.player.LeftMid;

public class LeftMidBuilder extends AbsPlayerBuilder {
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