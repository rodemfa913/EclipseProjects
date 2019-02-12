package isoccer.builder.resource;

import isoccer.ISoccer;
import isoccer.model.resource.Transport;
import isoccer.model.resource.Resource;
import java.util.ArrayList;
import java.util.HashMap;

public class TransportBuilder extends ResourceBuilder {
   private static int transportCount;
   private static final HashMap<Integer, Transport> fleet = new HashMap<>();

   @Override
   public Transport build() throws Exception {
      Transport bus = new Transport(transportCount++);
      setInfo(bus);
      fleet.put(bus.id, bus);

      return bus;
   }

   public static ArrayList<Transport> getFleet() {
      return new ArrayList<>(fleet.values());
   }

   @Override
   public Transport getResource() {
      System.out.print("Id: ");
      return fleet.get(Integer.parseInt(ISoccer.input.nextLine()));
   }

   @Override
   public String getType() {
      return "transporte";
   }

   @Override
   protected void setInfo(Resource resource) {
      super.setInfo(resource);

      Transport bus = (Transport) resource;
      System.out.print("Número de assentos: ");
      bus.setNumSeat(Integer.parseInt(ISoccer.input.nextLine()));
   }
}