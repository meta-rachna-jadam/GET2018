package question2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Use to find unique characters in the given string
 * @author Rachna Jadam
 *
 */
public class UniqueCharacters {
	
	/**
	 * Find total number of unique characters in the input string
	 * @param inputString
	 * @return number of unique characters in the input string
	 */
	public static int findUniqueCharacters(String inputString) {
		if (inputString == null) {
			throw new AssertionError("Input string can not be null");
		}
		Set<Character> uniqueCharacters = new HashSet<Character>();
		Set<String> words = new HashSet<String>(Arrays.asList(inputString.toUpperCase().split(" ")));
		for (String word : words) {
			for (int charIndex = 0; charIndex < word.length(); charIndex++) {
				uniqueCharacters.add(word.charAt(charIndex));
			}
		}
		return uniqueCharacters.size();
	}
}
