import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WordDictionaryImplementationUsingBinarySearchTreeTests {

	WordDictionaryImplementationUsingBinarySearchTree wordDictionary;

	@Before
	public void initialization() {
		wordDictionary = new WordDictionaryImplementationUsingBinarySearchTree(
				"F:\\applet\\Data Structure 5\\src\\DictionaryData.json");
	}

	@Test
	public void testAddNodesUsingJSONToAddNodesInBSTreeItReturnTrueIfAddSuccessfully() {
		System.out.println(wordDictionary.addNode("rag",
				"a newspaper, typically one regarded as being of low quality"));
	}

	@Test
	public void testDeleteKeyToDeleteNodesFromBSTreeItReturnTrueIfRemoveSuccessfully() {
		assertTrue(wordDictionary.deleteKey("phobia"));
	}

	@Test
	public void testGetValueToGetNodesFromBSTreeForSpesificKeyItReturnValueOfTheKey() {
		System.out.println(wordDictionary.getValue("Zag"));
		assertEquals(
				"an angular shape characterized by sharp turns in alternating directions",
				wordDictionary.getValue("Zag"));
	}
	
	@Test
	public void testGetSortedListOfKeyValuePairReturnSortedListOfKey() {
		Object expectedOutput[] = {"aback", "Brexit", "leverage", "phobia", "URL", "Zag"};
		Object[] actualOutput = wordDictionary.getSortedListOfKeyValuePair().keySet().toArray();
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGetSortedListOfKeyValuePairInBetweenGivenKeyRangeReturnSortedListOfKeyInBetweenGivenKeys() {
		Object expectedOutput[] = {"aback", "Brexit", "leverage"};
		Object[] actualOutput = wordDictionary.getSortedListOfKeyValuePairInBetweenGivenKeyRange("a", "m").keySet().toArray();
		assertArrayEquals(expectedOutput, actualOutput);
	}
}
