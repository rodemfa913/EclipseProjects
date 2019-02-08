package isoccer.builder.staff.player;

import isoccer.model.staff.player.GoalKeeper;

public class GoalKeeperBuilder extends AbsPlayerBuilder {
   @Override
   public GoalKeeper build() throws Exception {
      GoalKeeper goalKeeper = new GoalKeeper(playerCount++);
      setInfo(goalKeeper);
      put(goalKeeper);

      return goalKeeper;
   }

   @Override
   public String getType() {
      return "goleiro";
   }
}