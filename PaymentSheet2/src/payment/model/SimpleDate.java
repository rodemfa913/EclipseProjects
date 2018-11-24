package payment.model;

/**
 * A simple date model.
 * All months have 28 days; a year has 12 months and always starts at Sunday.
 * There is no leap year.
 * @author Rodrigo &lt;rodrigo.araujo@ic.ufal.br&gt;
 */
public class SimpleDate {
	private int day, month, year;
	
	/**
	 * Creates a new instance of SimpleDate.
	 * @param year
	 * @param month 1 &lt;= month &lt;= 12.
	 * @param day 1 &lt;= day &lt;=28 for <strong>all</strong> months.
	 */
	public SimpleDate(int year, int month, int day) {
		super();
		
		this.year = year;
		
		if (month <= 0) this.month = 1;
		else if (month <= 12) this.month = month;
		else this.month = 12;
		
		if (day <= 0) this.day = 1;
		else if (day <= 28) this.day = day;
		else this.day = 28;
	}
	
	public int getDay() { return this.day; }
	
	public int getMonth() { return this.month; }
	
	public int getYear() { return this.year; }
	
	@Override public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
}