package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;

class ThirteenConverter {
	
	String convertSingleDigit(long tenBaseNumber) {
		if (tenBaseNumber < 10) return String.valueOf(tenBaseNumber);
		else if (tenBaseNumber == 10) return "x";
		else if (tenBaseNumber == 11) return "y";
		else if (tenBaseNumber == 12) return "z";
		else throw new IllegalArgumentException("no thirteen base correspondence for " + tenBaseNumber);
	}

	long powerOfThirteen(int n) {
		return round(pow(13,n));
	}
	
	Integer largestExponentOfThirteenIn(int i) {
		int exponent = 0;
		int div = i / 13;
		while (div > 0) {
			div = div /13;
			exponent++;
		}
		return exponent;
	}

	String convert(int tenBaseNumber) {
		Integer largestExponent = largestExponentOfThirteenIn(tenBaseNumber);
		String result = "";
		long remainder;
		for (int i = largestExponent; i >= 0; i--) {
			remainder = tenBaseNumber % powerOfThirteen(i+1);
			result += convertSingleDigit(remainder / powerOfThirteen(i));
		}
		return result;
	}
}