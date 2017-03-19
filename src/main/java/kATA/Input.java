package kATA;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    Scanner userInput;

    public void setScanner(Scanner pScanner) {
        userInput = pScanner;
    }

    public Scanner getScanner() {
        return userInput;
    }

    public Input() {
        openScanner();
    }

    void openScanner() {
        if (userInput == null)
            userInput = new Scanner(System.in);
    }

    public String readWord() {
        return getScanner().next();
    }

    public int readNumber() {
        return Integer.parseInt(getScanner().next());
    }
}
