package isoccer.model.staff.player;

public class CentreMid extends Player {
   public CentreMid() {
      super(-1);
   }

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