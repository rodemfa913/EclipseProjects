package payment.model.employee;

import java.util.ArrayList;
import payment.model.*;

public class Commissioned extends Employee {
   private double commission;
   private ArrayList<SaleResult> sales;

   public Commissioned() {
      this(-1);
   }

   public Commissioned(int id) {
      super(id);
      this.sales = new ArrayList<>();
   }

   @Override public Commissioned clone() {
      Commissioned other = (Commissioned) super.clone();
      other.sales = new ArrayList<>(this.sales);
      return other;
   }

   @Override public Commissioned create(int id) {
      return new Commissioned(id);
   }

   public double getCommission() {
      return this.commission;
   }

   public ArrayList<SaleResult> getSaleResults() {
      return this.sales;
   }

   @Override public String getType() {
      return "comissionado";
   }

   @Override public boolean isPaymentDay(SimpleDate date) {
      return date.getDayOfWeek() == SimpleDate.DayOfWeek.FRIDAY &&
            date.getWeekOfMonth() % 2 == 0;
   }

   @Override public double receivePayment() {
      double value = 0.5 * this.getSalary();

      for (SaleResult sale : this.sales)
         value += this.commission * sale.getValue();

      this.sales.clear();

      return value;
   }

   public void setCommission(double commission) {
      if (commission < 0.0)
         commission = 0.0;
      else if (commission > 1.0)
         commission = 1.0;
      this.commission = commission;
   }

   @Override public void setService(String service, double fee) {
      super.setService(service, 0.5 * fee);
   }

   @Override public void setSyndicateFee(double fee) {
      super.setSyndicateFee(0.5 * fee);
   }

   @Override public String toString() {
      String c = super.toString() + "\nResultados de venda:";
      for (SaleResult sale : this.sales)
         c += "\n  " + sale;
      return c;
   }
}