package isoccer.builder.resource;

import isoccer.ISoccer;
import isoccer.model.resource.Bus;
import isoccer.model.resource.Resource;

public class BusBuilder extends ResourceBuilder {
   private static int busCount;

   @Override
   public Bus build() throws Exception {
      Bus bus = new Bus(busCount++);
      setInfo(bus);
      ISoccer.fleet.put(bus.id, bus);

      return bus;
   }

   @Override
   public String getType() {
      return "ônibus";
   }

   @Override
   protected void setInfo(Resource resource) {
      super.setInfo(resource);

      Bus bus = (Bus) resource;
      System.out.print("Número de assentos: ");
      bus.setNumSeat(Integer.parseInt(ISoccer.input.nextLine()));
   }
}