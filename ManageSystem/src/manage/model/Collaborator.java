package manage.model;

import java.util.*;

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
   private HashMap<Integer, Production> productions;
   private HashMap<String, Project> projects;
   private Type type;

   public Collaborator(Type type, String name) {
      super();

      if (name == null || name.isEmpty()) this.name = "-";
      else this.name = name;

      this.productions = new HashMap<>();
      this.projects = new HashMap<>();

      if (type == null) this.type = Type.GRADER;
      else this.type = type;
   }

   public String getName() { return this.name; }

   public HashMap<Integer, Production> getProductions() {
      return this.productions;
   }

   public HashMap<String, Project> getProjects() {
      return this.projects;
   }

   public Type getType() { return this.type; }

   public boolean hasRunningProject() {
      for (String title : this.projects.keySet()) {
         Project project = this.projects.get(title);
         if (project.getStatus() == Project.Status.RUNNING) return true;
      }
      return false;
   }

   @Override public String toString() {
      String c = "Nome: " + this.name + "\nTipo: " +
            this.type + "\nE-mail: " + this.email;

      ArrayList<Project> orderedProjects = new ArrayList<>();
      for (String title : this.projects.keySet())
         orderedProjects.add(this.projects.get(title));
      orderedProjects.sort(null);

      c += "\nProjetos:\n---";
      for (Project project : orderedProjects)
         c += "\nData de término (ano): " + project.endYear +
               "\nTítulo: " + project.getTitle() + "\n---";

      ArrayList<Production> orderedProductions = new ArrayList<>();
      for (int year : this.productions.keySet())
         orderedProductions.add(this.productions.get(year));
      orderedProductions.sort(null);
      
      c += "\nProduções:\n---";
      for (Production production : orderedProductions) {
         Production.Type type = production.getType();
         c += "\nTipo: " + type + "\nData (ano): " + production.getYear();
         if (type == Production.Type.PUBLICATION)
            c += "\nTítulo: " + production.title;
         c += "\n---";
      }

      return c;
   }
}