package isoccer.model.staff;

public class LeftMid extends Player {
   public LeftMid() {}

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