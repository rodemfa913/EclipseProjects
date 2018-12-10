package manage;

import java.util.*;
import manage.model.*;

public class ManageSystem {
   private enum Action {
      ADD_COLLABORATOR, ADD_PROJECT, EDIT, ALLOCATE, RUN, ADD_PUBLICATION,
      ADD_ORIENTATION, FINISH, VIEW_COLLABORATOR, VIEW_PROJECT;

      public void doAction() {
         switch (this) {
         case ADD_ORIENTATION:
            addOrientation();
            break;
         case ADD_PUBLICATION:
            addPublication();
            break;
         case ADD_PROJECT:
            addProject();
            break;
         case ALLOCATE:
            allocate();
            break;
         case EDIT:
            editProject();
            break;
         case FINISH:
            finishProject();
            break;
         case RUN:
            runProject();
            break;
         case VIEW_COLLABORATOR:
            viewCollaborator();
            break;
         case VIEW_PROJECT:
            viewProject();
            break;
         default:
            addCollaborator();
         }
      }

      @Override public String toString() {
         switch (this) {
         case ADD_ORIENTATION:
            return "adicionar orientação";
         case ADD_PUBLICATION:
            return "adicionar publicação";
         case ADD_PROJECT:
            return "adicionar projeto";
         case ALLOCATE:
            return "alocar participantes";
         case EDIT:
            return "editar projeto";
         case FINISH:
            return "finalizar projeto";
         case RUN:
            return "iniciar projeto";
         case VIEW_COLLABORATOR:
            return "consultar colaborador";
         case VIEW_PROJECT:
            return "consultar projeto";
         default:
            return "adicionar colaborador";
         }
      }
   }

   private static HashMap<String, Collaborator> collaborators;
   //private static int orientationCount, publicationCount;
   private static HashMap<String, Project> projects;
   private static Scanner input;

   public static void main(String[] args) {
      input = new Scanner(System.in);
      collaborators = new HashMap<>();
      projects = new HashMap<>();

      ArrayList<Action> actions = new ArrayList<>();
      for (Action action : Action.values()) actions.add(action);

      while (true) {
         System.out.println("---\n 0 - sair");
         int a;
         for (a = 1; a <= actions.size(); a++)
            System.out.printf("%2d - %s\n", a, actions.get(a - 1));
         System.out.print("---\nAção: ");
         a = input.nextInt(); input.nextLine();

         if (a <= 0 || a > actions.size()) {
            System.out.println("Fim.");
            break;
         }
         actions.get(a - 1).doAction();
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
      name = collaborator.getName();
      collaborators.put(name, collaborator);

      System.out.println("Colaborador " + name + " adicionado.");
   }

   private static void addOrientation() {
      System.out.print("Data (ano): ");
      int year = input.nextInt(); input.nextLine();

      Production orientation = new Production(
            Production.Type.ORIENTATION, year);

      Collaborator teacher = getCollaborator("Nome do professor");
      if (teacher == null) return;

      String teacherName = teacher.getName();
      if (teacher.getType() != Collaborator.Type.TEACHER) {
         System.out.println("<Erro> " + teacherName + " não é professor.");
         return;
      }

      ArrayList<Collaborator> studentList =
            getCollaborators("Nome dos alunos");
      if (studentList.isEmpty()) return;

      orientation.teacher = teacher;
      teacher.getProductions().put(year, orientation);

      HashMap<String, Collaborator> students = orientation.getStudents();
      for (Collaborator student : studentList) {
         String studentName = student.getName();
         Collaborator.Type type = student.getType();
         if (type == Collaborator.Type.TEACHER ||
               type == Collaborator.Type.RESEARCHER) {
            System.out.println("<Alerta> " + studentName + " não é aluno.");
            continue;
         }

         students.put(studentName, student);
      }

      //orientationCount++;
      System.out.println("Orientação adicionada.");
   }

   private static void addPublication() {
      System.out.print("Data (ano): ");
      int year = input.nextInt(); input.nextLine();

      Production publication = new Production(
            Production.Type.PUBLICATION, year);

      System.out.print("Título da publicação: ");
      publication.title = input.nextLine();

      System.out.print("Conferência: ");
      publication.conference = input.nextLine();

      HashMap<String, Collaborator> authors = publication.getAuthors();
      System.out.print("Associar a projeto? (s/n): ");
      if (input.nextLine().equals("s")) {
         Project project = getProject(Project.Status.RUNNING);
         if (project == null) return;

         publication.project = project;
         project.getPublications().put(year, publication);

         HashMap<String, Collaborator> participants = project.getParticipants();
         for (Collaborator participant : participants.values()) {
            authors.put(participant.getName(), participant);
            participant.getProductions().put(year, publication);
         }
      } else {
         ArrayList<Collaborator> authorList = getCollaborators("Nome dos autores");
         for (Collaborator author : authorList) {
            authors.put(author.getName(), author);
            author.getProductions().put(year, publication);
         }
      }

      //publicationCount++;
      System.out.println("Publicação '" + publication.title + "' adicionada.");
   }

   private static void addProject() {
      System.out.print("Título: ");
      String title = input.nextLine();

      Project project = new Project(title);
      title = project.getTitle();
      projects.put(title, project);

      System.out.println("Projeto '" + title + "' adicionado.");
   }

   private static void allocate() {
      Project project = getProject(Project.Status.LOADING);
      if (project == null) return;

      ArrayList<Collaborator> participants =
            getCollaborators("Nome dos participantes");
      if (participants.isEmpty()) return;

      for (Collaborator participant : participants) {
         String name = participant.getName();
         project.getParticipants().put(name, participant);
         System.out.println("Participante " + name + " alocado ao projeto '" +
               project.getTitle() + "'.");
      }
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

   private static void finishProject() {
      Project project = getProject(Project.Status.RUNNING);
      if (project == null) return;

      if (project.getPublications().isEmpty()) {
         System.out.println("<Erro> Não há publicações associadas ao projeto.");
         return;
      }

      project.setStatus(Project.Status.DONE);
      System.out.println(
            "Projeto '" + project.getTitle() +
            "' " + project.getStatus() + ".");
   }
   
   private static Collaborator getCollaborator(String prompt) {
      System.out.print(prompt + ": ");
      Collaborator collaborator = collaborators.get(input.nextLine());

      if (collaborator == null) {
         System.out.println("<Erro> Não encontrado.");
         return null;
      }

      return collaborator;
   }

   private static ArrayList<Collaborator> getCollaborators(String prompt) {
      ArrayList<Collaborator> collabList = new ArrayList<>();
      System.out.println(prompt + " ('-' para encerrar):");

      while (true) {
         String name = input.nextLine();
         if (name.isEmpty() || name.equals("-")) break;

         Collaborator collaborator = collaborators.get(name);
         if (collaborator == null) {
            System.out.println("<Alerta> Não encontrado.");
            continue;
         }

         collabList.add(collaborator);
      }

      return collabList;
   }

   private static Project getProject(Project.Status status) {
      System.out.print("Título do projeto: ");
      Project project = projects.get(input.nextLine());
      if (project == null) {
         System.out.println("<Erro> Não encontrado.");
         return null;
      }

      Project.Status projectStatus = project.getStatus();
      if (status != null && projectStatus != status) {
         System.out.println("<Erro> Projeto " + projectStatus + ".");
         return null;
      }

      return project;
   }

   private static void runProject() {
      Project project = getProject(Project.Status.LOADING);
      if (project == null) return;

      if (!project.hasBasicInfo()) {
         System.out.println("<Erro> Informações básicas incompletas.");
         return;
      }

      HashMap<String, Collaborator> participants = project.getParticipants();
      String title = project.getTitle();
      for (Collaborator participant : participants.values()) {
         if (participant.getType() == Collaborator.Type.GRADER &&
               participant.hasRunningProject()) {
            System.out.println("<Alerta> Aluno " + participant.getName() +
                  " já participa de outro projeto.");
            continue;
         }
         participant.getProjects().put(title, project);
      }

      project.setStatus(Project.Status.RUNNING);
      System.out.println(
            "Projeto '" + title + "' " + project.getStatus() + ".");
   }

   private static void viewCollaborator() {
      Collaborator collaborator = getCollaborator("Nome do colaborador");
      if (collaborator == null) return;
      System.out.println(collaborator);
   }

   private static void viewProject() {
      Project project = getProject(null);
      if (project == null) return;
      System.out.println(project);
   }
}