package thycotic.codechallenge;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;


public class ThirteenBaseTest {
	@Test public void fiveInThirteenBaseEqualsFiveInTenBase() throws Exception {
		int fiveInTenBase = 5;
		assertThat(convert(fiveInTenBase), equalTo("5"));
	}

	@Test public void tenInTenBaseIsXinThirteenBase() throws Exception {
		int x = 10;
		assertThat(convert(x), equalTo("x"));
	}

	@Test public void thirteenInTenBaseIsTenInThirteenBase() throws Exception {
		int x = 13;
		assertThat(convert(x), equalTo("10"));
	}

	private String convert(int tenBaseNumber) {
		if (tenBaseNumber < 10)
			return String.valueOf(tenBaseNumber);
		else if (tenBaseNumber == 10) return "x";
		else if (tenBaseNumber == 13) return "10";
		else throw new RuntimeException("not implemented");
	}
}
