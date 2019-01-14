package isoccer.model.resource;

public class Stadium extends Resource {
   private int capacity, nBathroom, nSnackBar;

   public Stadium() {
      super(-1);
   }

   public Stadium(int id) {
      super(id);
   }

   @Override
   public Stadium create(int id) {
      return new Stadium(id);
   }

   public int getCapacity() {
      return capacity;
   }

   public int getNumBathroom() {
      return nBathroom;
   }

   public int getNumSnackBar() {
      return nSnackBar;
   }

   @Override
   public String getType() {
      return "estádio";
   }

   public void setCapacity(int capacity) {
      if (capacity < 0)
         capacity = 0;
      this.capacity = capacity;
   }

   public void setNumBathroom(int nBathroom) {
      if (nBathroom < 0)
         nBathroom = 0;
      this.nBathroom = nBathroom;
   }

   public void setNumSnackBar(int nSnackBar) {
      if (nSnackBar < 0)
         nSnackBar = 0;
      this.nSnackBar = nSnackBar;
   }
}