package ugly.legacy.tdd;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


public class GrepTest {

    @Test
    public void copiesTheFileWhenPatternIsEmptyString() throws Exception {
        String outPutFile = "src/test/ressources/output.txt";
        String inputFile = "src/test/ressources/sample.txt";
        Grep grep = new Grep(inputFile, outPutFile);
        grep.grep("");
         
        Scanner outputscanner = new Scanner(new File(outPutFile));
        Scanner inputscanner = new Scanner(new File(inputFile));

        boolean areSame = true;
        while(outputscanner.hasNext() && inputscanner.hasNext()) {
            String inputLine = inputscanner.next();
            String outputLine = outputscanner.next();
            areSame &= inputLine.equals(outputLine);
        }
        
        assertTrue(outputscanner.hasNext() == inputscanner.hasNext());
        assertTrue(areSame);
    }
    
    
    
}
