package manage.model;

public class Collaborator {
   public enum Type {
      GRADER, MASTER, DOCTORATE, TEACHER, RESEARCHER
   }

   public String email, name;
   private Type type;

   public Collaborator(Type type) {
      this.type = type;
   }

   public Type getType() { return this.type; }
}