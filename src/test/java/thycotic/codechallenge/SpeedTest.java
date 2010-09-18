package thycotic.codechallenge;

import static org.junit.Assert.*;

import org.junit.Test;
import static thycotic.codechallenge.Exponents.exponent;

public class SpeedTest {

	private static final int BASE = 13;
	private static final int EXP = 17;
	private static final int NB_EXECUTIONS = 1000000;

	@Test
	public void fluentInterface() throws Exception {
		Do work = new Do() {
			public void doIt() {
				exponent(EXP).of(BASE);
			}
		};
		doTimes(NB_EXECUTIONS, work);
	}
	@Test
	public void notSameIntegerAllTheTime() throws Exception {
		for (int j = 0; j < NB_EXECUTIONS; j++) {
			exponent(j).of(2);
		}
	}
	@Test
	public void notSameIntegerAllTheTimeJavaUtilMath() throws Exception {
		for (int j = 0; j < NB_EXECUTIONS; j++) {
			Math.pow(2, j);
		}
	}
	@Test
	public void standardJavaUtilMath() throws Exception {
		Do work = new Do() {
			public void doIt() {
				Math.pow(BASE, EXP);
			}
		};
		doTimes(NB_EXECUTIONS, work);
	}
	
	private void doTimes(int i, Do work) {
		for (int j = 0; j < i; j++) {
			work.doIt();
		}
	}

	interface Do {
		void doIt();
	}
}
