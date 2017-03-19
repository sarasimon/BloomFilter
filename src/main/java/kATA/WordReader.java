package kATA;

import java.util.ArrayList;

public class WordReader{

    Input itsInput;
    ArrayList<String> itsWordList;
    ArrayList<WordReaderListener> listeners;
    String lastWordRead;

    public ArrayList<String> getItsWordList() {
        if (itsWordList == null)
            itsWordList = new ArrayList<String>();
        return itsWordList;
    }

    public String getLastWordRead() {
        return lastWordRead;
    }

    public void setLastWordRead(String newWord) {
        lastWordRead = newWord;
        for (WordReaderListener listener: listeners) {
            listener.addHashValues(newWord);
        }
        getItsWordList().add(newWord);
    }

    public void subscribeListener(WordReaderListener listener) {
        listeners.add(listener);
    }

    public WordReader() {
        itsInput = new Input();
        listeners = new ArrayList<WordReaderListener>();
    }

    int wordListSize() {
        return itsWordList.size();
    }

    public String readWord() {
        return itsInput.readWord();
    }
}
