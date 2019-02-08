package isoccer.model.resource;

public class Bus extends Resource {
   private int nSeat;

   public Bus(int id) {
      super(id);
   }

   public int getNumSeat() {
      return nSeat;
   }

   public void setNumSeat(int nSeat) {
      if (nSeat < 0)
         nSeat = 0;
      this.nSeat = nSeat;
   }
}