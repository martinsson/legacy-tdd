package thycotic.codechallenge;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
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
		assertEquals(169, converter.nthPowerOfBase(2));
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
	
	/* Other converters
	 * Assert.AreEqual("55", new OctalConverter().Convert(45));
	 * Assert.AreEqual("1f", new HexConverter().Convert(31));
	 */
	@Test 
	public void binaryConverter() throws Exception {
		assertThat(new BinaryConverter().convert(7), equalTo("111"));
	}
	
	@Test
	public void octalConverter() throws Exception {
		assertThat(new OctalConverter().convert(45), equalTo("55"));
	}
	
	@Test 
	public void hexConverter() throws Exception {
		assertThat(new HexConverter().convert(31), equalTo("1f"));
	}
	
	@Test
	public void singleDigitToHexBase() throws Exception {
		HexConverter hexConverter = new HexConverter();
		assertThat(hexConverter.convertSingleDigit(9), equalTo("9"));
		assertThat(hexConverter.convertSingleDigit(10), equalTo("a"));
		assertThat(hexConverter.convertSingleDigit(11), equalTo("b"));
		assertThat(hexConverter.convertSingleDigit(12), equalTo("c"));
		assertThat(hexConverter.convertSingleDigit(13), equalTo("d"));
		assertThat(hexConverter.convertSingleDigit(14), equalTo("e"));
		assertThat(hexConverter.convertSingleDigit(15), equalTo("f"));
	}
	static class HexConverter extends Converter {

		public HexConverter() {
			super(16);
		}

		@Override
		protected String convertSingleDigit(long tenBaseNumber) {
			assertLessThanBase(tenBaseNumber);
			switch ((int)tenBaseNumber) {
			case 10: return "a";
			case 11: return "b";
			case 12: return "c";
			case 13: return "d";
			case 14: return "e";
			case 15: return "f";
			default:
				return String.valueOf(tenBaseNumber);
			}
		}
		
	}
	

}
