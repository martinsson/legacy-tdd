package ugly.legacy.tdd;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;

public class GrepTest {

    @Test
    public void copiesTheFileWhenPatternIsEmptyString() throws Exception {
        String outPutFile = "src/test/ressources/output.txt";
        String inputFile = "src/test/ressources/sample.txt";
        Grep grep = new Grep(inputFile, outPutFile);
        grep.grep("");
         
        areSameFiles(inputFile, outPutFile);
    }
    
    @Test
    public void selectsLinesThatContainTheGivenPattern() throws Exception {
        String outPutFile = "src/test/ressources/output.txt";
        String expectedOutput = "src/test/ressources/johanOutput.txt";
        String inputFile = "src/test/ressources/sample.txt";
        
        Grep grep = new Grep(inputFile, outPutFile);
        grep.grep("Johan");
        
        areSameFiles(expectedOutput, outPutFile);
            
    }

    private void areSameFiles(String inputFile, String outPutFile) throws FileNotFoundException {
        Scanner outputscanner = new Scanner(new File(outPutFile));
        Scanner inputscanner = new Scanner(new File(inputFile));

        boolean areSame = true;
        while(outputscanner.hasNextLine() && inputscanner.hasNextLine()) {
            String inputLine = inputscanner.nextLine();
            String outputLine = outputscanner.nextLine();
            areSame &= inputLine.equals(outputLine);
        }
        
        assertTrue(outputscanner.hasNextLine() == inputscanner.hasNextLine());
        assertTrue(areSame);
    }
    
    
}
