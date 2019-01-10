package isoccer.model.staff;

public class DefensiveMid extends Player {
   public DefensiveMid() {}

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