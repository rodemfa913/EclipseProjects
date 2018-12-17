package payment.model;

public class SaleResult {
   private SimpleDate date;
   private double value;

   public SaleResult(SimpleDate date, double value) {
      this.date = date;
      this.value = value;
   }

   public SimpleDate getDate() {
      return this.date;
   }

   public double getValue() {
      return this.value;
   }

   @Override public String toString() {
      return this.date + ": " + this.value;
   }
}