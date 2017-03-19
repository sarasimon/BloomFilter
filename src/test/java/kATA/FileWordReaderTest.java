package kATA;

import static org.junit.Assert.*;

import java.io.*;
import org.junit.Test;


public class FileWordReaderTest {

	FileWordReader inputFile;

	//Ilias: in JUnit4 you can test exceptions with this annotation.
    //try catch in tests is usually a bad idea and can bring to invalid results
    @Test(expected=FileNotFoundException.class)
    public void testOpenFileIsFalseWhenFileNotFoundExceptionIsThrownNew() throws Exception
    {
        inputFile = new FileWordReader(wordReader);
        inputFile.setBuffer(new BufferedReader(new FileReader("")));
    }

    @Test
	public void testOpenFileIsTrueWhenNoExceptionIsThrown()
	{
		inputFile = new FileWordReader(wordReader);
		inputFile.setBuffer(new BufferedReader(new StringReader("line1\rline2\rline3\r")));
		assertTrue(inputFile.openFile(""));
	}

    @Test
	public void testWordListHasSize3IfFileContains3Lines()
	{
		inputFile = new FileWordReader(wordReader);
		inputFile.setBuffer(new BufferedReader(new StringReader("line1\rline2\rline3\r")));
		inputFile.readFile("filepath");
		assertTrue(inputFile.wordListSize() == 3);
	}
}
