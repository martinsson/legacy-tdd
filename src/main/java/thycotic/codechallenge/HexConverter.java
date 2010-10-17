package thycotic.codechallenge;

class HexConverter extends Converter {

	public HexConverter() {
		super(16);
	}

	@Override
	protected String convertToLetter(long tenBaseNumber) {
		switch ((int)tenBaseNumber) {
		case 10: return "a";
		case 11: return "b";
		case 12: return "c";
		case 13: return "d";
		case 14: return "e";
		case 15: return "f";
		default: throw new RuntimeException("cannot convert " + tenBaseNumber + " to a letter");
		}
	}
	
}