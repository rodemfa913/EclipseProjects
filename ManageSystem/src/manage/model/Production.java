package manage.model;

public class Production {
   public enum Type {
      ORIENTATION, PUBLICATION;

      @Override public String toString() {
         switch (this) {
         case ORIENTATION:
            return "orientação";
         default:
            return "publicação";
         }
      }
   }

   private Type type;
   private int year;

   public Production(Type type, int year) {
      this.type = type;
      this.year = year;
   }

   public Type getType() { return this.type; }

   public int getYear() { return this.year; }
}