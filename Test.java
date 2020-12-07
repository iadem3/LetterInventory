import java.util.*;
public class Test {

	public static void main(String[] args) {
		String D = "Ibraaahem-Adeeeeem";
		String F = "Ibrahem-Adem";
		LetterInventory r = new LetterInventory(D);
		int I = r.size();
		LetterInventory r2 = new LetterInventory(F);
		//System.out.println(LetterInventory.isEmpty(r));
		//System.out.println(r.toString(r));
		System.out.println(r.get('e'));
		r.set('a', 6);
		System.out.println(r.get('a'));
		//LetterInventory r1 = r.subtract(r2);
		//System.out.println(r1.toString());
		
		System.out.println(r.toString());
		
		
	}
	
}
