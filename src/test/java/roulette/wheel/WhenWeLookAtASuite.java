package roulette.wheel;

import static ch.lambdaj.Lambda.sum;
import static ch.lambdaj.Lambda.sumFrom;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.Mockito;


public class WhenWeLookAtASuite {

	@Test
	public void theResultIsRandom() throws Exception {
		int repetitions = 1000;
		List<Integer> oneSuite = rouletteResults(repetitions);
		List<Integer> anotherSuite = rouletteResults(repetitions);
		assertThat(oneSuite, not(equalTo(anotherSuite)));
	}
	
	@Test
	public void theResultIsBetween0And36() throws Exception {
		int repetitions = 10000;
		List<Integer> randNumbers = rouletteResults(repetitions);
		assertThat(randNumbers, hasItem(equalTo(36)));
		assertThat(randNumbers, hasItem(equalTo(0)));
	}
	
	@Test
	public void theAverageIs18() throws Exception {
		int repetitions = 100000;
		List<Integer> randNumbers = rouletteResults(repetitions );
		double average = sum(randNumbers).doubleValue()/repetitions;
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
	public void theDefaultSpinTimeIs20s() throws Exception {
		Ball ball = new Ball();
		assertThat(ball.getSpinTime(), equalTo(20000));
	}
	
	@Test
	public void onWeekEndsTheBallSpinsOnly10s() throws Exception {
		DateProvider dateProvider = mock(DateProvider.class);
		when(dateProvider.isWeekend()).thenReturn(true);
		Ball ball = new Ball(dateProvider);
		assertThat(ball.getSpinTime(), equalTo(10000));
	}
	
	@Test
	public void onWeekDaysTheBallSpins20s() throws Exception {
		DateProvider dateProvider = mock(DateProvider.class);
		when(dateProvider.isWeekend()).thenReturn(false);
		Ball ball = new Ball(dateProvider);
		assertThat(ball.getSpinTime(), equalTo(20000));
	}

	@Test
	public void returnsTrueWhenWeAreSaturdayAndSunday() throws Exception {
		Calendar calendar = mock(Calendar.class);
		when(calendar.get(Mockito.anyInt())).thenReturn(Calendar.SATURDAY);
		DateProvider dateProvider = new DateProvider(calendar);
		assertThat(dateProvider.isWeekend(), is(true));
	}
	
	public static void main(String[] args) {
		new RouletteWheel(new Ball(new DateProvider(Calendar.getInstance())));
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
