package isoccer.model.resource;

public class Stadium extends Resource {
   private int capacity, nWC, nSnackBar;

   public Stadium(int id) {
      super(id);
   }

   public int getCapacity() {
      return capacity;
   }

   public int getNumWC() {
      return nWC;
   }

   public int getNumSnackBar() {
      return nSnackBar;
   }

   public void setCapacity(int capacity) {
      if (capacity < 0)
         capacity = 0;
      this.capacity = capacity;
   }

   public void setNumWC(int nWC) {
      if (nWC < 0)
         nWC = 0;
      this.nWC = nWC;
   }

   public void setNumSnackBar(int nSnackBar) {
      if (nSnackBar < 0)
         nSnackBar = 0;
      this.nSnackBar = nSnackBar;
   }

   @Override
   public String toString() {
      return super.toString() + "\nCapacidade: " + capacity +
            "\nNúmero de banheiros: " + nWC +
            "\nNúmero de lanchonetes: " + nSnackBar;
   }
}