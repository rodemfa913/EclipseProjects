package manage.action;

import manage.model.Project;

public class FinishProject extends Action {
   @Override
   public void doAction() throws Exception {
      Project project = this.getProject(Project.Status.RUNNING);
      if (project.getPublications().isEmpty())
         throw new Exception("Não há publicações associadas ao projeto");

      project.setStatus(Project.Status.DONE);
      System.out.println("Projeto '" + project.getTitle() +
            "' " + project.getStatus() + ".");
   }

   @Override
   public String toString() {
      return "finalizar projeto";
   }
}