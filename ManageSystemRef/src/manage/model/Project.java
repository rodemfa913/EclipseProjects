package manage.model;

import java.util.*;
import manage.model.collaborator.*;
import manage.model.production.Publication;

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
   private HashMap<Integer, Publication> publications;
   private String title;
   private Status status;

   public Project(String title) {
      this.participants = new HashMap<>();
      this.publications = new HashMap<>();
      this.setStatus(null);

      if (title == null || title.isEmpty())
         title = "-";
      this.title = title;
   }

   @Override
   public int compareTo(Project other) {
      if (this.endYear != other.endYear)
         return other.endYear - this.endYear;
      if (this.startYear != other.startYear)
         return other.startYear - this.startYear;
      return this.title.compareTo(other.title);
   }

   public ArrayList<Collaborator> getParticipants() {
      return new ArrayList<>(this.participants.values());
   }

   public ArrayList<Publication> getPublications() {
      return new ArrayList<>(this.publications.values());
   }

   public Status getStatus() {
      return this.status;
   }

   public String getTitle() {
      return this.title;
   }

   public boolean hasBasicInfo() {
      return this.agency != null && !this.agency.isEmpty() &&
             this.description != null && !this.description.isEmpty() &&
             this.goal != null && !this.goal.isEmpty() &&
             this.startYear > 0 && this.endYear >= this.startYear &&
             this.funding > 0.0 && this.hasTeacher();
   }

   public boolean hasTeacher() {
      for (Collaborator participant : this.participants.values()) {
         if (participant instanceof Teacher)
            return true;
      }
      return false;
   }

   public Collaborator setParticipant(Collaborator participant) {
      return this.participants.put(participant.getName(), participant);
   }

   public Publication setPublication(Publication publication) {
      return this.publications.put(publication.getYear(), publication);
   }

   public void setStatus(Status status) {
      if (status == null)
         status = Status.LOADING;
      this.status = status;
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
      for (String name : this.participants.keySet())
         p += "\n  " + name;

      ArrayList<Publication> orderedPublications = this.getPublications();
      orderedPublications.sort(null);
      p += "\nPublicações:";
      for (Publication publication : orderedPublications)
         p += "\n---\n" + publication;

      return p;
   }
}