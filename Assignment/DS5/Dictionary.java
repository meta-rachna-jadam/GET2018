import java.util.Map;


public interface Dictionary {

    public boolean addKeyValue(String key, String value);
    public boolean removeKeyValue(String key);
    public String getValue(String key);
    public Map<String, String> getSortedListOfKeyValuePair();
    public Map<String, String> getSortedListOfKeyValuePairInBetweenGivenKeyRange(String key1, String key2);
}
