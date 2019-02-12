package isoccer.builder.resource;

import isoccer.ISoccer;
import isoccer.model.resource.Bus;
import isoccer.model.resource.Resource;
import java.util.ArrayList;
import java.util.HashMap;

public class BusBuilder extends ResourceBuilder {
   private static int busCount;
   private static final HashMap<Integer, Bus> fleet = new HashMap<>();

   @Override
   public Bus build() throws Exception {
      Bus bus = new Bus(busCount++);
      setInfo(bus);
      fleet.put(bus.id, bus);

      return bus;
   }

   public static ArrayList<Bus> getFleet() {
      return new ArrayList<>(fleet.values());
   }

   @Override
   public Bus getResource() {
      System.out.print("Id: ");
      return fleet.get(Integer.parseInt(ISoccer.input.nextLine()));
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