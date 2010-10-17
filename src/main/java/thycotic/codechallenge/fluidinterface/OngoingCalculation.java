package thycotic.codechallenge.fluidinterface;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class OngoingCalculation {

	private final int base;

	public OngoingCalculation(int base) {
		this.base = base;
	}

	public long exponent(int nextpos) {
		return round(pow(base, nextpos));
	}

	public static OngoingCalculation calculate(int base) {
		return new OngoingCalculation(base);
	}

}
