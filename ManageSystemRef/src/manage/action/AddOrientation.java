package manage.action;

import java.util.ArrayList;
import manage.model.collaborator.*;
import manage.model.production.Orientation;

public class AddOrientation extends Action {
   @Override
   public void doAction() throws Exception {
      Collaborator collaborator = this.getCollaborator("Nome do professor");
      if (!(collaborator instanceof Teacher))
         throw new Exception("Não é " + (new Teacher()).getType());

      ArrayList<Collaborator> students =
            this.getCollaborators("Nome dos alunos");

      Orientation orientation = new Orientation();
      Teacher teacher = (Teacher) collaborator;
      orientation.teacher = teacher;
      teacher.getOrientations().add(orientation);

      for (Collaborator student : students) {
         if (!(student instanceof Student)) {
            System.out.println("<!> " + student.getName() + " não é aluno.");
            continue;
         }

         orientation.setStudent((Student) student);
      }

      nOrientation++;
      System.out.println("Orientação adicionada.");
   }

   @Override
   public String toString() {
      return "adicionar orientação";
   }
}