package manage.action;

import manage.ManageSystem;
import manage.model.collaborator.*;

public class AddCollaborator extends Action {
   @Override
   public void doAction() {
      System.out.print("Nome: ");
      String name = ManageSystem.input.nextLine();

      System.out.print("E-mail: ");
      String email = ManageSystem.input.nextLine();

      Collaborator[] creators = new Collaborator[] {
         new Grader(), new MasterStudent(),
         new Doctorate(), new Teacher(), new Researcher()
      };

      System.out.println("---");
      int t;
      for (t = 0; t < creators.length; t++)
         System.out.println(t + " - " + creators[t].getType());
      System.out.print("---\nTipo: ");
      t = Integer.parseInt(ManageSystem.input.nextLine());

      Collaborator collaborator = creators[t].create(name);
      collaborator.email = email;
      name = collaborator.getName();

      ManageSystem.collaborators.put(name, collaborator);
      System.out.println("Colaborador " + name + " adicionado.");
   }

   @Override public String toString() {
      return "adicionar colaborador";
   }
}