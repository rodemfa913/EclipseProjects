package isoccer.action;

import isoccer.builder.partner.*;
import isoccer.ISoccer;

public class SetContribution implements Action {
   private FanPartnerBuilder[] setters;

   public SetContribution() {
      setters = new FanPartnerBuilder[] {
         new JuniorBuilder(), new SeniorBuilder(), new EliteBuilder()
      };
   }

   @Override
   public void doAction() throws Exception {
      System.out.println("---");
      int p;
      for (p = 0; p < setters.length; p++)
         System.out.println(p + " - " + setters[p].getType());
      System.out.print("---\nTipo: ");
      p = Integer.parseInt(ISoccer.input.nextLine());

      System.out.print("Valor de contribuição: ");
      setters[p].setContribution(Double.parseDouble(ISoccer.input.nextLine()));
   }

   @Override
   public String toString() {
      return "inserir valor de contribuição";
   }
}