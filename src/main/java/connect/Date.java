package connect;

public class Date {
	private int day;
	private String month;
	private int year;
	public Date(int day, String month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getMonth() {
		switch(month) {
			case "01": {
				return "IAN";
			}
			case "02": {
				return "FEB";
			}
			case "03": {
				return "MAR";
			}
			case "04": {
				return "APR";
			}
			case "05": {
				return "MAY";
			}
			case "06": {
				return "JUN";
			}
			case "07": {
				return "JUL";
			}
			case "08": {
				return "AUG";
			}
			case "09": {
				return "SEP";
			}
			case "10": {
				return "OCT";
			}
			case "11": {
				return "NOV";
			}
			case "12": {
				return "DEC";
			}
		}
		return "NO-MONTH";
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
