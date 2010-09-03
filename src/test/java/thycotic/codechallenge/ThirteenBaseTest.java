package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class ThirteenBaseTest {
	@Test public void numbersLesserThanTenDontChange() throws Exception {
		assertThat(convert(5), equalTo("5"));
	}

	@Test public void tenConvertsToX() throws Exception {
		assertThat(convert(10), equalTo("x"));
	}

	@Test public void elevenConvertsToY() throws Exception {
		assertThat(convert(11), equalTo("y"));
	}
	@Test public void twelveConvertsToZ() throws Exception {
		assertThat(convert(12), equalTo("z"));
	}
	@Test public void thirteenConvertsToTen() throws Exception {
		assertThat(convert(13), equalTo("10"));
	}

	@Test public void twentyConvertsToSeventeen() throws Exception {
		assertThat(convert(20), equalTo("17"));
	}
	
	@Test public void oneSevenZeroConvertsTo101() throws Exception {
		assertThat(convert(170), equalTo("101"));
	}
	@Test public void itHandlesMediumNumbers() throws Exception {
		assertThat(convert(5006), equalTo("2381"));
	}
	@Test public void itHandlesReallyLargeNumbers() throws Exception {
		assertThat(convert(9999999), equalTo("20z1879"));
	}
	
	@Test public void returnsTheLargestExponentOfThirteenThatIsLesserThanOrEqualToTheGivenNumber() throws Exception {
		assertThat(largestExponentOfThirteenIn(12), equalTo(0));
		assertThat(largestExponentOfThirteenIn(13), equalTo(1));
		assertThat(largestExponentOfThirteenIn(170), equalTo(2));
	}
	
	@Test public void exponentTwoOfThirteenIs169() {
		assertEquals(169, powerOfThirteen(2));
	}
	
	@Test public void convertSingleDigitToThirteenBase() {
		assertThat(convertSingleDigit(5), equalTo("5"));
		assertThat(convertSingleDigit(10), equalTo("x"));
		assertThat(convertSingleDigit(11), equalTo("y"));
		assertThat(convertSingleDigit(12), equalTo("z"));
	}

	private String convertSingleDigit(long l) {
		if (l < 10) return String.valueOf(l);
		else if (l == 10) return "x";
		else if (l == 11) return "y";
		else if (l == 12) return "z";
		else throw new IllegalArgumentException("no thirteen base correspondence for " + l);
	}

	private long powerOfThirteen(long n) {
		return round(pow(13,n));
	}
	
	private Integer largestExponentOfThirteenIn(int i) {
		int times = -1;
		int div = i;
		while (div > 0) {
			div = div /13;
			times++;
		}
		return times;
	}

	private String convert(int tenBaseNumber) {
		Integer timesDivableBy13 = largestExponentOfThirteenIn(tenBaseNumber);
		String result = "";
		long remainder;
		for (int i = timesDivableBy13; i >= 0; i--) {
			remainder = tenBaseNumber % powerOfThirteen(i+1);
			result += convertSingleDigit(remainder / powerOfThirteen(i));
		}
		return result;
	}
}
