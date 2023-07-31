import java.util.Scanner;

public class ConvertDate {
	public static final int JANUARY = 31;
	public static final int FEBRUARY = 28;
	public static final int FEBRUARY_LEAP_YEAR = 29;
	public static final int MARCH = 31;
	public static final int APRIL = 30;
	public static final int MAY = 31;
	public static final int JUNE = 30;
	public static final int JULY = 31;
	public static final int AUGUST = 31;
	public static final int SEPTEMBER = 30;
	public static final int OCTOBER = 31;
	public static final int NOVEMBER = 30;
	public static final int DECEMBER = 31;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int monthNumber;
		int monthName;
		int day;
		String input;
		
		System.out.println("Enter a date in MM/DD/YYYY format");
		input = scan.nextLine();
		
		
		if (input.substring(0,1).equals("0"))
			monthNumber = Integer.parseInt(input.substring(0,2));
		else
			monthNumber = Integer.parseInt(input.substring(0,1));
		
		System.out.println(monthNumber);
		//if ()
	}

}
