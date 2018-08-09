import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class WordDictionary implements Dictionary {

	private BinarySearchTree binarySearchTreeInstance;
	
	public WordDictionary(JSONObject jsonObject) {
		binarySearchTreeInstance = new BinarySearchTree();
		JSONArray inputArray = (JSONArray) jsonObject.get("addData");

		for (int i = 0; i < inputArray.size(); i++) {
			JSONArray entry = (JSONArray) inputArray.get(i);
			String key = (String) entry.get(0);
			String value = (String) entry.get(1);
			//System.out.println(key);
			addKeyValue(key, value);
		}
	}
	
    @Override
    public boolean addKeyValue(String key, String value) throws AssertionError {
    	if (key == null || value == null) {
    		throw new AssertionError("Key and value can not be null");
    	}
        return binarySearchTreeInstance.insert(key, value);
    }

    @Override
    public boolean removeKeyValue(String key) throws AssertionError {
    	if (key == null) {
    		throw new AssertionError("Key can not be null");
    	}
        return binarySearchTreeInstance.deleteKey(key);
    }

    @Override
    public String getValue(String key) throws AssertionError {
    	if (key == null) {
    		throw new AssertionError("Key can not be null");
    	}
    	Map<String, String> listOfKeyValuePairs = getSortedListOfKeyValuePair();
    	if (listOfKeyValuePairs.containsKey(key)) {
    		return listOfKeyValuePairs.get(key);
    	}
        return null;
    }

    @Override
    public Map<String, String> getSortedListOfKeyValuePair() {
        return binarySearchTreeInstance.getSortedKeyList();
    }

    @Override
    public Map<String, String> getSortedListOfKeyValuePairInBetweenGivenKeyRange(String key1, String key2) throws AssertionError {
    	if (key1 == null || key2 == null) {
    		throw new AssertionError("Keys can not be null");
    	}
    	Map<String, String> result = new LinkedHashMap<String, String>();
    	for (Map.Entry<String, String> mapEntry : getSortedListOfKeyValuePair().entrySet()) {
    		if (mapEntry.getKey().compareToIgnoreCase(key1) >= 0 && mapEntry.getKey().compareToIgnoreCase(key2) <= 0) {
    			result.put(mapEntry.getKey(), mapEntry.getValue());
    		}
    	}
        return result;
    }
}
