package thycotic.codechallenge;


class ThirteenConverter extends Converter {
	public ThirteenConverter() {
		super(13);
	}
	
	@Override
	protected String convertSingleDigit(long tenBaseNumber) {
		if (tenBaseNumber < 10) return String.valueOf(tenBaseNumber);
		else if (tenBaseNumber == 10) return "x";
		else if (tenBaseNumber == 11) return "y";
		else if (tenBaseNumber == 12) return "z";
		else throw new IllegalArgumentException("no thirteen base correspondence for " + tenBaseNumber);
	}
}