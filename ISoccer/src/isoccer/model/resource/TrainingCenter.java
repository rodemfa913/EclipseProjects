package isoccer.model.resource;

public class TrainingCenter extends Resource {
   private int nBedroom;

   public TrainingCenter(int id) {
      super(id);
   }

   public int getNumBedroom() {
      return nBedroom;
   }

   public void setNumBedroom(int nBedroom) {
      if (nBedroom < 0)
         nBedroom = 0;
      this.nBedroom = nBedroom;
   }

   @Override
   public String toString() {
      return super.toString() + "\nNúmero de dormitórios: " + nBedroom;
   }
}