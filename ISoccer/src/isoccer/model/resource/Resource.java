package isoccer.model.resource;

public abstract class Resource {
   public boolean available;
   public final int id;
   private String name;

   public Resource(int id) {
      this.id = id;
      this.name = "-";
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      if (name.isEmpty())
         name = "-";
      this.name = name;
   }

   @Override
   public String toString() {
      return "Nome: " + name + "\nDisponível: " + (available ? "sim" : "não");
   }
}