package manage.model;

import java.util.*;

public class Project implements Comparable<Project> {
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
   private HashMap<Integer, Production> publications;
   private String title;
   private Status status;

   public Project(String title) {
      super();

      this.participants = new HashMap<>();
      this.publications = new HashMap<>();
      this.setStatus(null);

      if (title == null || title.isEmpty()) this.title = "-";
      else this.title = title;
   }

   public HashMap<String, Collaborator> getParticipants() {
      return this.participants;
   }

   public HashMap<Integer, Production> getPublications() {
      return this.publications;
   }

   public Status getStatus() { return this.status; }

   public void setStatus(Status status) {
      if (status == null) this.status = Status.LOADING;
      else this.status = status;
   }

   public String getTitle() { return this.title; }

   public boolean hasBasicInfo() {
      return this.agency != null && !this.agency.isEmpty() &&
             this.description != null && !this.description.isEmpty() &&
             this.goal != null && !this.goal.isEmpty() &&
             this.startYear > 0 && this.endYear >= this.startYear &&
             this.funding > 0.0 && this.hasTeacher();
   }

   public boolean hasTeacher() {
      for (String name : this.participants.keySet()) {
         Collaborator participant = this.participants.get(name);
         if (participant.getType() == Collaborator.Type.TEACHER) return true;
      }
      return false;
   }

   @Override public int compareTo(Project other) {
      if (this.endYear != other.endYear) return other.endYear - this.endYear;
      if (this.startYear != other.startYear)
         return other.startYear - this.startYear;
      return this.title.compareTo(other.title);
   }

   @Override public String toString() {
      String p =
            "Título: " + this.title +
            "\nStatus: " + this.status +
            "\nData de início (ano): " + this.startYear +
            "\nData de término (ano): " + this.endYear +
            "\nAgência financiadora: " + this.agency +
            "\nFinanciamento: " + this.funding +
            "\nObjetivo:\n  " + this.goal +
            "\nDescrição:\n  " + this.description;

      p += "\nParticipantes:";
      for (String name : this.participants.keySet()) p += "\n  " + name;

      ArrayList<Production> orderedPublications =
            new ArrayList<>(this.publications.values());
      orderedPublications.sort(null);
      p += "\nPublicações:\n---";
      for (Production publication : orderedPublications)
         p += "\n" + publication + "\n---";
      return p;
   }
}