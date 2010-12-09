package ugly.legacy.tdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            if (line.contains(pattern))
                writer.println(line );
        }
        writer.close();
        inputScanner.close();
    }

}
