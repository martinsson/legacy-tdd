package roulette.wheel;

public class Ball {

	private int spinTime;

	public Ball(int spinTime) {
		this.spinTime = spinTime;
	}

	public Ball() {
		spinTime = 20000;
	}

	public Ball(DateProvider dateProvider) {
		if (dateProvider.isWeekend()) {
			spinTime = 10000;
		} else {
			spinTime = 20000;
		}
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
