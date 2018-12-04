package manage;

import java.util.*;
import manage.model.*;

public class ManageSystem {
   private enum Action {
      ADD_COLLAB, ADD_PROJECT;

      public void doAction() {
         switch (this) {
         case ADD_PROJECT:
            addProject();
            break;
         default:
            addCollaborator();
         }
      }

      @Override public String toString() {
         switch (this) {
         case ADD_PROJECT:
            return "adicionar projeto";
         default:
            return "adicionar colaborador";
         }
      }
   }

   private static int collabCount;
   private static HashMap<Integer, Collaborator> collaborators;
   private static HashMap<String, Project> projects;
   private static Scanner input;

   public static void main(String[] args) {
      input = new Scanner(System.in);
      collaborators = new HashMap<>();
      projects = new HashMap<>();

      ArrayList<Action> actions = new ArrayList<>();
      for (Action action : Action.values()) {
         actions.add(action);
      }

      while (true) {
         System.out.println("---\n0 - sair");
         int a;
         for (a = 1; a <= actions.size(); a++) {
            System.out.println(a + " - " + actions.get(a - 1));
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

   private static void addCollaborator() {
      System.out.print("Nome: ");
      String name = input.nextLine();

      System.out.print("E-mail: ");
      String email = input.nextLine();

      System.out.println("---");
      int t = 0;
      ArrayList<Collaborator.Type> types = new ArrayList<>();
      for (Collaborator.Type type : Collaborator.Type.values()) {
         System.out.println((t++) + " - " + type);
         types.add(type);
      }
      System.out.print("---\nTipo: ");
      t = input.nextInt(); input.nextLine();

      Collaborator collaborator = new Collaborator(types.get(t), collabCount);
      collaborator.email = email;
      collaborator.name = name;
      collaborators.put(collabCount++, collaborator);

      System.out.println("Colaborador '" + collaborator + "' adicionado.");
   }

   private static void addProject() {
      System.out.print("Título: ");
      String title = input.nextLine();

      Project project = new Project(title);

      projects.put(title, project);
   }
}