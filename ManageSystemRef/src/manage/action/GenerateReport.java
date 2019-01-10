package manage.action;

import manage.ManageSystem;
import manage.model.Project;

public class GenerateReport extends Action {
   @Override
   public void doAction() {
      System.out.println("Número de colaboradores: " +
            ManageSystem.collaborators.size());

      int nLoadingProject = 0, nRunningProject = 0, nDoneProject = 0;
      for (Project project : ManageSystem.projects.values()) {
         switch (project.getStatus()) {
         case RUNNING:
            nRunningProject++;
            break;
         case DONE:
            nDoneProject++;
            break;
         default:
            nLoadingProject++;
         }
      }

      System.out.println("Numero de projetos:");
      System.out.println("  em elaboração: " + nLoadingProject);
      System.out.println("  em andamento: " + nRunningProject);
      System.out.println("  concluídos: " + nDoneProject);
      System.out.println("  total: " + ManageSystem.projects.size());

      System.out.println("Número de produções acadêmicas:");
      System.out.println("  orientações: " + nOrientation);
      System.out.println("  publicações: " + nPublication);
   }

   @Override
   public String toString() {
      return "gerar relatório";
   }
}