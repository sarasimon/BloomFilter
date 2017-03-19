package kATA;

public class BloomStarter {

    BloomFilter itsBloomFilter;
    Output itsOutput;
    Input itsInput;

    public BloomStarter()
    {
        itsInput = new Input();
    }

    public void start(){
        chooseMethod();
        readEnteredWords();
        lookUp();
    }

    void chooseMethod() {
        System.out.println("Choose input method: ");
        System.out.println(Method.FILE.ordinal() + " - File ");
        System.out.println(Method.COMMAND_LINE.ordinal() + " - Commmand Line ");

        itsBloomFilter = new BloomFilter();
        OutputFactory outputFactory = new OutputFactory();

        int method = itsInput.readNumber();
        itsBloomFilter.initializeWordReader(method);
        itsOutput = outputFactory.buildOutput(method);
    }

    void readEnteredWords()
    {
        itsOutput.enterWordReaderMessage();
        itsBloomFilter.startToRead();
    }

    void lookUp() {
        itsOutput.lookForWordMessage();
        String lookUpWord = itsInput.readWord();

        if (itsBloomFilter.lookUpForWord(lookUpWord))
            itsOutput.wordFoundMessage();
        else
            itsOutput.wordNotFoundMessage();
    }
}
