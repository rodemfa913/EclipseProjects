package manage.action;

import manage.ManageSystem;
import manage.model.Project;

public class AddProject extends Action {
   @Override
   public void doAction() {
      System.out.print("Título: ");
      String title = ManageSystem.input.nextLine();

      Project project = new Project(title);
      title = project.getTitle();

      ManageSystem.projects.put(title, project);
      System.out.println("Projeto '" + title + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar projeto";
   }
}