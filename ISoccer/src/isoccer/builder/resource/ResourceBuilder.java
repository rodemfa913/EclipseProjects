package isoccer.builder.resource;

import isoccer.builder.Builder;
import isoccer.ISoccer;
import isoccer.model.resource.Resource;

public abstract class ResourceBuilder implements Builder<Resource> {
   public abstract Resource getResource();

   @Override
   public String getType() {
      return "recurso físico";
   }

   protected void setInfo(Resource resource) {
      resource.available = true;

      System.out.print("Nome: ");
      resource.setName(ISoccer.input.nextLine());
   }
}