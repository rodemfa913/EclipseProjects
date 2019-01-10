package isoccer.model.staff;

public class Defender extends Player {
   public Defender() {}

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