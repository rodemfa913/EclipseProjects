package manage.action;

import manage.ManageSystem;
import manage.model.Project;

public class EditProject extends Action {
   @Override
   public void doAction() throws Exception {
      Project project = this.getProject(Project.Status.LOADING);

      System.out.print("Data de início (Ano): ");
      project.startYear = Integer.parseInt(ManageSystem.input.nextLine());

      System.out.print("Data de término (Ano): ");
      project.endYear = Integer.parseInt(ManageSystem.input.nextLine());

      System.out.print("Agência financiadora: ");
      project.agency = ManageSystem.input.nextLine();

      System.out.print("Financiamento: ");
      project.funding = Double.parseDouble(ManageSystem.input.nextLine());

      System.out.print("Objetivo: ");
      project.goal = ManageSystem.input.nextLine();

      System.out.print("Descrição: ");
      project.description = ManageSystem.input.nextLine();

      System.out.println("Projeto '" + project.getTitle() + "' editado.");
   }

   @Override
   public String toString() {
      return "editar projeto";
   }
}