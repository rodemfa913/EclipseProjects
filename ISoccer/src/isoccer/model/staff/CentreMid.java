package isoccer.model.staff;

public class CentreMid extends Player {
   public CentreMid() {}

   public CentreMid(int id) {
      super(id);
   }

   @Override
   public CentreMid create(int id) {
      return new CentreMid(id);
   }

   @Override
   public String getType() {
      return "meia";
   }
}