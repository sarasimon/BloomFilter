package kATA;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mockito.Mockito.*;

import org.junit.*;

public class InputOutputTesting {

    Input input = new Input();
    WordReader readertest;

    @Test
    public void testInputHelloAndByeReturnsLastWordBye() {
        ByteArrayInputStream in = new ByteArrayInputStream(("Hello\r\nBye\r\nexit").getBytes());
        Scanner scanIn = new Scanner(in);
        input.setScanner(scanIn);
        readertest = new CommandLineWordReader(input);
        readertest.readWords();
        Assert.assertTrue("",readertest.getLastWordRead().equals("Bye"));
    }

    @Test
    public void testCommandLineReaderDoesNotAddExitWordInTheListAndEnds()
    {
        ByteArrayInputStream in = new ByteArrayInputStream(("Hello\r\nBye\r\nexit").getBytes());
        Scanner scanIn = new Scanner(in);
        input.setScanner(scanIn);
        readertest = new CommandLineWordReader(input);
        readertest.readWords();

        Assert.assertTrue("",readertest.wordListSize() == 2);
    }

    @Test
	public void testInitializeWordReaderMethod1InstantiatesCommandLineReader()
	{
        BloomFilter bFilter = new BloomFilter();
        bFilter.initializeWordReader(Method.COMMAND_LINE.ordinal());

        Assert.assertTrue(bFilter.itsWordReader instanceof CommandLineWordReader);
	}

    @Test
    public void testChooseMethodCommandLineInstantiatesCommandLineReader()
    {
        BloomFilter bFilter = new BloomFilter();
        bFilter.initializeWordReader(Method.COMMAND_LINE.ordinal());

        Assert.assertTrue(bFilter.itsWordReader instanceof CommandLineWordReader);
    }

    @Test
    public void testChooseMethodFileInstantiatesFileReader()
    {
        BloomFilter bFilter = new BloomFilter();
        bFilter.initializeWordReader(Method.FILE.ordinal());

        Assert.assertTrue(bFilter.itsWordReader instanceof FileWordReader);
    }

    @Test
	public void testLookUpInBloomFilterCallsWordFoundWhenWordIsAdded() {
        OutputCommandLine mockOutput = mock(OutputCommandLine.class);
        BloomFilter mockBloomFilter = mock(BloomFilter.class);
        when(mockBloomFilter.lookUpForWord("")).thenReturn(true);

        Input mockInput = mock(Input.class);
        when(mockInput.readWord()).thenReturn("");

        BloomStarter bloomStarter = new BloomStarter();
        bloomStarter.itsBloomFilter = mockBloomFilter;
        bloomStarter.itsOutput = mockOutput;
        bloomStarter.itsInput = mockInput;
        bloomStarter.lookUp();

        verify(mockOutput,times(1)).wordFoundMessage();
    }

    @Test
    public void testLookUpInBloomFilterCallsWordNotFoundWhenWordIsNotAdded() {
        OutputCommandLine mockOutput = mock(OutputCommandLine.class);
        BloomFilter mockBloomFilter = mock(BloomFilter.class);
        when(mockBloomFilter.lookUpForWord(anyString())).thenReturn(false);

        Input mockInput = mock(Input.class);
        when(mockInput.readWord()).thenReturn("");

        BloomStarter bloomStarter = new BloomStarter();
        bloomStarter.itsBloomFilter = mockBloomFilter;
        bloomStarter.itsOutput = mockOutput;
        bloomStarter.itsInput = mockInput;
        bloomStarter.lookUp();

        verify(mockOutput,times(1)).wordNotFoundMessage();
    }

}
