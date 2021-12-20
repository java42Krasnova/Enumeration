package telran.util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LengthTest {
	Length l1_CM = new Length(12.7f, LengthUnit.CM);// 5in
	Length l2_IN = new Length(5f, LengthUnit.IN);// 127mm
	Length l3_KM = new Length(1f, LengthUnit.KM);
	Length l4_FT = new Length(4f, LengthUnit.FT);// 1219.2 mm
	Length l5_M = new Length(10000, LengthUnit.M);
	Length l6_MM = new Length(10000, LengthUnit.MM);
	Length l7_M = new Length(10, LengthUnit.M);

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEqualsObject() {
		// TODO done!
		assertTrue(l1_CM.equals(l2_IN));// 5in == 12,f cm
		assertFalse(l2_IN.equals(l3_KM));// 12,7 cm == 5 in
		assertTrue(l4_FT.equals(new Length(1.2192f, LengthUnit.M)));// 4ft == 1,2192m
		Length l1 = new Length(2.37f, LengthUnit.FT);
		Length l2 = new Length(722.376f, LengthUnit.MM);
		Length l3 = new Length(0.722376f, LengthUnit.M);
		assertTrue(l1.equals(l3));
		assertTrue(l1.equals(l2.convert(LengthUnit.KM)));
		assertTrue(l1.equals(l1));
		assertFalse(l3.equals(l2_IN));
		assertFalse(l1_CM.equals(new Length(12.71f, LengthUnit.CM))); //12.7cm!=12.71cm
	}

	@Test
	void testCompareTo() {
		// TODO done!
		assertTrue(isGreather(l4_FT, l2_IN));// 1219.2 mm > 127mm
		assertFalse(isGreather(l2_IN, l4_FT));
		assertEquals(0, l1_CM.compareTo(l2_IN));// 5in == 12,7 cm
		assertTrue(isGreather(l5_M, l7_M));// 10000m>10m
		assertEquals(0, l2_IN.compareTo(l2_IN));
		assertFalse(isGreather(l1_CM, new Length(12.71f, LengthUnit.CM)));//12.7cm<12.71cm
	}

	private boolean isGreather(Length l1, Length l2) {
		return l1.compareTo(l2) > 0;
	}

	@Test
	void testConvert() {
		// TODO done!
		assertEquals(l1_CM, l2_IN.convert(LengthUnit.CM));// 12.7 cm == 5in
		assertEquals(l2_IN, l1_CM.convert(LengthUnit.IN));// 5in==12.7 cm
		assertEquals(l7_M, l6_MM.convert(LengthUnit.M));// 10 m == 10000mm
	}

	@Test
	void testToString() {
		// TODO done!
		assertEquals("4,00FT", l4_FT.toString());
		System.out.println(l1_CM.toString());// rounded
	}

	@Test
	void testBetween() {
		// TODO done!
		Length exp1 = new Length(1f, LengthUnit.M);// 1 m -> 200 cm 
		assertEquals(exp1, LengthUnit.M.between(new Length(200f, LengthUnit.CM), new Length(1f, LengthUnit.M)));
		Length exp2 = new Length(9000f, LengthUnit.CM); // 10000m -> 1 km
		assertEquals(exp2.amount, LengthUnit.M.between(l5_M, l3_KM).amount, 0.01f);
	}

}
