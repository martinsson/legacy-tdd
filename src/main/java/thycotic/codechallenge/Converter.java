package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public abstract class Converter {

	private int base;

	public Converter(int base) {
		this.base = base;
	}

	protected long nthPowerOfBase(int n) {
		return round(pow(base,n));
	}

	protected Integer largestExponentOfBaseIn(int i) {
		int exponent = 0;
		int div = i / base;
		while (div > 0) {
			div = div /base;
			exponent++;
		}
		return exponent;
	}

	public String convert(int tenBaseNumber) {
		Integer largestExponent = largestExponentOfBaseIn(tenBaseNumber);
		String result = "";
		long remainder;
		for (int i = largestExponent; i >= 0; i--) {
			remainder = tenBaseNumber % nthPowerOfBase(i+1);
			result += convertSingleDigit(remainder / nthPowerOfBase(i));
		}
		return result;
	}

	protected String convertSingleDigit(long tenBaseNumber) {
		assertLessThanBase(tenBaseNumber);
		if (tenBaseNumber < 10)
			return String.valueOf(tenBaseNumber);
		else {
			return convertToLetter(tenBaseNumber);
		}
	}
	protected abstract String convertToLetter(long tenBaseNumber);

	protected void assertLessThanBase(long tenBaseNumber) {
		if (tenBaseNumber >= base) throw new IllegalArgumentException("no " + base + " base correspondence for " + tenBaseNumber);
	}


}