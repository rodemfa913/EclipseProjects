package manage.model;

import java.util.HashMap;

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

   public String email;
   private String name;
   private HashMap<String, Project> loadingProjects, projects;
   private Type type;

   public Collaborator(Type type, String name) {
      super();

      this.loadingProjects = new HashMap<>();

      if (name == null) this.name = "";
      else this.name = name;

      this.projects = new HashMap<>();

      if (type == null) this.type = Type.GRADER;
      else this.type = type;
   }

   public String getName() { return this.name; }

   public HashMap<String, Project> getLoadingProjects() {
      return this.loadingProjects;
   }

   public HashMap<String, Project> getProjects() { return this.projects; }

   public Type getType() { return this.type; }
}