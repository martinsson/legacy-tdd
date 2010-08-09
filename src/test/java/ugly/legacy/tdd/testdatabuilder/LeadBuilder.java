package ugly.legacy.tdd.testdatabuilder;

public class LeadBuilder {

	public Lead build() {
		return new Lead();
	}

	static LeadBuilder aLead() {
		return new LeadBuilder();
	}

}
