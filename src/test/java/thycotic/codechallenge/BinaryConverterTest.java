package thycotic.codechallenge;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class BinaryConverterTest {

	@Test
	public void convertSingleDigitToTwoBase() throws Exception {
		assertThat(convertSingleDigitToTwoBase(0), equalTo("0"));
		assertThat(convertSingleDigitToTwoBase(1), equalTo("1"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void acceptsNothingHigherThanOne () throws Exception {
		convertSingleDigitToTwoBase(2);
	}

	private String convertSingleDigitToTwoBase(int i) {
		return new BinaryConverter().convertSingleDigit(i);
	}
}
