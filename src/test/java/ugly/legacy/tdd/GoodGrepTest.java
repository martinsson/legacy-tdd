package ugly.legacy.tdd;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.PrintStream;

import org.junit.Test;


public class GoodGrepTest {

    @Test
    public void copiesTheFileWhenPatternIsEmptyString() throws Exception {
        
        BufferedReader  inputStream = mock(BufferedReader.class);
        when(inputStream.readLine())
        .thenReturn("Hej")
        .thenReturn("Jag heter Johan och tycker om att programmera tillsammans med kompisar.")
        .thenReturn("Ha det sa bra, vi Hors!!")
        .thenReturn("// Johan")
        .thenReturn(null);
        
        PrintStream printStream = mock(PrintStream.class);
        GoodGrep goodGrep = new GoodGrep(inputStream, printStream);
        goodGrep.grep("");
        
        verify(printStream).println("Hej");
        verify(printStream).println("Jag heter Johan och tycker om att programmera tillsammans med kompisar.");
        verify(printStream).println("Ha det sa bra, vi Hors!!");
        verify(printStream).println("// Johan");
    }
    
    @Test
    public void selectsLinesThatContainTheGivenPattern() throws Exception {
        BufferedReader  inputStream = mock(BufferedReader.class);
        when(inputStream.readLine())
        .thenReturn("Hej")
        .thenReturn("Jag heter Johan och tycker om att programmera tillsammans med kompisar.")
        .thenReturn("Ha det sa bra, vi Hors!!")
        .thenReturn("// Johan")
        .thenReturn(null);
        
        PrintStream printStream = mock(PrintStream.class);
        GoodGrep goodGrep = new GoodGrep(inputStream, printStream);
        goodGrep.grep("Johan");
        
        verify(printStream).println("Jag heter Johan och tycker om att programmera tillsammans med kompisar.");
        verify(printStream).println("// Johan");
    }

}
