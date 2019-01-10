package isoccer.model.staff;

public class Cook extends Member {
   public Cook() {}

   public Cook(int id) {
      super(id);
   }

   @Override
   public Cook create(int id) {
      return new Cook(id);
   }

   @Override
   public String getType() {
      return "cozinheiro";
   }
}