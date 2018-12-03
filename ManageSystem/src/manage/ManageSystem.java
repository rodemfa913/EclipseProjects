package manage;

import java.util.*;
//import manage.model.Project;

public class ManageSystem {
   private enum Action {
      ADD_PROJECT, EDIT_PROJECT;

      public void doAction() {
         switch (this) {
         case EDIT_PROJECT:
            System.out.println("Em desenvolvimento...");
            break;
         default:
            addProject();
         }
      }

      @Override public String toString() {
         switch (this) {
         case EDIT_PROJECT:
            return "editar projeto";
         default:
            return "adicionar projeto";
         }
      }
   }

   private static Scanner input;
   //private static HashMap<String, Project> projects;

   public static void main(String[] args) {
      input = new Scanner(System.in);
      //projects = new HashMap<>();

      ArrayList<Action> actions = new ArrayList<>();
      for (Action action : Action.values()) {
         actions.add(action);
      }

      while (true) {
         System.out.println("---\n0: sair");
         int a;
         for (a = 1; a <= actions.size(); a++) {
            System.out.println(a + ": " + actions.get(a - 1));
         }
         System.out.print("---\nAção: ");
         a = input.nextInt(); input.nextLine();

         if (a == 0) {
            System.out.println("Fim.");
            break;
         }
         if (a >= 1 && a <= actions.size()) actions.get(a - 1).doAction();
         else System.out.println("<Erro> Entrada inválida.");
      }
   }

   private static void addProject() {
      System.out.println("Em desenvolvimento...");
   }
}