package ugly.legacy.tdd.testdatabuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static ugly.legacy.tdd.testdatabuilder.KeywordBuilder.aKeyword;
import static ugly.legacy.tdd.testdatabuilder.LeadBuilder.aLead;

import org.junit.Test;


public class SomeTest {

	@Test
	public void usingATestDataBuilder() throws Exception {
		Keyword keyword = 
			aKeyword()
			.withSearchTerm("canon eos")
			.build();
		assertThat(keyword, hasProperty("searchTerm", equalTo("canon eos")));
	}
	
	@Test
	public void settingTwoAttributes() throws Exception {
		Keyword keyword = 
			aKeyword()
			.withSearchTerm("coolpix")
			.with(new Lead())
			.build();
		assertThat(keyword.getSearchTerm(), equalTo("coolpix"));
		assertThat(keyword.getLead(), notNullValue());
	}
	
	@Test
	public void buildersCanBeImbricatedByChainingThem() throws Exception {
		Keyword keyword = 
			aKeyword()
			.with(aLead())
			.build();
		assertThat(keyword.getLead(), instanceOf(Lead.class));
		
	}
}
