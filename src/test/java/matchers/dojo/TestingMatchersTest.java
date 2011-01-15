package matchers.dojo;

import static ch.lambdaj.Lambda.sum;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintWriter;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


public class TestingMatchersTest {
    
    @Test @Ignore
    public void stringPatterns() throws Exception {
        String helloString = HelpersForTheDojo.generateHelloString();
        assertTrue(helloString.startsWith("hello"));
    }
    
    @Test @Ignore
    public void allPossibleResultsArePresented() throws Exception {
        int numberOfDice = 100;
        List<Integer> manyRolls = new BadDice(numberOfDice).roll();
        assertTrue(manyRolls.containsAll(asList(1, 2, 3, 4, 5, 6)));
    }
    
    @Test @Ignore
    public void aDieRollIsAlwaysBetweenOneAndSix() throws Exception {
        int numberOfDice = 100;
        List<Integer> manyRolls = new BadDice(numberOfDice).roll();
        for (Integer roll : manyRolls) {
            assertTrue(roll >= 1);
            assertTrue(roll <= 6);
        }
    }
    
    @Test @Ignore
    public void diceAreNotWeighted() throws Exception {
        Dice dice = new RoundingDice(1000);
        List<Integer> manyRolls = dice.roll();
        double numberOfRolls = manyRolls.size()*1.0;
        double average = (Integer)sum(manyRolls)/numberOfRolls;
        assertTrue(average < 3.6);
        assertTrue(average > 3.4);
    }
    
    @Test @Ignore
    public void compressesByRemovingExtraWhiteSpaces() throws Exception {
        PrintWriter mockedWriter = mock(PrintWriter.class);
        PrintWriter compressingPrintWriter = new CompressingPrintWriter(mockedWriter );
        compressingPrintWriter.write("Il   y a 3 espaces qui devraient être réduits à une seule" );
        verify(mockedWriter).write(argThat(startsWith("Il y a")));
    }
    
    
}
