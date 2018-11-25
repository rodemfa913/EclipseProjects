package payment.model;

/**
 * Um modelo simplificado de data.
 * Todo mês tem 28 dias; um ano tem 12 meses e sempre começa num domingo.
 * Não há ano bissexto.
 * @author Rodrigo &lt;rodrigo.araujo@ic.ufal.br&gt;
 */
public class SimpleDate {
	private int day, month, year;
	
	/**
	 * Cria uma nova instância de SimpleDate.
	 * @param year ano
	 * @param month mês: 1 &lt;= month &lt;= 12.
	 * @param day dia: 1 &lt;= day &lt;=28 para <strong>todos</strong> os meses.
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