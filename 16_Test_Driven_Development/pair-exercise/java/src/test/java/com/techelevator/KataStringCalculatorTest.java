package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataStringCalculatorTest {
	@Test
	public void ifStringHasNoNumbersReturnZero() {
		KataStringCalculator kataObject = new KataStringCalculator();
		assertEquals(0, kataObject.add(""));
	}
	
	@Test
	public void If_String_takes_one_number_return_sum() {
		KataStringCalculator kataObject = new KataStringCalculator();
		assertEquals(1, kataObject.add("1"));
	}
	@Test
	public void ifStringHasTwoNumbersReturnTheSum() {
		KataStringCalculator kataObject = new KataStringCalculator();
		assertEquals(5, kataObject.add("2,3"));
	}
	@Test
	public void ifStringHasUnlimitedNumbersReturnSum() {
		KataStringCalculator kataObject = new KataStringCalculator();
		assertEquals(20, kataObject.add("2,3,4,5,6"));
	}
	@Test
	public void ifStringHasDifferentDelimitersAndReturnSum() {
		KataStringCalculator kataObject = new KataStringCalculator();
		assertEquals(20, kataObject.add("2\n3\n4\n5\n6"));
	}
	
}
