package kATA;

public class OutputFactory {

    public static Output buildOutput(int method) {
        if (method == Method.FILE.ordinal())
            return new OutputFileReader();
        else if (method == Method.COMMAND_LINE.ordinal())
            return new OutputCommandLine();
        return null;
    }
}
