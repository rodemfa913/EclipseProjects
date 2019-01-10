package manage.model.collaborator;

public class Grader extends Student {
   public Grader() {}

   public Grader(String name) {
      super(name);
   }

   @Override
   public Grader create(String name) {
      return new Grader(name);
   }

   @Override
   public String getType() {
      return super.getType() + "graduação";
   }
}