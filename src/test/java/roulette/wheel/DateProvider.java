package roulette.wheel;

import java.util.Calendar;

public class DateProvider {

	private final Calendar calendar;

	public DateProvider(Calendar calendar) {
		this.calendar = calendar;
	}

	public boolean isWeekend() {
		return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
		;
	}

}
