package isoccer.model.staff.player;

public class Defender extends Player {
   public Defender() {
      super(-1);
   }

   public Defender(int id) {
      super(id);
   }

   @Override
   public Defender create(int id) {
      return new Defender(id);
   }

   @Override
   public String getType() {
      return "zagueiro";
   }
}