package isoccer.model.staff;

public class Coach extends Member {
   public Coach() {}

   public Coach(int id) {
      super(id);
   }

   @Override
   public Coach create(int id) {
      return new Coach(id);
   }

   @Override
   public String getType() {
      return "técnico";
   }
}