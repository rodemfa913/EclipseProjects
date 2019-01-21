package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.resource.Resource;

public class ManageResource extends Action {
   @Override
   public void doAction() throws Exception {
      System.out.println("---");
      System.out.println("0 - ônibus\n1 - estádio\n2 - centro de treinamento");
      System.out.println("---\nRecurso: ");
      int r = Integer.parseInt(ISoccer.input.nextLine());

      Resource resource;
      switch (r) {
      case 0:
         System.out.print("Id: ");
         resource = ISoccer.fleet.get(
               Integer.parseInt(ISoccer.input.nextLine()));
         break;
      case 1:
         resource = ISoccer.stadium;
         break;
      case 2:
         resource = ISoccer.trainingCenter;
         break;
      default:
         throw new IndexOutOfBoundsException();
      }

      System.out.print("Disponível? (s/n): ");
      resource.available = ISoccer.input.nextLine().toLowerCase().equals("s");
   }

   @Override
   public String toString() {
      return "gerenciar recurso";
   }
}