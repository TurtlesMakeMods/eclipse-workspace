import java.util.Scanner;
import java.util.Calendar;
import java.util.Calendar.Builder;
//import java.util.boinky;
/**
 * AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
 * @author S26600478
 *
 */
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
		Builder builder = new Builder();
		//Calendar calendar = Calendar();
		int monthNumber = 0;
		int day = 0;
		int year = 0;
		String input;
		String monthName = "";
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		System.out.println("Enter a date in MM/DD/YYYY format");
		input = scan.nextLine();
		
		if (input.substring(0,1).equals("0"))
			monthNumber = Integer.parseInt(input.substring(0,2));
		else if ((Integer.parseInt(input.substring(0,1)) <= 1) || (Integer.parseInt(input.substring(0,1)) >= 12))
			monthNumber = Integer.parseInt(input.substring(0,1));
		else {
			System.out.println("Error: Invalid Input");
			System.exit(0);
		}
		
		if (Integer.parseInt(input.substring(3,5)) <= 31)
			day = Integer.parseInt(input.substring(3,5));
		else {
			System.out.println("Error: Invalid Input");
			System.exit(0);
		}
		
		year = Integer.parseInt(input.substring(6,10));
		
		System.out.println(monthNumber);
		System.out.println(day);
		System.out.println(year);
		
		switch (monthNumber) {
			case 1: {
				monthName = "January";
				break;
			}
			case 2: {
				monthName = "February";
				break;
			}
			case 3: {
				monthName = "March";
				break;
			}
			case 4: {
				monthName = "April";
				break;
			}
			case 5: {
				monthName = "May";
				break;
			}
			case 6: {
				monthName = "June";
				break;
			}
			case 7: {
				monthName = "July";
				break;
			}
			case 8: {
				monthName = "August";
				break;
			}
			case 9: {
				monthName = "September";
				break;
			}
			case 10: {
				monthName = "October";
				break;
			}
			case 11: {
				monthName = "November";
				break;
			}
			case 12: {
				monthName = "December";
				break;
			}
		}
		System.out.println(monthName);
	}
}
