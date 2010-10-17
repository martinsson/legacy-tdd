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
		for (int pos = 0; pos <= sizeOfConvertedNumber; pos++) {
			result = nextDigit(tenBaseNumber, pos) + result;
		}
		return result;
	}

	protected final Integer largestExponentOfBaseIn(int tenBaseNumber) {
		double exponentOfBaseEqualingGivenNumber = log(tenBaseNumber)/log(base);
		int largestInteger = (int)exponentOfBaseEqualingGivenNumber;
		return largestInteger;
	}

	private String nextDigit(int tenBaseNumber, int pos) {
		int nextpos = pos+1;
		long remainderOfNextPos = tenBaseNumber % exponent(nextpos).of(base);
		return convertSingleDigit(remainderOfNextPos / exponent(pos).of(base));
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