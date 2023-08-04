import java.util.Scanner;
import java.time.LocalDate;
//import java.util.boinky;
/**
 * Titus Domey's ConvertDate program: "allows
 * the user to enter a date using digits and slashes 
 * (for example, "6/24/2014"), and receive an output that 
 * displays the date with the month shown as a word (Such as 
 * "June 24, 2014").  It allows for the fact that the user might or 
 * might not precede a month or day number with a zero (for 
 * example the user might type "06/24/2014" or "6/24/2014"). 
 * It does not allow the user to enter an invalid date, defined as one 
 * for which the month is less than 1 or more than 12, 
 * or one for which the day number is less 
 * than one or more than the number of days in the specified month.  
 * Also, it displays the date's ordinal position in the year. 
 * For example, 6/24/2014 is the 175th day of the year."
 * (Courtesy of Schoology)
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
		boolean leapYear = false;
		int monthNumber = 0;
		int day = 0;
		int year = 0;
		int dayOfYear;
		String input;
		String monthName = "";
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		System.out.println("Enter a date in MM/DD/YYYY format");
		input = scan.nextLine();
		try {
			if (input.substring(0,1).equals("0")) {
				monthNumber = Integer.parseInt(input.substring(0,2));
				if (Integer.parseInt(input.substring(3,5)) <= 31)
					day = Integer.parseInt(input.substring(3,5));
				else {
					System.out.println("Error: Invalid Input");
					System.exit(0);
				}
				year = Integer.parseInt(input.substring(6,10));
			}
			else if ((Integer.parseInt(input.substring(0,1)) >= 1) || (Integer.parseInt(input.substring(0,2)) <= 12)) {
				monthNumber = Integer.parseInt(input.substring(0,1));
				if (Integer.parseInt(input.substring(2,4)) <= 31)
					day = Integer.parseInt(input.substring(2,4));
				else {
					System.out.println("Error: Invalid Input");
					System.exit(0);
				}
				year = Integer.parseInt(input.substring(5,9));
			}
			else {
				System.out.println("Error: Invalid Input");
				System.exit(0);
			}
		}
		catch (java.lang.NumberFormatException e) {
			System.out.println("Error: Invalid Input");
			System.exit(0);
		}
		catch (java.lang.StringIndexOutOfBoundsException f) {
			System.out.println("Error: Invalid Input");
			System.exit(0);
		}
		LocalDate date = LocalDate.of(year, monthNumber, day);
		
		switch (monthNumber) {
			case 1: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 2: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 3: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 4: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 5: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 6: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 7: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 8: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 9: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 10: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 11: {
				monthName = monthNames[monthNumber-1];
				break;
			}
			case 12: {
				monthName = monthNames[monthNumber-1];
				break;
			}
		}
		
		dayOfYear = date.getDayOfYear();
		
		System.out.println("The day is "+monthName+" "+day+", "+year);
		System.out.println("It is day #"+dayOfYear+" of the year "+year);
	}
}
