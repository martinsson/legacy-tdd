package roulette.wheel;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import ch.lambdaj.Lambda;

public class WhenWeSpinTheWheel {
    private static final int SUITE_SIZE = 1000000;
    

    @Test
    public void theResultIsNotAlwaysTheSame() throws Exception {
        List<Long> firstSuite = resultSuite(100);
        List<Long> secondSuite = resultSuite(100);
        assertThat(firstSuite, not(equalTo(secondSuite)));
    }

    @Test
    public void theResultIsAnIntegerBetween0and36() throws Exception {
        List<Long> aLongSuite = resultSuite(SUITE_SIZE);
        assertThat(aLongSuite, everyItem((Matcher<Long>) greaterThanOrEqualTo((long)0)));
        assertThat(aLongSuite, everyItem((Matcher<Long>) lessThanOrEqualTo((long)36)));
    }
    
    @Test
    public void theMeanOfALongSuiteIsBetween17and18() throws Exception {
        List<Long> aLongSuite = resultSuite(SUITE_SIZE);
        double mean = (Long)Lambda.sum(aLongSuite) / SUITE_SIZE;
        assertThat(mean, Matchers.closeTo(17.0, 0.4));
    }

    private static long rouletteResult() {
        return (long)(Math.random()*36);
    }

    private static List<Long> resultSuite(int listSize) {
        List<Long> list = new ArrayList<Long>();
        for (int j = 0; j < listSize; j++) {
            list.add(rouletteResult());
        }
        return list;
    }
}
