package thycotic.codechallenge;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

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
