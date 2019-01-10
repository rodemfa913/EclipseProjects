package manage.model.collaborator;

import java.util.*;
import manage.model.production.*;
import manage.model.Project;

public abstract class Collaborator {
   public String email;
   private String name;
   private HashMap<String, Project> projects;
   private HashMap<Integer, Publication> publications;

   public Collaborator() {
      this(null);
   }

   public Collaborator(String name) {
      if (name == null || name.isEmpty())
         name = "-";
      this.name = name;
   }

   public abstract Collaborator create(String name);

   public String getName() {
      return this.name;
   }

   public abstract String getType();

   public ArrayList<Production> getProductions() {
      return new ArrayList<>(this.publications.values());
   }

   public ArrayList<Project> getProjects() {
      return new ArrayList<>(this.projects.values());
   }

   public boolean hasRunningProject() {
      for (Project project : this.projects.values())
         if (project.getStatus() == Project.Status.RUNNING)
            return true;
      return false;
   }

   public Project setProject(Project project) {
      return this.projects.put(project.getTitle(), project);
   }

   public Production setPublication(Publication publication) {
      return this.publications.put(publication.getYear(), publication);
   }

   @Override
   public String toString() {
      String c = "Tipo: " + this.getType() + "\nNome: " +
            this.name + "\nE-mail: " + this.email;

      ArrayList<Project> orderedProjects = this.getProjects();
      orderedProjects.sort(null);
      c += "\n---\nProjetos:";
      for (Project project : orderedProjects)
         c += "\n---\nData de término (ano): " + project.endYear +
               "\nTítulo: " + project.getTitle();

      ArrayList<Production> orderedProductions = this.getProductions();
      orderedProductions.sort(null);
      c += "\n---\nProduções:";
      for (Production production : orderedProductions)
         c += "\n---\n" + production;

      return c;
   }
}