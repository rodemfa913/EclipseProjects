package payment.model;

public class PointCard {
	private SimpleDate date;
	private int hours;
	
	public PointCard(SimpleDate date, int hours) {
		this.date = date;
		this.hours = hours;
	}
	
	public SimpleDate getDate() { return this.date; }
	
	public int getHours() { return this.hours; }
	
	@Override public String toString() { return this.date + ": " + this.hours; }
}