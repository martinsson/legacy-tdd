package thycotic.codechallenge;

class OctalConverter extends Converter {

	public OctalConverter() {
		super(8);
	}

	@Override
	protected String convertToLetter(long tenBaseNumber) {
		throw new RuntimeException("cannot happen");
	}
	
}