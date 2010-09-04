package thycotic.codechallenge;

class BinaryConverter extends Converter{
	public BinaryConverter() {
		super(2);
	}

	protected String convertSingleDigit(long i) {
		assertLessThanBase(i);
		return String.valueOf(i);
	}
}