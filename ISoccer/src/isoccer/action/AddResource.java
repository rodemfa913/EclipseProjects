package isoccer.action;

import isoccer.ISoccer;
import isoccer.manager.resource.*;
import isoccer.model.resource.Resource;

public class AddResource extends Action {
   ResourceManager[] builders;

   public AddResource() {
      builders = new ResourceManager[] {new BusManager()};
   }

   @Override
   public void doAction() throws Exception {
      System.out.println("---");
      int r;
      for (r = 0; r < builders.length; r++)
         System.out.println(r + " - " + builders[r].getType());
      System.out.print("---\nTipo: ");
      r = Integer.parseInt(ISoccer.input.nextLine());

      Resource resource = builders[r].build();

      System.out.println("Recurso físico '" + resource.id +
            ": " + builders[r].getType() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar recurso físico";
   }
}