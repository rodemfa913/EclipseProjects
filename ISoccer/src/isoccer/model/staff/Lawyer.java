package isoccer.model.staff;

public class Lawyer extends Member {
   public Lawyer() {
      super(-1);
   }

   public Lawyer(int id) {
      super(id);
   }

   @Override
   public Lawyer create(int id) {
      return new Lawyer(id);
   }

   @Override
   public String getType() {
      return "advogado";
   }
}