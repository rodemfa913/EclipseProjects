package isoccer.model.staff;

public class President extends Member {
   public President() {}

   public President(int id) {
      super(id);
   }

   @Override
   public President create(int id) {
      return new President(id);
   }

   @Override
   public String getType() {
      return "presidente";
   }
}