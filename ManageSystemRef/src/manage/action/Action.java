package manage.action;

import java.util.ArrayList;
import manage.ManageSystem;
import manage.model.collaborator.Collaborator;
import manage.model.Project;

public abstract class Action {
   protected static int nOrientation, nPublication;

   public abstract void doAction() throws Exception;

   protected Collaborator getCollaborator(String prompt) throws Exception {
      System.out.print(prompt + ": ");
      Collaborator collaborator = ManageSystem.collaborators.
            get(ManageSystem.input.nextLine());
      if (collaborator == null)
         throw new Exception("Não encontrado");

      return collaborator;
   }

   protected ArrayList<Collaborator> getCollaborators(
         String prompt) throws Exception {
      ArrayList<Collaborator> collaborators = new ArrayList<>();

      System.out.println(prompt + " ('-' para encerrar): ");
      while (true) {
         String name = ManageSystem.input.nextLine();
         if (name.isEmpty() || name.equals("-"))
            break;

         Collaborator collaborator = ManageSystem.collaborators.get(name);
         if (collaborator == null) {
            System.out.println("<!> Não encontrado.");
            continue;
         }

         collaborators.add(collaborator);
      }

      if (collaborators.isEmpty())
         throw new Exception("Lista vazia");

      return collaborators;
   }

   protected Project getProject(Project.Status status) throws Exception {
      System.out.print("Título do projeto: ");
      Project project = ManageSystem.projects.
            get(ManageSystem.input.nextLine());
      if (project == null)
         throw new Exception("Não encontrado");

      Project.Status projectStatus = project.getStatus();
      if (status != null && projectStatus != status)
         throw new Exception("Projeto " + projectStatus);

      return project;
   }
}