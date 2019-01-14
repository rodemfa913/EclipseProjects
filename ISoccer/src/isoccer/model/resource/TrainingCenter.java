package isoccer.model.resource;

public class TrainingCenter extends Resource {
   private int nBedroom;

   public TrainingCenter() {
      super(-1);
   }

   public TrainingCenter(int id) {
      super(id);
   }

   @Override
   public TrainingCenter create(int id) {
      return new TrainingCenter(id);
   }

   public int getNumBedroom() {
      return nBedroom;
   }

   @Override
   public String getType() {
      return "centro de treinamento";
   }

   public void setNumBedroom(int nBedroom) {
      if (nBedroom < 0)
         nBedroom = 0;
      this.nBedroom = nBedroom;
   }
}