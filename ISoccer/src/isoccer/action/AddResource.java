package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.resource.*;

public class AddResource extends Action {
   private int nResource;

   @Override
   public void doAction() throws Exception {
      Resource[] creators = new Resource[] {
         new Bus(), new Stadium(), new TrainingCenter()
      };

      System.out.println("---");
      int r;
      for (r = 0; r < creators.length; r++)
         System.out.println(r + " - " + creators[r].getType());
      System.out.print("---\nRecurso: ");
      r = Integer.parseInt(ISoccer.input.nextLine());

      Resource resource = (Resource) creators[r].create(nResource++);
      resourceInfo(resource);
      ISoccer.resources.put(resource.id, resource);
      
      System.out.println("Recurso '" + resource.id +
            ": " + resource.getType() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar recurso";
   }
}