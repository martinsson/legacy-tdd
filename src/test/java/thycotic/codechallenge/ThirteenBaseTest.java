package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class ThirteenBaseTest {
	ThirteenConverter converter = new ThirteenConverter();
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
		assertEquals(169, converter.powerOfThirteen(2));
	}
	

	@Test public void convertSingleDigitToThirteenBase() {
		assertThat(convertSingleDigit(5), equalTo("5"));
		assertThat(convertSingleDigit(10), equalTo("x"));
		assertThat(convertSingleDigit(11), equalTo("y"));
		assertThat(convertSingleDigit(12), equalTo("z"));
	}

	
	private String convertSingleDigit(long tenBaseNumber) {
		return converter.convertSingleDigit(tenBaseNumber);
	}
	private Integer largestExponentOfThirteenIn(int i) {
		return converter.largestExponentOfThirteenIn(i);
	}
	private String convert(int tenBaseNumber) {
		return converter.convert(tenBaseNumber);
	}


	static class ThirteenConverter {
		
		private String convertSingleDigit(long tenBaseNumber) {
			if (tenBaseNumber < 10) return String.valueOf(tenBaseNumber);
			else if (tenBaseNumber == 10) return "x";
			else if (tenBaseNumber == 11) return "y";
			else if (tenBaseNumber == 12) return "z";
			else throw new IllegalArgumentException("no thirteen base correspondence for " + tenBaseNumber);
		}
	
		private long powerOfThirteen(int n) {
			return round(pow(13,n));
		}
		
		private Integer largestExponentOfThirteenIn(int i) {
			int exponent = 0;
			int div = i / 13;
			while (div > 0) {
				div = div /13;
				exponent++;
			}
			return exponent;
		}
	
		private String convert(int tenBaseNumber) {
			Integer largestExponent = largestExponentOfThirteenIn(tenBaseNumber);
			String result = "";
			long remainder;
			for (int i = largestExponent; i >= 0; i--) {
				remainder = tenBaseNumber % powerOfThirteen(i+1);
				result += convertSingleDigit(remainder / powerOfThirteen(i));
			}
			return result;
		}
	}
}
