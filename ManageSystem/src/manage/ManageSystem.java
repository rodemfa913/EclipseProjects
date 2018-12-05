package manage;

import java.util.*;
import manage.model.*;

public class ManageSystem {
   private enum Action {
      ADD_COLLAB, ADD_PROJECT, EDIT_PROJECT, ALLOCATE;

      public void doAction() {
         switch (this) {
         case ADD_PROJECT:
            addProject();
            break;
         case ALLOCATE:
            allocate();
            break;
         case EDIT_PROJECT:
            editProject();
            break;
         default:
            addCollaborator();
         }
      }

      @Override public String toString() {
         switch (this) {
         case ADD_PROJECT:
            return "adicionar projeto";
         case ALLOCATE:
            return "alocar participante";
         case EDIT_PROJECT:
            return "editar projeto";
         default:
            return "adicionar colaborador";
         }
      }
   }

   private static HashMap<String, Collaborator> collaborators;
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
      if (t < 0 || t >= types.size()) t = 0;

      Collaborator collaborator = new Collaborator(types.get(t), name);
      collaborator.email = email;
      collaborators.put(name, collaborator);

      System.out.println(
            "Colaborador " + name + " adicionado."
      );
   }

   private static void addProject() {
      System.out.print("Título: ");
      String title = input.nextLine();

      Project project = new Project(title);
      projects.put(title, project);

      System.out.println("Projeto '" + title + "' adicionado.");
   }

   private static void allocate() {
      Project project = getProject(Project.Status.LOADING);
      if (project == null) return;

      System.out.print("Nome do participante: ");
      String name = input.nextLine();
      Collaborator participant = collaborators.get(name);
      if (participant == null) {
         System.out.println("<Erro> Não encontrado.");
         return;
      }

      if (participant.getType() == Collaborator.Type.TEACHER) {
         project.getTeachers().put(name, participant);
      } else project.getParticipants().put(name, participant);

      participant.getLoadingProjects().put(project.getTitle(), project);

      System.out.println(
            "Participante " + name + " alocado ao projeto '" +
            project.getTitle() + "'."
      );
   }

   private static void editProject() {
      Project project = getProject(Project.Status.LOADING);
      if (project == null) return;

      System.out.print("Data de início (Ano): ");
      project.startYear = input.nextInt(); input.nextLine();

      System.out.print("Data de término (Ano): ");
      project.endYear = input.nextInt(); input.nextLine();

      System.out.print("Agência financiadora: ");
      project.agency = input.nextLine();

      System.out.print("Financiamento: ");
      project.funding = input.nextDouble(); input.nextLine();

      System.out.print("Objetivo: ");
      project.goal = input.nextLine();

      System.out.print("Descrição: ");
      project.description = input.nextLine();

      System.out.println("Projeto '" + project.getTitle() + "' editado.");
   }

   private static Project getProject(Project.Status status) {
      System.out.print("Título do projeto: ");
      Project project = projects.get(input.nextLine());
      if (project == null) {
         System.out.println("<Erro> Não encontrado.");
         return null;
      }

      Project.Status projectStatus = project.getStatus();
      if (projectStatus != status) {
         System.out.println("<Erro> Projeto " + projectStatus + ".");
         return null;
      }

      return project;
   }
}