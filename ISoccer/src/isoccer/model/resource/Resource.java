package isoccer.model.resource;

public abstract class Resource {
   public boolean available;
   public final int id;

   public Resource(int id) {
      this.id = id;
   }
}