package roulette.wheel;

import static ch.lambdaj.Lambda.sum;
import static ch.lambdaj.Lambda.sumFrom;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.impl.AvalonLogger;
import org.hamcrest.Matcher;
import org.junit.Test;


public class WhenWeSpinTheWheel {

	@Test
	public void theResultIsRandom() throws Exception {
		double aRandomNumber = randomBetweenZeroAndOne();
		double anotherRandomNumber = randomBetweenZeroAndOne();
		assertThat(aRandomNumber, not(equalTo(anotherRandomNumber)));
	}
	
	@Test
	public void theResultIsBetween0And36() throws Exception {
		List<Integer> randNumbers = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++) {
			double rouletteResult = randomBetweenZeroAndOne()*37;
			int rouletteResultAsInt = (int)rouletteResult;
			randNumbers.add(rouletteResultAsInt);
		}
		assertThat(randNumbers, hasItem(equalTo(36)));
		assertThat(randNumbers, hasItem(equalTo(0)));
		double average = sum(randNumbers).doubleValue()/10000;
		assertThat(average, closeTo(18, 1));
	}
	
	private double randomBetweenZeroAndOne() {
		return Math.random();
	}
	
	
	
}
