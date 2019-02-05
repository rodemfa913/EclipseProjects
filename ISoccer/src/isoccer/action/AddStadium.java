package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.resource.Stadium;

public class AddStadium extends Action {
   @Override
   public void doAction() throws Exception {
      ISoccer.stadium = new Stadium(-1);

      ISoccer.stadium.available = true;

      System.out.print("Capacidade: ");
      ISoccer.stadium.setCapacity(Integer.parseInt(ISoccer.input.nextLine()));

      System.out.print("Número de banheiros: ");
      ISoccer.stadium.setNumWC(Integer.parseInt(ISoccer.input.nextLine()));

      System.out.print("Número de lanchonetes: ");
      ISoccer.stadium.setNumSnackBar(
            Integer.parseInt(ISoccer.input.nextLine()));

      System.out.println("Estádio adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar estádio";
   }
}
