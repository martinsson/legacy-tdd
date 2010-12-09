package ugly.legacy.tdd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class Grep {

    private final String inputFile;
    private final String outPutFile;

    public Grep(String inputFile, String outPutFile) {
        this.inputFile = inputFile;
        this.outPutFile = outPutFile;
    }

    public void grep(String pattern) throws FileNotFoundException {
        Scanner inputScanner = new Scanner(new File(inputFile));
        PrintWriter writer = new PrintWriter(new File(outPutFile));
        while (inputScanner.hasNext()) {
            String line = inputScanner.next();
            writer.println(line );
        }
        writer.close();
    }

}
