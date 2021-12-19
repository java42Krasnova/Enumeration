package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	
	@Test
	void convertTest() {
		assertEquals(10000f, WeightUnit.KG.convert(WeightUnit.GR, 10), 0.001f);
	}
	
	@Test
	void compareToTest() {
		assertTrue(WeightUnit.TN.compareTo(WeightUnit.CN ) >0 );
	}

}
