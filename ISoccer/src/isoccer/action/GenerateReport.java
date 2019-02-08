package isoccer.action;

import isoccer.action.report.*;
import isoccer.ISoccer;

public class GenerateReport extends Action {
   @Override
   public void doAction() throws Exception {
      Report[] reports = new Report[] {
         new StaffReport(), new ResourceReport(), new PartnerReport()
      };

      int r;
      System.out.println("---");
      for (r = 0; r < reports.length; r++)
         System.out.println(r + " - " + reports[r]);
      System.out.print("---\nOpção: ");
      r = Integer.parseInt(ISoccer.input.nextLine());

      reports[r].generate();
   }

   @Override
   public String toString() {
      return "relatório";
   }
}