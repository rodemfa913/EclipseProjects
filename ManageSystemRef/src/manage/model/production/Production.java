package manage.model.production;

public abstract class Production implements Comparable<Production> {
   private static int count;
   private int id;

   public Production() {
      this.id = count++;
   }

   @Override
   public int compareTo(Production other) {
      return this.id - other.id;
   }

   public abstract String getType();

   @Override
   public String toString() {
      return "Tipo: " + this.getType();
   }
}