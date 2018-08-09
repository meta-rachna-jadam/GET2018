import java.io.File;
import java.io.FileReader;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WordDictionaryImplementationUsingBinarySearchTree {

	JSONObject jsonObject;
	WordDictionary wordDictionaryInstance;

	public WordDictionaryImplementationUsingBinarySearchTree(String filePath) {
		
		File file = null;
		try {

			file = new File(filePath);

			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject) parser.parse(new FileReader(file));
			wordDictionaryInstance = new WordDictionary(jsonObject);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	public boolean addNode(String key, String value) {
		if (wordDictionaryInstance == null || key == null || value == null) {
			return false;
		}
		return wordDictionaryInstance.addKeyValue(key, value);
	}

	public boolean deleteKey(String key) {
		if (wordDictionaryInstance == null || key == null ) {
			return false;
		}
		return wordDictionaryInstance.removeKeyValue(key);
	}

	public String getValue(String key) throws AssertionError {
		if (wordDictionaryInstance == null) {
			throw new AssertionError("JSON file path is not correct");
		}else if (key == null) {
			throw new AssertionError("Key can not be null");
		}else {
		    return wordDictionaryInstance.getValue(key);
		}
	}

	public Map<String, String> getSortedListOfKeyValuePair() throws AssertionError {
		if (wordDictionaryInstance == null) {
			throw new AssertionError("JSON file path is not correct");
		}
		return wordDictionaryInstance.getSortedListOfKeyValuePair();
	}

	public Map<String, String> getSortedListOfKeyValuePairInBetweenGivenKeyRange(
			String key1, String key2) throws AssertionError {
		return wordDictionaryInstance
				.getSortedListOfKeyValuePairInBetweenGivenKeyRange(key1, key2);
	}
}
