package isoccer.manager.resource;

import isoccer.manager.Manager;
import isoccer.model.resource.Resource;

public abstract class ResourceManager extends Manager<Resource> {
   @Override
   protected void setInfo(Resource resource) {
      resource.available = true;
   }
}