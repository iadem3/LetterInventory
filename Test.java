import java.util.*;



public class Test {

	static Scanner sc = new Scanner(System.in);
	static char c;
	static int amount;
	
	public static void main(String[] args) {
		System.out.println("Please type a phrase");
		String input = sc.next();
		
		LetterInventory r = new LetterInventory(input);
		
		
		
		if(LetterInventory.isEmpty(r)) {
			System.out.println("Please type in a phrase of at least one character ");
			input = sc.next();
			r = new LetterInventory(input);
		
		}
		
		
		int I = r.size();
		System.out.println("Your phrase has " + I + " letters, and here they are listed alphabetically " + r.toString() + ". Would you like to add or subtract letters (yes/no)?");
		String answer = sc.next();
		
		
		
		
		if(answer.equals("yes")) {
			System.out.println("Which letter would you like to alter? ");
			c = sc.next().charAt(0);
			System.out.println("Would you like to add or subtract? ");
			String answer2 = sc.next();
			answer2.toLowerCase();
			
			System.out.println("How many would like to add or subtract?");
			amount = sc.nextInt();
			
			String newLetterInventoryContent = "";
			
			for(int i = 0; i < amount; i++) {
				newLetterInventoryContent += c;
			}
			LetterInventory changes = new LetterInventory(newLetterInventoryContent);
			
			
			if(answer2.equals("add")) {
				r = r.add(changes);
			}
			else {
				r = r.subtract(changes);
			}
			
			
			
			
			
			System.out.println("Your Letter Inventory is now " + r.toString() + " and contains " + r.size() + " letters");
		}
			
			System.out.println("Thank you for using the Letter Inventory Program!");
		
		
		
		
		
	
		
		
		
	}
	
}
