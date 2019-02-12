package isoccer.builder.resource;

import isoccer.ISoccer;
import isoccer.model.resource.Resource;
import isoccer.model.resource.TrainingCenter;

public class TrainingCenterBuilder extends ResourceBuilder {
   private static TrainingCenter trainingCenter;

   @Override
   public TrainingCenter build() throws Exception {
      trainingCenter = new TrainingCenter(0);
      setInfo(trainingCenter);

      return trainingCenter;
   }

   public static TrainingCenter getTrainingCenter() {
      return trainingCenter;
   }

   @Override
   public TrainingCenter getResource() {
      return trainingCenter;
   }

   @Override
   public String getType() {
      return "centro de treinamento";
   }

   @Override
   public void setInfo(Resource resource) {
      super.setInfo(resource);

      TrainingCenter trainingCenter = (TrainingCenter) resource;

      System.out.print("Número de dormitórios: ");
      trainingCenter.setNumBedroom(Integer.parseInt(ISoccer.input.nextLine()));
   }
}