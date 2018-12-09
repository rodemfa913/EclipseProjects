package manage.model;

import java.util.HashMap;

public class Production implements Comparable<Production> {
   public enum Type {
      PUBLICATION, ORIENTATION;

      @Override public String toString() {
         if (this == ORIENTATION) return "orientação";
         return "publicação";
      }
   }

   private HashMap<String, Collaborator> authors, students;
   public String conference, title;
   private static int count;
   private int id;
   private Project project;
   public Collaborator teacher;
   private Type type;
   private int year;

   public Production(Type type, int year) {
      if (type == Type.ORIENTATION) {
         this.students = new HashMap<>();
      } else {
         this.authors = new HashMap<>();
      }

      this.id = count++;
      this.type = type;
      this.year = year;
   }

   public HashMap<String, Collaborator> getAuthors() {
      return new HashMap<>(this.authors);
   }

   public void setAuthor(Collaborator author) {
      if (author == null) return;

      if (this.project != null) {
         this.project = null;
         this.authors.clear();
      }

      this.authors.put(author.getName(), author);
   }

   public Project getProject() { return this.project; }

   public void setProject(Project project) {
      if (project == null) return;

      this.project = project;
      this.authors.clear();

      HashMap<String, Collaborator> authors = project.getParticipants();
      for (String name : authors.keySet()) {
         Collaborator author = authors.get(name);
         this.authors.put(name, author);
      }
   }

   public HashMap<String, Collaborator> getStudents() {
      return this.students;
   }

   public Type getType() { return this.type; }

   public int getYear() { return this.year; }

   @Override public int compareTo(Production other) {
      if (this.year != other.year) return this.year - other.year;
      return this.id - other.id;
   }
}