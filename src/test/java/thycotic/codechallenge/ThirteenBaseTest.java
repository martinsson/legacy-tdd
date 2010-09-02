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
		if (tenBaseNumber < 10)
			return String.valueOf(rem);
		else if (tenBaseNumber == 10) return "x";
		else if (tenBaseNumber == 11) return "y";
		else if (tenBaseNumber == 12) return "z";
		else if (tenBaseNumber == 13) return String.valueOf(10*div);
		else throw new RuntimeException("not implemented for " + tenBaseNumber);
	}
}
