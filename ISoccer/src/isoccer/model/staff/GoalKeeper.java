package isoccer.model.staff;

public class GoalKeeper extends Player {
   public GoalKeeper() {
      super(-1);
   }

   public GoalKeeper(int id) {
      super(id);
   }

   @Override
   public GoalKeeper create(int id) {
      return new GoalKeeper(id);
   }

   @Override
   public String getType() {
      return "goleiro";
   }
}
