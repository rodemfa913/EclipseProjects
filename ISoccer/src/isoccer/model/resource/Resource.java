package isoccer.model.resource;

import isoccer.model.Creator;

public abstract class Resource implements Creator {
   public boolean available;
   public final int id;

   protected Resource(int id) {
      this.id = id;
   }
}