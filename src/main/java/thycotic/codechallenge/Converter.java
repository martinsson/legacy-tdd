package thycotic.codechallenge;

import static thycotic.codechallenge.Exponents.exponent;

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
		return exponent(exponent).of(base) <= tenBaseNumber;
	}
	private String nextDigit(int tenBaseNumber, int pos) {
		int lastPos = pos+1;
		long remainderOfLastPos = tenBaseNumber % exponent(lastPos).of(base);
		return convertSingleDigit(remainderOfLastPos / exponent(pos).of(base));
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

	private final void assertLessThanBase(long tenBaseNumber) {
		if (tenBaseNumber >= base) throw new IllegalArgumentException("no " + base + " base correspondence for " + tenBaseNumber);
	}


}