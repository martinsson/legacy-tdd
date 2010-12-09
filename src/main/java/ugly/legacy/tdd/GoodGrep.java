package ugly.legacy.tdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class GoodGrep {

    private final BufferedReader inputStream;
    private final PrintStream outputStream;

    public GoodGrep(BufferedReader inputStream, PrintStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void grep(String pattern) throws IOException {
        String currentLine;
        while((currentLine = inputStream.readLine()) != null) {
            if (currentLine.contains(pattern))
                outputStream.println(currentLine);
        }
    }

}
