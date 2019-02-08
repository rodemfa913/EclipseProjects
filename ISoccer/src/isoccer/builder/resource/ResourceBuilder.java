package isoccer.builder.resource;

import isoccer.builder.Builder;
import isoccer.model.resource.Resource;

public abstract class ResourceBuilder implements Builder<Resource> {
   protected void setInfo(Resource resource) {
      resource.available = true;
   }
}