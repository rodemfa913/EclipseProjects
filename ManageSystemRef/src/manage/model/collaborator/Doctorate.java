package manage.model.collaborator;

public class Doctorate extends Student {
   public Doctorate() {}

   public Doctorate(String name) {
      super(name);
   }

   @Override
   public Doctorate create(String name) {
      return new Doctorate(name);
   }

   @Override
   public String getType() {
      return super.getType() + "doutorado";
   }
}