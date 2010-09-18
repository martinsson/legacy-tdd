package thycotic.codechallenge;

import static java.lang.Math.log;
import static thycotic.codechallenge.Exponents.exponent;

public abstract class Converter {

	private int base;

	public Converter(int base) {
		this.base = base;
	}

	public String convert(int tenBaseNumber) {
		Integer sizeOfConvertedNumber = largestExponentOfBaseIn(tenBaseNumber);
		String result = "";
		for (int pos = sizeOfConvertedNumber; pos >= 0; pos--) {
			result += nextDigit(tenBaseNumber, pos);
		}
		return result;
	}

	protected final Integer largestExponentOfBaseIn(int tenBaseNumber) {
		return (int)(log(tenBaseNumber)/log(base));
	}

	private String nextDigit(int tenBaseNumber, int pos) {
		int lastPos = pos+1;
		long remainderOfLastPos = tenBaseNumber % exponent(lastPos).of(base);
		long nextDigitInTenBase = remainderOfLastPos / exponent(pos).of(base);
		return convertSingleDigit(nextDigitInTenBase);
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