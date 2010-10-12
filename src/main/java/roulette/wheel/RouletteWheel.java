package roulette.wheel;

public class RouletteWheel {

	private final Ball ball;

	public RouletteWheel(Ball ball) {
		this.ball = ball;
	}

	public int rouletteResult() {
		ball.waitForBallToSettle();
		double rouletteResult = randomBetweenZeroAndOne()*(36+1);
		int rouletteResultAsInt = (int)rouletteResult;
		return rouletteResultAsInt;
	}
	
	private double randomBetweenZeroAndOne() {
		return Math.random();
	}
}