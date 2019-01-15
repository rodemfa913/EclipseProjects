package isoccer.model.staff.player;

public class LeftMid extends Player {
   public LeftMid() {
      super(-1);
   }

   public LeftMid(int id) {
      super(id);
   }

   @Override
   public LeftMid create(int id) {
      return new LeftMid(id);
   }

   @Override
   public String getType() {
      return "lateral esquerdo";
   }
}