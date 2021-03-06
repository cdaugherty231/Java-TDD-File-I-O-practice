package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataNumbersToWordsTest {
	
	@Test
	public void ifOneDigitNumberReturnAmountInWords() {
		KataNumbersToWords kataObject = new KataNumbersToWords();
		Assert.assertEquals("three", kataObject.numbersToWords(3));
	}
}
