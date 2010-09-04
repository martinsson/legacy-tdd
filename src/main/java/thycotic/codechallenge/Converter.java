package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public abstract class Converter {

	private int base;

	public Converter(int base) {
		this.base = base;
	}

	protected final long nthPowerOfBase(int n) {
		return round(pow(base,n));
	}

	protected final Integer largestExponentOfBaseIn(int i) {
		int exponent = 0;
		while (nextExponentOfBaseIsLesserThan(i, exponent))
			exponent++;
		return exponent;
	}

	private boolean nextExponentOfBaseIsLesserThan(int i, int exponent) {
		return nthPowerOfBase(exponent + 1) <= i;
	}

	public String convert(int tenBaseNumber) {
		Integer largestExponent = largestExponentOfBaseIn(tenBaseNumber);
		String result = "";
		for (int pos = largestExponent; pos >= 0; pos--) {
			result += nextDigit(tenBaseNumber, pos);
		}
		return result;
	}

	private String nextDigit(int tenBaseNumber, int pos) {
		long remainderOfLastPos = tenBaseNumber % nthPowerOfBase(pos+1);
		return convertSingleDigit(remainderOfLastPos / nthPowerOfBase(pos));
	}

	protected final String convertSingleDigit(long tenBaseNumber) {
		assertLessThanBase(tenBaseNumber);
		if (tenBaseNumber < 10)
			return String.valueOf(tenBaseNumber);
		else {
			return convertToLetter(tenBaseNumber);
		}
	}
	protected abstract String convertToLetter(long tenBaseNumber);

	protected final void assertLessThanBase(long tenBaseNumber) {
		if (tenBaseNumber >= base) throw new IllegalArgumentException("no " + base + " base correspondence for " + tenBaseNumber);
	}


}