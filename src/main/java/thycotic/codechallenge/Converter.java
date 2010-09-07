package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public abstract class Converter {

	private int base;

	public Converter(int base) {
		this.base = base;
	}

	public String convert(int tenBaseNumber) {
		Integer largestExponent = largestExponentOfBaseIn(tenBaseNumber);
		String result = "";
		for (int pos = largestExponent; pos >= 0; pos--) {
			result += nextDigit(tenBaseNumber, pos);
		}
		return result;
	}

	protected final Integer largestExponentOfBaseIn(int tenBaseNumber) {
		int exponent = 0;
		while (exponentOfBaseIsLesserThan(tenBaseNumber, exponent+1))
			exponent++;
		return exponent;
	}

	private boolean exponentOfBaseIsLesserThan(int tenBaseNumber, int exponent) {
		return nthPowerOfBase(exponent) <= tenBaseNumber;
	}
	static class Exponents {

		private final int exponent;

		public Exponents(int exponent) {
			this.exponent = exponent;
		}

		public static Exponents exponent(int exponent) {
			return new Exponents(exponent);
		}

		public Long of(int base) {
			return round(pow(base,exponent));
		}
		
	}
	
	protected final long nthPowerOfBase(int n) {
		return Exponents.exponent(n).of(base);
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