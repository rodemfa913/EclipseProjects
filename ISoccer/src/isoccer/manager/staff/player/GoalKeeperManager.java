package isoccer.manager.staff.player;

import isoccer.model.staff.player.GoalKeeper;

public class GoalKeeperManager extends AbsPlayerManager {
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