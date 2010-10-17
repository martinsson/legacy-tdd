package thycotic.codechallenge;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static thycotic.codechallenge.OngoingCalculation.calculate;

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
		Long oneHundredSixtyNine = Long.valueOf(169);
		assertThat(calculate(13).exponent(2), is(oneHundredSixtyNine));
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
		return converter.largestExponentOfBaseIn(i);
	}
	private String convert(int tenBaseNumber) {
		return converter.convert(tenBaseNumber);
	}
	

}
