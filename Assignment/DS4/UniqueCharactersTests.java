package question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharactersTests {

	@Test
	public void testFindUniqueCharactersItReturnNumberOfUniqueCharactersPresentInGivenString() {
		assertEquals(4, UniqueCharacters.findUniqueCharacters("Hello"));
		assertEquals(4, UniqueCharacters.findUniqueCharacters("Hello Hello"));
		assertEquals(9, UniqueCharacters.findUniqueCharacters("Hello Rachna Hello"));
		assertEquals(4, UniqueCharacters.findUniqueCharacters("Hello                    Hello"));
		assertEquals(4, UniqueCharacters.findUniqueCharacters("Hello hello"));
	}

}
