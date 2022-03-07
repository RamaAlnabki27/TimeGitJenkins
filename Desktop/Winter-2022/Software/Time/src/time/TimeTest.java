package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly" , seconds == 18305);
	}
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class , () -> {Time.getTotalSeconds("10:00");}) ;
	}
	@Test
	void testGetTotalSecondsBoundry() {
		int seconds = Time.getTotalSeconds("00:00:05");
		assertTrue("The seconds were not calculated properly" , seconds == 5);
	}

	
	
	
	
	@ParameterizedTest
	@ValueSource(strings = {"00:00:05" , "15:15:05" , "23:59:05"})
	void testGetSeconds(String candidate) {
		int seconds = Time.getSeconds(candidate);
		assertTrue("The seconds were not calculated properly" , seconds == 5 );
	}

	
	
	
	
	
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("05:05:05");
		assertTrue("The minutes were not calculated properly" , minutes == 5 );
	}
	@Test
	void testGetTotalMinutesBoundry1() {
		int minutes = Time.getTotalMinutes("00:05:00");
		assertTrue("The minutes were not calculated properly" , minutes == 5);
	}
	@Test
	void testGetTotalMinutesBoundry2() {
		int minutes = Time.getTotalMinutes("23:05:59");
		assertTrue("The minutes were not calculated properly" , minutes == 5);
	}

	@ParameterizedTest
	@ValueSource(strings = {"05:00:00:05" , "05:15:15:05" , "05:59:59:05"})
	void testGetTotalMilliSeconds(String candidate) {
		int milliSeconds = Time.getTotalMilliSeconds(candidate);
		assertTrue("The milliseconds were not calculated properly" , milliSeconds == 5);
	}
	
	
	
	@ParameterizedTest
	@ValueSource(strings = {"05:00:00" , "05:15:15" , "05:59:59"})
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly" , hours == 5 );
	}

}
