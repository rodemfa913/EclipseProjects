package manage;

import java.util.*;
import manage.action.*;
import manage.model.collaborator.Collaborator;
import manage.model.Project;

public class ManageSystem {
   public static final HashMap<String, Collaborator>
         collaborators = new HashMap<>();
   public static final Scanner input = new Scanner(System.in);
   public static final HashMap<String, Project> projects = new HashMap<>();

   public static void main(String[] args) {
      Action[] actions = new Action[] {
         new AddCollaborator(), new AddProject(), new EditProject(),
         new Allocate(), new RunProject(), new AddPublication(),
         new AddOrientation(), new FinishProject(),
         new ViewCollaborator(), new ViewProject(), new GenerateReport()
      };

      while (true) {
         System.out.println("---\n 0 - sair");
         int a;
         for (a = 1; a <= actions.length; a++)
            System.out.printf("%2d - %s\n", a, actions[a - 1]);
         System.out.print("---\nAção: ");

         try {
            a = Integer.parseInt(input.nextLine());
            if (a == 0) {
               System.out.println("Fim.");
               break;
            }
            actions[a - 1].doAction();
         } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            System.out.println("<!> Entrada inválida.");
         } catch (Exception ex) {
            System.out.println("<!> " + ex.getMessage() + ".");
         }
      }
   }
}