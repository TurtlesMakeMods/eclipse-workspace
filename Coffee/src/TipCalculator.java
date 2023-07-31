/**
 * Simple program to calculate tip amounts and percentages.
 * 7/21/2023
 * @author S26600478 Titus Domey
 */
import javax.swing.JOptionPane;
public class TipCalculator {

	public static void main(String[] args) {
		// Init local variables
		double bill = 0;
		double tipAmount = 0;
		double tipPercent = 0;
		String input = "";

		// Message Dialogue
		input = JOptionPane.showInputDialog("Welcome to Titus' Amazing Tip Calclator. Please enter the bill amount:");
		bill = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Enter the tip percent (most common is 15% - 20%):");
		tipPercent = Double.parseDouble(input);
		
		// Logic to calculate bill
		tipPercent /= 100;
		tipAmount = bill*tipPercent;
		bill = bill + (bill*tipPercent);
		
		// Output message
		JOptionPane.showMessageDialog(null, "The total bill is $" + String.format("%.2f", bill) + "\nYou tipped " + String.format("%.0f", (tipPercent*100)) + "%\nThe tip added $" + String.format("%.2f", tipAmount) + " to your bill");
	}

}