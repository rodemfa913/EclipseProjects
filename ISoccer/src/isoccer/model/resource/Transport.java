package isoccer.model.resource;

public class Transport extends Resource {
   private int nSeat;

   public Transport(int id) {
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

   @Override
   public String toString() {
      return super.toString() + "\nNúmero de assentos: " + nSeat;
   }
}