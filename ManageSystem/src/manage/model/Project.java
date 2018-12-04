package manage.model;

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

   public int endYear, startYear;
   private String title;
   private Status status;

   public Project(String title) {
      this.setStatus(null);
      this.title = title;
   }

   public Status getStatus() { return this.status; }

   public void setStatus(Status status) {
      if (status == null) this.status = Status.LOADING;
      else this.status = status;
   }

   public String getTitle() { return this.title; }
}