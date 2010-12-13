package roulette.wheel;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectDistinct;
import static ch.lambdaj.Lambda.sort;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import ch.lambdaj.Lambda;



public class WhenWeSpinTheWheel {

    @Test
    public void theBallSpinsFor20msecs() throws Exception {
        Roulette roulette = new Roulette(20);
        double before = System.currentTimeMillis();
        roulette.play(); 
        long after = System.currentTimeMillis();
        assertThat(after - before, is(closeTo(21, 1)));
    }
    
    @Test
    public void byDefaultTheBallSpinsFor20seconds() throws Exception {
        Roulette roulette = Roulette.defaultInstance();
        assertThat(roulette.getDelay(), equalTo(20000));
    }
    
    @Test
    public void theResultIsRandom() throws Exception {
        Roulette roulette = new Roulette(0);
        List<Integer> firstSuite = roulette.resultSuite(10000);
        List<Integer> secondSuite = roulette.resultSuite(10000);
        assertThat(firstSuite, not(equalTo(secondSuite)));
    }
    @Test
    public void theResultIsBetween0And36() throws Exception {
        Roulette roulette = new Roulette(0);
        List<Integer> suite = roulette.resultSuite(10000);
        assertThat(suite, everyItem(both(lessThan(37)).and(greaterThanOrEqualTo(0))));
        Collection<Integer> distinctResults = sort(selectDistinct(suite), on(Integer.class).intValue());
        assertThat(distinctResults, hasSize(37));
    }
    
    @Test
    public void allPossibleResultsAppearAtleastOnce() throws Exception {
        Roulette roulette = new Roulette(0);
        List<Integer> suite = roulette.resultSuite(10000);
        Collection<Integer> distinctResults = sort(selectDistinct(suite), on(Integer.class).intValue());
        assertThat(distinctResults, hasSize(37));
        
    }

    static class Roulette {
        int delay;
        private Random random = new Random();

        public Roulette(int millisecondsB4BallStops) {
            delay = millisecondsB4BallStops;
        }

        protected Integer getDelay() {
            return delay;
        }

        public static Roulette defaultInstance() {
            return new Roulette(20000);
        }

        public int play() {
            waitForBallToStop();
            return random.nextInt(37);
        }

        private void waitForBallToStop() {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        List<Integer> resultSuite(int listSize) {
            List<Integer> results = new ArrayList<Integer>();
            for (int i = 0; i < listSize; i++) {
                results.add(play());
            }
            return results;
        }
        
    }

}
