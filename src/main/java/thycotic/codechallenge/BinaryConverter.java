package thycotic.codechallenge;

class BinaryConverter extends Converter{
	public BinaryConverter() {
		super(2);
	}

	@Override
	protected String convertToLetter(long tenBaseNumber) {
		throw new RuntimeException("cannot happen");
	}
	
}