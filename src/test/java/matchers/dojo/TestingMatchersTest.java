package matchers.dojo;

import static ch.lambdaj.Lambda.sum;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.impl.AvalonLogger;
import org.junit.Ignore;
import org.junit.Test;

import ch.lambdaj.Lambda;


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
    
    @Test
    public void diceAreNotWeighted() throws Exception {
        Dice dice = new RoundingDice(1000);
        List<Integer> manyRolls = dice.roll();
        double numberOfRolls = manyRolls.size()*1.0;
        double average = (Integer)sum(manyRolls)/numberOfRolls;
        assertTrue(average < 3.6);
        assertTrue(average > 3.4);
    }
    
    @Test @Ignore
    public void fibonacciNumbers() throws Exception {
//        isTheFibonacciSuite =
//        for (Integer fib : fibonacciNumbers()) {
//            
//        }
//        assertEquals(asList(0, 1, 1, 2, 3, 5, 8, 13, 21), asList(0, 1, 1, 2, 3, 5, 8, 13));
        assertThat(fibonacciSuite(), hasItems(0, 1, 1, 2, 3, 5, 8, 13));
    }

    private List<Integer> fibonacciSuite() {
        return asList(1, 1, 2, 3, 5, 8, 13, 21);
    }
    
    @Test @Ignore
    public void theBoundedFIFOListRemovesTheFistElementSetAcceptsOnlyEntriesThatDoNotAlreadyExist() throws Exception {
        List<String> existingFriends = asList("Celine", "Jean", "Fred", "Hervé");
        BoundedSet<String> boundedSet = new BoundedSet<String>(5, existingFriends);
        boundedSet.add(new String("Jean"));
        String lastItemThatShouldntBeAdded = "Shouldn't be added because out of bounds";
        boundedSet.add(lastItemThatShouldntBeAdded);
        assertThat(boundedSet, hasItem("Jean"));
        assertThat(boundedSet, not(hasItem(lastItemThatShouldntBeAdded)));
        
    }
    
    class BoundedSet<T> extends LinkedList<T> {
        private static final long serialVersionUID = -3624019770373861181L;
        private final int maxSize;

        public BoundedSet(int maxSize, List<T> initialEntries) {
            this.maxSize = maxSize;
            this.addAll(initialEntries);
        }
        
        public boolean add(T e) {
            boolean itemAlreadyExists = false;
            for (T element : this) {
                if (e == element) 
                    itemAlreadyExists = true;
            }
            if (this.contains(e)) 
                return false;
            else return super.add(e);
            
        };
        
    }

}
