package commands;

import java.util.ArrayList;
import java.util.List;

public class Word {

	private char[] chars;

	public Word(char[] chars) {
		this.chars = chars;
	}

	public Word(List<Character> chars) {
		this.chars = new char[chars.size()];
		for(int i = 0; i < chars.size(); i++) {
			this.chars[i] = chars.get(i).charValue();
		}
	}

	public static List<Word> splitToWords(char[] chars) {
		List<Character> tempWord = new ArrayList<Character>();
		List<Word> words = new ArrayList<Word>();
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == ' ' || i == chars.length-1) {
				words.add(new Word(tempWord));
				tempWord.clear();
			} else {
				tempWord.add(chars[i]);
			}
		}
		return words;
	}
	
	public String getString() {
		String word = "";
		for(int i = 0; i < chars.length; i++) {
			word += chars[i];
		}
		return word;		
	}

}
