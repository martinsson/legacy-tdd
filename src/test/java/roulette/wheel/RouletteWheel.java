package roulette.wheel;

public class RouletteWheel {

	public int rouletteResult() {
		double rouletteResult = randomBetweenZeroAndOne()*(36+1);
		int rouletteResultAsInt = (int)rouletteResult;
		return rouletteResultAsInt;
	}
	
	private double randomBetweenZeroAndOne() {
		return Math.random();
	}
}