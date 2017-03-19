package kATA;

public class WordReaderFactory {

    public static ReadWords buildReader(int methodValue) {
        Method method = Method.values()[methodValue];
        switch (method)
        {
            case COMMAND_LINE:
                return new CommandLineWordReader(new WordReader());
            case FILE:
                return new FileWordReader(new WordReader());
            default:
                return null;
        }
    }
}
