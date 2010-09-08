package thycotic.codechallenge;

import static java.lang.Math.pow;
import static java.lang.Math.round;

class Exponents {

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