package isoccer.manager.resource;

import isoccer.ISoccer;
import isoccer.model.resource.Bus;
import isoccer.model.resource.Resource;

public class BusManager extends ResourceManager {
   private static int busCount;
   @Override
   public Bus build() throws Exception {
      Bus bus = new Bus(busCount++);
      setInfo(bus);
      put(bus);

      return bus;
   }

   @Override
   public String getType() {
      return "ônibus";
   }

   @Override
   protected Bus put(Resource resource) {
      Bus bus = (Bus) resource;
      return ISoccer.fleet.put(bus.id, bus);
   }

   @Override
   protected void setInfo(Resource resource) {
      super.setInfo(resource);

      Bus bus = (Bus) resource;
      System.out.print("Número de assentos: ");
      bus.setNumSeat(Integer.parseInt(ISoccer.input.nextLine()));
   }
}