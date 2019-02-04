package isoccer.builder.staff.player;

import isoccer.model.staff.player.GoalKeeper;

public class GoalKeeperBuilder extends AbsPlayerBuilder {
   @Override
   public GoalKeeper build() {
      return new GoalKeeper(playerCount++);
   }

   @Override
   public String getType() {
      return "goleiro";
   }
}