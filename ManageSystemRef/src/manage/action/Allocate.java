package manage.action;

import java.util.ArrayList;
import manage.model.collaborator.Collaborator;
import manage.model.Project;

public class Allocate extends Action {
   @Override
   public void doAction() throws Exception {
      Project project = this.getProject(Project.Status.LOADING);
      ArrayList<Collaborator> participants =
            this.getCollaborators("Nome dos participantes");

      for (Collaborator participant : participants) {
         project.setParticipant(participant);
         System.out.println("Participante " + participant.getName() +
               " alocado ao projeto '" + project.getTitle() + "'.");
      }
   }

   @Override
   public String toString() {
      return "alocar participantes";
   }
}