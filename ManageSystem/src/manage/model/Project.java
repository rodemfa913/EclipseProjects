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
   private HashMap<String, Collaborator> participants;
   private String title;
   private Status status;

   public Project(String title) {
      super();

      this.participants = new HashMap<>();
      this.setStatus(null);

      if (title == null || title.isEmpty()) this.title = "-";
      else this.title = title;
   }

   public HashMap<String, Collaborator> getParticipants() {
      return this.participants;
   }

   public Status getStatus() { return this.status; }

   public void setStatus(Status status) {
      if (status == null) this.status = Status.LOADING;
      else this.status = status;
   }

   public String getTitle() { return this.title; }

   public boolean hasTeacher() {
      for (String name : this.participants.keySet()) {
         Collaborator participant = this.participants.get(name);
         if (participant.getType() == Collaborator.Type.TEACHER) return true;
      }
      return false;
   }

   public boolean hasBasicInfo() {
      return this.agency != null && !this.agency.isEmpty() &&
             this.description != null && !this.description.isEmpty() &&
             this.goal != null && !this.goal.isEmpty() &&
             this.startYear > 0 && this.endYear >= this.startYear &&
             this.funding > 0.0 && this.hasTeacher();
   }
}