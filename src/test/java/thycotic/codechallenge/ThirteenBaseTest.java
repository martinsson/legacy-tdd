package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Ignore;
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
	
	@Test @Ignore("for now") public void oneSevenZeroInTenBaseIs101InThirteenBase() throws Exception {
		assertThat(convert(170), equalTo("101"));
	}
	@Test @Ignore("dont understand the problem yet") public void itHandlesMediumNumbersToo() throws Exception {
		assertThat(convert(5006), equalTo("2381"));
	}
	
	@Test public void oneSevenZeroIsDivable2TimesBy13() throws Exception {
		assertThat(timesDivableBy13(14), equalTo(1));
		assertThat(timesDivableBy13(12), equalTo(0));
		assertThat(timesDivableBy13(170), equalTo(2));
	}
	
	@Test public void exponentNofThirteen() {
		long result = powerOfThirteen(2);
		assertEquals(169, result);
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
		int div = tenBaseNumber / 13;
		int rem = tenBaseNumber % 13;
		if (rem < 10)
			return String.valueOf(10 * div + rem);
		else if (rem == 10) return "x";
		else if (rem == 11) return "y";
		else if (rem == 12) return "z";
		else throw new RuntimeException("not implemented for " + tenBaseNumber);
	}
}
