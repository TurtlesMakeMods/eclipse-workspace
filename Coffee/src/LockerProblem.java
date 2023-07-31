/**
 * Locker Program
 * This programs follows the locker challenge where
 * A school has 100 lockers and 100 students. All lockers
 * are closed on the first day of school. As the students
 * enter, the first student, denoted S1, opens every 
 * locker. Then the second student, S2, begins with the 
 * second locker, denoted L2, and closes every other locker. 
 * Student S3 begins with the third locker and changes every 
 * third locker (closes it if it was open, and opens it if it 
 * was closed). Student S4 begins with locker L4 and changes 
 * every fourth locker. Student S5 starts with L5 and changes 
 * every fifth locker, and so on, until student S100 changes L100.
 * @author S26600478 Titus Domey
 *
 */
public class LockerProblem {

	public static void main(String[] args) {
		
		boolean[] lockers = new boolean[100];
		
		for (int student = 1; student <= lockers.length; student++)
			changeLocker(lockers, student);
		
		for (int i = 0; i < lockers.length; i++)
			System.out.printf("L%d = %b%n", (i+1),lockers[i]);
	}
	
	public static void changeLocker(boolean[] lockers, int student) {
		for (int i = student-1; i < lockers.length; i += student)
			lockers[i] = !lockers[i];
	}
}
