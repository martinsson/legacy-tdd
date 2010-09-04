package thycotic.codechallenge;


class ThirteenConverter extends Converter {
	public ThirteenConverter() {
		super(13);
	}
	
	@Override
	protected String convertToLetter(long tenBaseNumber) {
		if (tenBaseNumber == 10) return "x";
		else if (tenBaseNumber == 11) return "y";
		else if (tenBaseNumber == 12) return "z";
		else throw new RuntimeException("cannot convert " + tenBaseNumber + " to a letter");
	}
}