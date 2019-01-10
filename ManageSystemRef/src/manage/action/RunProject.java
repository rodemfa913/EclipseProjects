package manage.action;

import manage.model.collaborator.*;
import manage.model.Project;

public class RunProject extends Action {
   @Override
   public void doAction() throws Exception {
      Project project = this.getProject(Project.Status.LOADING);
      if (!project.hasBasicInfo())
         throw new Exception("Informações básicas incompletas");

      for (Collaborator participant : project.getParticipants()) {
         if (participant instanceof Grader && participant.hasRunningProject()) {
            System.out.println("<!> Aluno " + participant.getName() +
                  " já participa de outro projeto.");
            continue;
         }

         participant.setProject(project);
      }

      project.setStatus(Project.Status.RUNNING);
      System.out.println("Projeto '" + project.getTitle() +
            "' " + project.getStatus() + ".");
   }

   @Override
   public String toString() {
      return "iniciar projeto";
   }
}