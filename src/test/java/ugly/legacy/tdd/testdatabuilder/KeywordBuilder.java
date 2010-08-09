package ugly.legacy.tdd.testdatabuilder;

class KeywordBuilder {

	private String searchTerm;
	private Lead lead;

	public static KeywordBuilder aKeyword() {
		return new KeywordBuilder();
	}

	public KeywordBuilder withSearchTerm(String string) {
		this.searchTerm = string;
		return this;
	}

	public Keyword build() {
		return new Keyword(searchTerm, lead);
	}

	public KeywordBuilder with(Lead lead) {
		this.lead = lead;
		return this;
	}

	public KeywordBuilder with(LeadBuilder aLead) {
		this.lead = aLead.build();
		return this;
	}
	
}