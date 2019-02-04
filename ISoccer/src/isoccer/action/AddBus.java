package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.resource.Bus;

public class AddBus extends Action {
   @Override
   public void doAction() throws Exception {
      Bus bus = new Bus(ISoccer.fleet.size());

      bus.available = true;

      System.out.print("Número de assentos: ");
      bus.setNumSeat(Integer.parseInt(ISoccer.input.nextLine()));

      //ISoccer.fleet.add(bus);
      
      System.out.println("Ônibus " + bus.id + " adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar ônibus";
   }
}