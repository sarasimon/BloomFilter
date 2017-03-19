package kATA;

import java.awt.event.WindowListener;
import java.io.*;

//Ilias: try using composition over inheritance? how do you test input handler?
public class FileWordReader implements ReadWords{

    private BufferedReader buffer;
    private WordReader wordReader;

    public FileWordReader(WordReader wordReader) {
        this.wordReader = wordReader;
    }

    public void setBuffer(BufferedReader buffer) {
        this.buffer = buffer;
    }

    public void readWords() {
        readFile(wordReader.readWord());
    }

    void readFile(String filename) {
        try {
            if (buffer == null)
                buffer = new BufferedReader(new FileReader(filename));
            readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readLines() throws IOException{
        String fileLine = readOneLine();
        while (fileLine != null) {
            wordReader.setLastWordRead(fileLine);
            fileLine = readOneLine();
        }
    }

    private String readOneLine() throws IOException {
        String line;
        line = buffer.readLine();
        return line;
    }

    public void subscribeListener(WordReaderListener listener){
        wordReader.subscribeListener(listener);
    }

}
