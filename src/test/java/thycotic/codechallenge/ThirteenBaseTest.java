package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class ThirteenBaseTest {
	@Test public void fiveInThirteenBaseEqualsFiveInTenBase() throws Exception {
		assertThat(convert(5), equalTo("5"));
	}

	@Test public void tenInTenBaseIsXinThirteenBase() throws Exception {
		assertThat(convert(10), equalTo("x"));
		assertThat(convert(11), equalTo("y"));
		assertThat(convert(12), equalTo("z"));
	}

	@Test public void thirteenInTenBaseIsTenInThirteenBase() throws Exception {
		assertThat(convert(13), equalTo("10"));
	}

	@Test public void twentyInTenBaseIs17InThirteenBase() throws Exception {
		assertThat(convert(20), equalTo("17"));
	}
	
	@Test public void oneSevenZeroInTenBaseIs101InThirteenBase() throws Exception {
		assertThat(convert(170), equalTo("101"));
	}
	@Test public void itHandlesMediumNumbersToo() throws Exception {
		assertThat(convert(5006), equalTo("2381"));
	}
	@Test public void itHandlesLargeNumbersToo() throws Exception {
		assertThat(convert(9999999), equalTo("20z1879"));
	}
	
	@Test public void oneSevenZeroIsDivable2TimesBy13() throws Exception {
		assertThat(timesDivableBy13(14), equalTo(1));
		assertThat(timesDivableBy13(12), equalTo(0));
		assertThat(timesDivableBy13(170), equalTo(2));
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
	
	private Integer timesDivableBy13(int i) {
		int times = -1;
		int div = i;
		while (div > 0) {
			div = div /13;
			times++;
		}
		return times;
	}

	private String convert(int tenBaseNumber) {
		Integer timesDivableBy13 = timesDivableBy13(tenBaseNumber);
		String result = "";
		long remainder;
		for (int i = timesDivableBy13; i >= 0; i--) {
			remainder = tenBaseNumber % powerOfThirteen(i+1);
			result += convertSingleDigit(remainder / powerOfThirteen(i));
		}
		return result;
	}
}
