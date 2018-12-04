package manage.model;

public class Collaborator {
   public enum Type {
      GRADER, MASTER, DOCTORATE, TEACHER, RESEARCHER;

      @Override public String toString() {
         switch (this) {
         case DOCTORATE:
            return "aluno de doutorado";
         case MASTER:
            return "aluno de mestrado";
         case RESEARCHER:
            return "pesquisador";
         case TEACHER:
            return "professor";
         default:
            return "aluno de graduação";
         }
      }
   }

   public String email, name;
   private int id;
   private Type type;

   public Collaborator(Type type, int id) {
      this.id = id;
      this.type = type;
   }

   public int getId() { return this.id; }

   public Type getType() { return this.type; }
   
   @Override public String toString() { return this.id + ": " + this.name; }
}