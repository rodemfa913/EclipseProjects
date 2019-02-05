package isoccer.builder.resource;

import isoccer.builder.Builder;
import isoccer.model.resource.Resource;

public abstract class ResourceBuilder extends Builder<Resource> {
   @Override
   protected void setInfo(Resource resource) {
      resource.available = true;
   }
}