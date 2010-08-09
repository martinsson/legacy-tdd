package ugly.legacy.tdd.testdatabuilder;

public class Keyword {

	private String searchTerm;
	private final Lead lead;

	public Keyword(String searchTerm2, Lead lead) {
		searchTerm = searchTerm2;
		this.lead = lead;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	@Override
	public String toString() {
		return "Keyword [searchTerm=" + searchTerm + "]";
	}

	public Lead getLead() {
		return lead;
	}
	
	
}