package isoccer.model.resource;

public class Bus extends Resource {
   public final int id;
   private int nSeat;

   public Bus(int id) {
      this.id = id;
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