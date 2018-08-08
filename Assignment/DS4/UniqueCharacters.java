package question2;

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
		int result = 0;
		Set<Character> uniqueCharacters = new HashSet<Character>();
		HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
		String words[] = inputString.toUpperCase().split(" ");
		for (int charIndex = 0; charIndex < words[0].length(); charIndex++) {
			uniqueCharacters.add(words[0].charAt(charIndex));
		}
		result += uniqueCharacters.size();
		stringMap.put(words[0], uniqueCharacters.size());
		for (int index = 1; index < words.length; index++) {
			if (stringMap.containsKey(words[index])) {
				continue;
			}
			uniqueCharacters.removeAll(uniqueCharacters);
			for (int charIndex = 0; charIndex < words[index].length(); charIndex++) {
				uniqueCharacters.add(words[index].charAt(charIndex));
			}
			stringMap.put(words[index], uniqueCharacters.size());
			result += uniqueCharacters.size();	
		}
		return result;
	}
}
