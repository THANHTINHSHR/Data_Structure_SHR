package giua_ki_SHR;

public class Date {
	int day;
	int month;
	int year;

	public Date(int day, int month, int year) {
		if (!isDate(day, month, year))
			throw new IllegalArgumentException("");
		this.day = day;
		this.month = month;
		this.year = year;

	}

	@Override
	public String toString() {
		return day + " / " + month + " / " + year;
	}

	public boolean dayBefore(Date that) {
		if (this.year < that.year)
			return true;
		if (this.year == that.year && this.month < that.month)
			return true;
		if (this.year == that.year && this.month == that.month && this.day < that.day)
			return true;
		return false;
	}

	// kiểm tra có phải năm nhuận hay không
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
	}
	
	public boolean isLeapYear() {
		return isLeapYear(year);
	}

	// kiểm tra có phải là 1 kiểu ngày theo logic hay không
	private static boolean isDate(int day, int month, int year) {
		return (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
				&& (day > 0 && day <= 31))
				|| (month == 4 || month == 6 || month == 9 || month == 10 || month == 11) && (day > 0 && day <= 30)
				|| ((!isLeapYear(year) && month == 2) && (day > 0 && day <= 28))
				|| ((isLeapYear(year) && month == 2) && (day > 0 && day <= 29)));

	}


}
