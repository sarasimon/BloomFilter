package kATA;

import junit.framework.TestCase;

public class DictionaryTest extends TestCase {

    ByteArrayDictionary dictionary;

    public void setUp() {
        dictionary = new ByteArrayDictionary();
    }

    public void testGetHashValueReturnsEmptyWhenStringIsEmpty() {
        long[] testArray = dictionary.hashValuesOf("");

        for (int i = 0; i < testArray.length; i++) {
            assertTrue(testArray[i] == 0);
        }
    }

    public void testToHashValueReturnsNotZero() {
        long[] testArray = dictionary.hashValuesOf("hello goodbye and hello");

        for (int i = 0; i < testArray.length; i++) {
            assertTrue(testArray[i] != 0);
        }
    }

    public void testAddWordChangesValueToOneInByteArray() {
        long[] testArray = dictionary.hashValuesOf("hello goodbye and hello");
        dictionary.addHashValues("hello goodbye and hello");

        for (int i = 0; i < testArray.length; i++) {
            int arrayIndex = (int) testArray[i];
            assertTrue(dictionary.byteArrayWrapper.isByteSetTo1(arrayIndex));
        }
    }

    public void testDoesNotExistsHashValues() {
        assertFalse(dictionary.existHashValues("hello goodbye and hello"));
    }

    public void testExistsHashValues() {
        dictionary.addHashValues("hello goodbye and hello");
        assertTrue(dictionary.existHashValues("hello goodbye and hello"));
    }
}