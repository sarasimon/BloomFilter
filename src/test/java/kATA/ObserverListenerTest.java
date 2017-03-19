package kATA;

import junit.framework.TestCase;
import java.beans.PropertyChangeEvent;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class ObserverListenerTest extends TestCase{

    public void testLastWordReadFiresPropertyChange()
    {
        Dictionary mockDictionary = mock(Dictionary.class);
        WordReader wordReader = new CommandLineWordReader();
        wordReader.subscribeListener(mockDictionary);

        wordReader.setLastWordRead("Hello");

        verify(mockDictionary,times(1)).addHashValues(anyString());
    }

    public void testAdd1WordToListAdds2HashValues()
    {
        ByteArrayDictionary dictionary = new ByteArrayDictionary();
        assertTrue(dictionary.cellsFilled() == 0);

        WordReader wordReader = new CommandLineWordReader();
        wordReader.subscribeListener(dictionary);
        wordReader.setLastWordRead("Hello");

        assertTrue(dictionary.cellsFilled() == dictionary.hashValuesPerWord);
    }

    public void testAdd1WordCommandLineAdds2HashValue()
    {
        ByteArrayDictionary dictionary = new ByteArrayDictionary();
        WordReader wordReader = new CommandLineWordReader();

        Input mockInput = mock(Input.class);
        when(mockInput.readWord()).thenReturn("Hello").thenReturn("exit");
        wordReader.itsInput = mockInput;
        wordReader.subscribeListener(dictionary);
        wordReader.readWords();

        System.out.println(dictionary.cellsFilled());
        assertTrue(dictionary.cellsFilled() == 2);
    }
}
