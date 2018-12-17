package payment.model;

/**
  * Um modelo simplificado de data.
  * Todo mês tem 28 dias; um ano tem 12 meses e sempre começa num domingo.
  * Não há ano bissexto.
  * @author Rodrigo &lt;rodrigo.araujo@ic.ufal.br&gt;
  */
public class SimpleDate {
   public enum DayOfWeek {
      SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
   }

   private int day, month, year;

   /**
     * Cria uma nova instância de SimpleDate.
     * @param year ano
     * @param month mês: 1 &lt;= month &lt;= 12.
     * @param day dia: 1 &lt;= day &lt;=28 para <strong>todos</strong> os meses.
     */
   public SimpleDate(int year, int month, int day) {
      this.year = year;

      if (month < 1) month = 1;
      else if (month > 12) month = 12;
      this.month = month;

      if (day < 0) day = 1;
      else if (day > 28) day = 28;
      this.day = day;
   }

   public int getDay() {
      return this.day;
   }

   public DayOfWeek getDayOfWeek() {
      switch (this.day % 7) {
      case 1:
         return DayOfWeek.SUNDAY;
      case 2:
         return DayOfWeek.MONDAY;
      case 3:
         return DayOfWeek.TUESDAY;
      case 4:
         return DayOfWeek.WEDNESDAY;
      case 5:
         return DayOfWeek.THURSDAY;
      case 6:
         return DayOfWeek.FRIDAY;
      default:
         return DayOfWeek.SATURDAY;
      }
   }

   public int getMonth() {
      return this.month;
   }

   public int getWeekOfMonth() {
      return (this.day - 1) / 7 + 1;
   }

   public int getYear() {
      return this.year;
   }

   public boolean isLastBusinessDay() {
      return this.day == 27;
   }

   @Override public String toString() {
      return this.day + "/" + this.month + "/" + this.year;
   }
}