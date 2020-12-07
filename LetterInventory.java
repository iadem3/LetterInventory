import java.util.*;
public class LetterInventory {
	private static char[] org;
	private static char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private int[] counter = new int[26];
	
	
	public LetterInventory(String content) {
		
		org = new char[content.length()];
		for(int i = 0; i < content.length(); i++) {
			if(Character.isLetter(content.charAt(i))) {
				org[i] = Character.toLowerCase(content.charAt(i));;
			}
		}
		Arrays.sort(org);
		for(int i = 0; i < 26; i++) {
			for(Character j : org) {
				if(j == alphabet[i]) {
					counter[i]++;
				}
			}
		}
		
	}
	
	public int get(char letter) {
		if(Character.isLetter(letter) == false) {
			throw new IllegalArgumentException();
		}
		
		Character.toLowerCase(letter);
		for(int j = 0; j < 26; j++) {
			if(alphabet[j] == letter) {
				return counter[j];
			}
		}
		return 0;
		
	}
	
	public void set(Character old, int value) {
		if((Character.isLetter(old) == false) || (value < 0)) {
			throw new IllegalArgumentException();
		}
		
		Character.toLowerCase(old);
		
		for(int j = 0; j < 26; j++) {
			if(alphabet[j] == old) {
				counter[j] = value;
			}
		}
		
		
	}
	
	
	public int size() {
		return org.length;
	}
	
	public static boolean isEmpty(LetterInventory A) {
		if(org.length == 0) {
			return true;
		}
		
		return false;
		
	}
	
	public String toString() {
		String hl = "[";
		for(Character l : org) {
			hl += l;
		}
		return hl + ']';
	}
	
	
	
	
	
	public LetterInventory subtract(LetterInventory old) {
		String temp = "";
		for(int i = 0; i < old.counter.length; i++) {
			int y = counter[i] - old.counter[i];
			if(y < 0) {
				return null;
			}
			else {
				for(int k = 0; k < y; k++) {
					temp += alphabet[i];
				}
			}
		}
		LetterInventory new1 = new LetterInventory(temp);
		return new1;
	}
	
	
	
	
	
	
	
	
	public LetterInventory add(LetterInventory old) {
		String temp = "";
		for(int i = 0; i < old.counter.length; i++) {
			int y = counter[i] + old.counter[i];
			for(int k = 0; k < y; k++) {
				temp += alphabet[i];
			}
			
		}
		LetterInventory new1 = new LetterInventory(temp);
		return new1;
	}
	
}
