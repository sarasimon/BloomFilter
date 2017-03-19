package kATA;
public class BloomFilter {

	Dictionary itsDictionary;
	ReadWords itsWordReader;

	public BloomFilter()
	{
		itsDictionary = new ByteArrayDictionary();
	}

	public BloomFilter(ReadWords wordReader, Dictionary dictionary)
	{
		itsWordReader = wordReader;
		itsDictionary = dictionary;
	}

    void initializeWordReader(int method)
	{
		WordReaderFactory wordReaderFactory = new WordReaderFactory();
		itsWordReader = wordReaderFactory.buildReader(method);
		itsWordReader.subscribeListener(itsDictionary);
	}

	void startToRead()
	{
		itsWordReader.readWords();
	}

	public boolean lookUpForWord(String word)
	{
		if (((ByteArrayDictionary)itsDictionary).cellsFilled() > 0)
		{
			if (itsDictionary.existHashValues(word))
				return true;
		}
		return false;
	}







}


