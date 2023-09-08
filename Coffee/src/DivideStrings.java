import java.util.ArrayList;
import java.util.Scanner;
public class DivideStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> inputList = new ArrayList<String>();
		ArrayList<String> smallStrs = new ArrayList<String>();
		ArrayList<String> bigStrs = new ArrayList<String>();
		
		int a = 0;
		while (a <= 20) {
			System.out.println("Enter a string");
			String input = scan.nextLine();
			inputList.add(input);
			System.out.println();
			a++;
		}
		
		for (int i = 0; i < inputList.size(); i++) {
			if (inputList.get(i).length() <= 5)
				smallStrs.add(inputList.get(i));
			else
				bigStrs.add(inputList.get(i));
		}
		
		while (true) {
			System.out.println("Which list of strings would you like to display? (small/large)");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("small")) {
				System.out.println(smallStrs.toString());
				break;
			}
			else if (input.equalsIgnoreCase("large")) {
				System.out.println(bigStrs.toString());
				break;
			}
			else
				System.out.println("Invalid Input, try again.");
		}
	}

}
