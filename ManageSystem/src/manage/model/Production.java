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

   public Collaborator teacher;
   public String conference, title;
   private HashMap<String, Collaborator> students, authors;
   private Type type;
   private int year;

   public Production(Type type, int year) {
      if (type == Type.ORIENTATION) {
         this.students = new HashMap<>();
      } else {
         this.authors = new HashMap<>();
      }

      this.type = type;
      this.year = year;
   }

   public HashMap<String, Collaborator> getStudents() {
      return this.students;
   }

   public HashMap<String, Collaborator> getAuthors() { return this.authors; }

   public Type getType() { return this.type; }

   public int getYear() { return this.year; }

   @Override public int compareTo(Production other) {
      if (this.year != other.year) return other.year - this.year;
      return this.title.compareTo(other.title);
   }
}