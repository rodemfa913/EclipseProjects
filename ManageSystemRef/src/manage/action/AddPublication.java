package manage.action;

import java.util.ArrayList;
import manage.ManageSystem;
import manage.model.collaborator.Collaborator;
import manage.model.production.Publication;
import manage.model.Project;

public class AddPublication extends Action {
   @Override
   public void doAction() throws Exception {
      System.out.print("Data (ano): ");
      int year = Integer.parseInt(ManageSystem.input.nextLine());

      Publication publication = new Publication(year);

      System.out.print("Título da publicação: ");
      publication.title = ManageSystem.input.nextLine();

      System.out.print("Conferência: ");
      publication.conference = ManageSystem.input.nextLine();

      ArrayList<Collaborator> authors;

      System.out.print("Associar a projeto? (s/n): ");
      if (ManageSystem.input.nextLine().equals("s")) {
         Project project = this.getProject(Project.Status.RUNNING);
         publication.project = project;
         project.setPublication(publication);

         authors = project.getParticipants();
      } else
         authors = this.getCollaborators("Nome dos autores");

      for (Collaborator author : authors) {
         publication.setAuthor(author);
         author.setPublication(publication);
      }

      nPublication++;
      System.out.println("Publicação '" + publication.title + "' adicionada.");
   }

   @Override
   public String toString() {
      return "adicionar publicação";
   }
}