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
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import org.apache.commons.logging.impl.AvalonLogger;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.Mockito;


public class WhenWeLookAtASuite {
	private static int REPETITIONS = 10000;

	@Test
	public void theResultIsRandom() throws Exception {
		List<Integer> oneSuite = rouletteResults(REPETITIONS);
		List<Integer> anotherSuite = rouletteResults(REPETITIONS);
		assertThat(oneSuite, not(equalTo(anotherSuite)));
	}
	
	@Test
	public void theResultIsBetween0And36() throws Exception {
		List<Integer> randNumbers = rouletteResults(REPETITIONS);
		assertThat(randNumbers, hasItem(equalTo(36)));
		assertThat(randNumbers, hasItem(equalTo(0)));
	}
	
	@Test
	public void theAverageIs18() throws Exception {
		List<Integer> randNumbers = rouletteResults(REPETITIONS);
		double average = sum(randNumbers).doubleValue()/REPETITIONS;
		assertThat(average, closeTo(18, 0.1));
	}
	
	@Test
	public void weWaitForTheBallToStopBeforeDisclosingTheResult() throws Exception {
		Ball ball = Mockito.mock(Ball.class);
		RouletteWheel wheel = new RouletteWheel(ball);
		wheel.rouletteResult();
		Mockito.verify(ball).waitForBallToSettle();
	}
	
	@Test
	public void aBallRollsAWhileBeforeItStops() throws Exception {
		Ball ball = new Ball(200);
		long before = System.currentTimeMillis();
		ball.waitForBallToSettle();
		long after = System.currentTimeMillis();
		Long timeElapsed = after - before;
		assertThat("elapsed time", timeElapsed.doubleValue(), closeTo(200, 10));
	}
	
	@Test
	public void theDefaultSpinTime() throws Exception {
		Ball ball = new Ball();
		assertThat(ball.getSpinTime(), equalTo(20000));
	}
	

	private List<Integer> rouletteResults(int quantity) {
		RouletteWheel rouletteWheel = new RouletteWheel(new Ball(0));
		List<Integer> randNumbers = new ArrayList<Integer>();
		for (int i = 0; i < quantity; i++) {
			randNumbers.add(rouletteWheel.rouletteResult());
		}
		return randNumbers;
	}
	
	
	
}
