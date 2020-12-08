import java.util.*;
public class LetterInventory {
	private static char[] org;
	private static char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private int[] counter = new int[26];
	
	//This is the constructor that builds the LetterInventory array, fills it in, and counts the letters based on the given phrase
	//counter array keeps count of each letter in the alphabet contained with in the phrase
	//org actually stores the letters in alphabetial order
	
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
	
	//The method below returns the count of the given letter, throws exception if given char isnt a letter
	
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
	//Changes the count of a letter in the counter array
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
	
	//returns length of array which is equal to the phrase's length
	public int size() {
		return org.length;
	}
	
	//The method below checks if the given LetterInventory is empty
	public static boolean isEmpty(LetterInventory A) {
		if(org.length == 0) {
			return true;
		}
		
		return false;
		
	}
	//The below method converts the LetterInventory into a string
	public String toString() {
		String hl = "[";
		for(Character l : org) {
			hl += l;
		}
		return hl + ']';
	}
	
	
	
	
	//The below method subtracts the current LetterInventory from another LetterInventory allowing for a change in the phrase
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
	
	//The below method adds the current LetterInventory to another LetterInventory allowing for a change in the phrase
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
