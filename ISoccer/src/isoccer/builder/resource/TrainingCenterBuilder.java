package isoccer.builder.resource;

import isoccer.ISoccer;
import isoccer.model.resource.Resource;
import isoccer.model.resource.TrainingCenter;

public class TrainingCenterBuilder extends ResourceBuilder {
   @Override
   public TrainingCenter build() throws Exception {
      TrainingCenter trainingCenter = new TrainingCenter(0);
      setInfo(trainingCenter);
      ISoccer.trainingCenter = trainingCenter;

      return trainingCenter;
   }

   @Override
   public TrainingCenter getResource() {
      return ISoccer.trainingCenter;
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