package isoccer.action;

import isoccer.builder.resource.*;
import isoccer.ISoccer;
import isoccer.model.resource.Resource;

public class ManageResource implements Action {
   private ResourceBuilder[] getters;
   private final Exception unavailableException = new Exception("Indisponível.");

   public ManageResource() {
      getters = new ResourceBuilder[] {
         new TransportBuilder(), new StadiumBuilder(),
         new TrainingCenterBuilder()
      };
   }

   @Override
   public void doAction() throws Exception {
      System.out.println("---");
      int r;
      for (r = 0; r < getters.length; r++)
         System.out.println(r + " - " + getters[r].getType());
      System.out.println("---\nRecurso: ");
      r = Integer.parseInt(ISoccer.input.nextLine());

      Resource resource = getters[r].getResource();
      if (resource == null)
         throw unavailableException;

      System.out.print("Disponível? (s/n): ");
      resource.available = ISoccer.input.nextLine().toLowerCase().equals("s");
   }

   @Override
   public String toString() {
      return "gerenciar recurso físico";
   }
}