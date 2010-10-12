package roulette.wheel;

public class Ball {

	private final int spinTime;

	public Ball(int spinTime) {
		this.spinTime = spinTime;
	}

	public Ball() {
		spinTime = 20000;
	}

	public void waitForBallToSettle() {
		try {
			Thread.sleep(spinTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getSpinTime() {
		return spinTime;
	}

}
