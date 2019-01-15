package isoccer.model.staff.player;

public class RightMid extends Player {
   public RightMid() {
      super(-1);
   }

   public RightMid(int id) {
      super(id);
   }

   @Override
   public RightMid create(int id) {
      return new RightMid(id);
   }

   @Override
   public String getType() {
      return "lateral direito";
   }
}