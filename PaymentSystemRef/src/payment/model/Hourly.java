package payment.model;

import java.util.ArrayList;

public class Hourly extends Employee {
   private ArrayList<PointCard> cards;

   public Hourly() {
      this(-1);
   }

   public Hourly(int id) {
      super(id);
      this.cards = new ArrayList<>();
   }

   @Override public Hourly clone() {
      Hourly other = (Hourly) super.clone();
      other.cards = new ArrayList<>(this.cards);
      return other;
   }

   @Override public Hourly create(int id) {
      return new Hourly(id);
   }

   public ArrayList<PointCard> getPointCards() {
      return this.cards;
   }

   public static String getType() {
      return "horista";
   }

   @Override public boolean isPaymentDay(SimpleDate date) {
      return date.getDayOfWeek() == SimpleDate.DayOfWeek.FRIDAY;
   }

   @Override public double receivePayment() {
      double value = 0.0;

      for (PointCard card : this.cards) {
         double salary = this.getSalary();
         int hours = card.getHours();
         value += salary * hours;
         if (hours > 8)
            value += 0.5 * salary * (hours - 8);
      }

      this.cards.clear();

      return value;
   }

   @Override public void setService(String service, double fee) {
      super.setService(service, 0.25 * fee);
   }

   @Override public void setSyndicateFee(double fee) {
      super.setSyndicateFee(0.25 * fee);
   }

   @Override public String toString() {
      String h = super.toString() + "\nCartões de ponto:";
      for (PointCard card : this.cards)
         h += "\n  " + card;
      return h;
   }
}