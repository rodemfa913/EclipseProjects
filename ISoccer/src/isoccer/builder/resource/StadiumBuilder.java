package isoccer.builder.resource;

import isoccer.ISoccer;
import isoccer.model.resource.Resource;
import isoccer.model.resource.Stadium;

public class StadiumBuilder extends ResourceBuilder {
   private static Stadium stadium;

   @Override
   public Stadium build() throws Exception {
      stadium = new Stadium(0);
      setInfo(stadium);

      return stadium;
   }

   public static Stadium getStadium() {
      return stadium;
   }

   @Override
   public Stadium getResource() {
      return stadium;
   }

   @Override
   public String getType() {
      return "estádio";
   }

   @Override
   public void setInfo(Resource resource) {
      super.setInfo(resource);

      Stadium stadium = (Stadium) resource;

      System.out.print("Capacidade: ");
      stadium.setCapacity(Integer.parseInt(ISoccer.input.nextLine()));

      System.out.print("Número de banheiros: ");
      stadium.setNumWC(Integer.parseInt(ISoccer.input.nextLine()));

      System.out.print("Número de lanchonetes: ");
      stadium.setNumSnackBar(Integer.parseInt(ISoccer.input.nextLine()));
   }
}