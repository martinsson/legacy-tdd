package thycotic.codechallenge;

class BinaryConverter extends Converter{
	public BinaryConverter() {
		super(2);
	}

	protected String convertSingleDigit(long i) {
		if (i>1) throw new IllegalArgumentException("no thirteen base correspondence for " + i);
		return String.valueOf(i);
	}
}