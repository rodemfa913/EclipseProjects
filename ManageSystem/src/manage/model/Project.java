package manage.model;

import java.util.HashMap;

public class Project {
   public enum Status {
      LOADING, RUNNING, DONE;
      
      @Override public String toString() {
         switch (this) {
         case DONE:
            return "concluído";
         case RUNNING:
            return "em andamento";
         default:
            return "em elaboração";
         }
      }
   }

   public String agency, description, goal;
   public int endYear, startYear;
   public double funding;
   private HashMap<String, Collaborator> participants, teachers;
   private String title;
   private Status status;

   public Project(String title) {
      super();

      this.participants = new HashMap<>();
      this.setStatus(null);
      this.teachers = new HashMap<>();
      this.title = title;
   }

   public HashMap<String, Collaborator> getParticipants() {
      return this.participants;
   }

   public Status getStatus() { return this.status; }

   public void setStatus(Status status) {
      if (status == null) this.status = Status.LOADING;
      else this.status = status;
   }

   public HashMap<String, Collaborator> getTeachers() { return this.teachers; }

   public String getTitle() { return this.title; }
}