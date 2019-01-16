package isoccer.action;

import isoccer.ISoccer;
import isoccer.model.resource.TrainingCenter;

public class AddTrainingCenter extends Action {
   @Override
   public void doAction() throws Exception {
      ISoccer.trainingCenter = new TrainingCenter();

      ISoccer.trainingCenter.available = true;

      System.out.print("Número de dormitórios: ");
      ISoccer.trainingCenter.setNumBedroom(
            Integer.parseInt(ISoccer.input.nextLine()));

      System.out.println("Centro de treinamento adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar centro de treinamento";
   }
}