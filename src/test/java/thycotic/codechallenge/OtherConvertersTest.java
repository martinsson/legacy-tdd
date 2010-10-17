package thycotic.codechallenge;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class OtherConvertersTest {
	/* Other converters
	 * Assert.AreEqual("55", new OctalConverter().Convert(45));
	 * Assert.AreEqual("1f", new HexConverter().Convert(31));
	 */
	@Test 
	public void binaryConverter() throws Exception {
		assertThat(new BinaryConverter().convert(7), equalTo("111"));
	}
	
	@Test
	public void octalConverter() throws Exception {
		assertThat(new OctalConverter().convert(45), equalTo("55"));
	}
	
	@Test 
	public void hexConverter() throws Exception {
		assertThat(new HexConverter().convert(31), equalTo("1f"));
	}
	
	@Test
	public void singleDigitToHexBase() throws Exception {
		HexConverter hexConverter = new HexConverter();
		assertThat(hexConverter.convertSingleDigit(9), equalTo("9"));
		assertThat(hexConverter.convertSingleDigit(10), equalTo("a"));
		assertThat(hexConverter.convertSingleDigit(11), equalTo("b"));
		assertThat(hexConverter.convertSingleDigit(12), equalTo("c"));
		assertThat(hexConverter.convertSingleDigit(13), equalTo("d"));
		assertThat(hexConverter.convertSingleDigit(14), equalTo("e"));
		assertThat(hexConverter.convertSingleDigit(15), equalTo("f"));
	}
	


}
