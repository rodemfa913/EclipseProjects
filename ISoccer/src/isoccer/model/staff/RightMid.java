package isoccer.model.staff;

public class RightMid extends Player {
   public RightMid() {}

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