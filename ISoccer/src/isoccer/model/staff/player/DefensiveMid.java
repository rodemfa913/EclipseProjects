package isoccer.model.staff.player;

public class DefensiveMid extends Player {
   public DefensiveMid() {
      super(-1);
   }

   public DefensiveMid(int id) {
      super(id);
   }

   @Override
   public DefensiveMid create(int id) {
      return new DefensiveMid(id);
   }

   @Override
   public String getType() {
      return "volante";
   }
}