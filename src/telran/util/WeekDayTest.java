package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekDayTest {
private static String expectedSUN = "Good but not for Israel"; 
private static String expectedSAT = "Good for all";
private static String expectedFRI = "Good for Israel";
private static String expectedOthers = "Regular week day";
@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void weekDaCommenty() {
		assertEquals(expectedSUN, getComment(WeekDay.SUN));
		assertEquals(expectedSAT, getComment(WeekDay.SAT));
		assertEquals(expectedFRI, getComment(WeekDay.FRI));
		assertEquals(expectedOthers, getComment(WeekDay.WED));



	}

	
	 @Test
	 void allValuesTwst() {
		 WeekDay[] days = {WeekDay.SUN, WeekDay.MON, WeekDay.TUE, 
				 WeekDay.WED, WeekDay.THU, WeekDay.FRI, WeekDay.SAT};
		 assertArrayEquals(WeekDay.values(), days);
	 }
	 
	 @Test
	 void valluesOfTest() {
		 assertEquals(WeekDay.FRI, WeekDay.valueOf("FRI"));
		 boolean flException = false;
		 try {
			WeekDay wd = WeekDay.valueOf("KUKU");
		} catch (IllegalArgumentException e) {
			flException = true;
			 System.out.println(e);

		}
		 assertTrue(flException);
	 }
	 
	 @Test
	 void toStringTest() {
		 assertEquals("FRI", WeekDay.FRI.toString());
	 }
	 private String getComment(WeekDay wd) {
			switch(wd){
				case SUN : {
					return expectedSUN;
				}
				case SAT : {
					return expectedSAT;
				}
				
				case FRI : {
					return expectedFRI;
				}
				default  : {
					return expectedOthers;
				}
			}
			
		}
}
