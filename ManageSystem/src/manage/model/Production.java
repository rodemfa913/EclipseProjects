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
   public Project project;
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

   public HashMap<String, Collaborator> getAuthors() { return this.authors; }

   public HashMap<String, Collaborator> getStudents() { return this.students; }

   public Type getType() { return this.type; }

   public int getYear() { return this.year; }

   @Override public int compareTo(Production other) {
      if (this.year != other.year) return other.year - this.year;
      return this.id - other.id;
   }

   @Override public String toString() {
      String p = "Tipo: " + this.type + "\nData (ano): " + this.year;
      if (this.type == Type.PUBLICATION) {
         p += "\nTítulo: " + this.title + "\nAutores:";
         for (String name : this.authors.keySet()) p += "\n  " + name;
      } else {
         p += "\nOrientador: " + this.teacher.getName() + "\nOrientandos:";
         for (String name : this.students.keySet()) p += "\n  " + name;
      }
      return p;
   }
}