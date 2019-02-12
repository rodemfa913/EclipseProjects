package isoccer.action.report;

import isoccer.builder.resource.*;
import isoccer.model.resource.*;
import java.util.ArrayList;

public class ResourceReport implements Report {
   @Override
   public void generate() {
      System.out.println("Transporte:");
      ArrayList<Transport> fleet = TransportBuilder.getFleet();
      if (fleet.isEmpty())
         System.out.println("---\nIndisponível");
      else for (Transport transport : fleet)
         System.out.println("---\n" + transport);

      System.out.println("Estádio:");
      Stadium stadium = StadiumBuilder.getStadium();
      if (stadium == null)
         System.out.println("---\nIndisponível");
      else
         System.out.println("---\n" + stadium);

      System.out.println("Centro de treinamento:");
      TrainingCenter trainingCenter = TrainingCenterBuilder.getTrainingCenter();
      if (trainingCenter == null)
         System.out.println("---\nIndisponível");
      else
         System.out.println("---\n" + trainingCenter);
   }

   @Override
   public String toString() {
      return "recursos físicos";
   }
}