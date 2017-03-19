package kATA;

public class CommandLineWordReader implements ReadWords {

	WordReader wordReader;

	public CommandLineWordReader(WordReader reader)
	{
		wordReader = reader;
	}
	
	public void readWords()
	{
		String wordIn = wordReader.readWord();
		if(!(wordIn.toLowerCase().trim().equals("exit")))
		{
			wordReader.setLastWordRead(wordIn);
			readWords();
		}
	}

	public void subscribeListener(WordReaderListener listener) {
		wordReader.subscribeListener(listener);
	}
}
