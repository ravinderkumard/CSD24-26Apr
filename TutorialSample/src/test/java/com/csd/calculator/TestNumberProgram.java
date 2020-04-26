package com.csd.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestNumberProgram {
	
	NumberProgram objNumber;
	
	@Before
	public void setup(){
		objNumber = new NumberProgram();
	}
	
	@After
	public void cleanUp(){
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFindGreaterNumber(){
		int expectedValue = 6;
		int actualValue = (int) objNumber.findGreaterNumber(5,6);
		assertEquals(expectedValue,actualValue,0);
		
		double expectedFloatValue = 5.6;
		double actualFloatValue = objNumber.findGreaterNumber(5.6, 5.5);
		
		assertEquals(expectedFloatValue,actualFloatValue,0);
		
		double expectedDoubleValue = 5.5;
		double actualDoubleValue = objNumber.findGreaterNumber(5.5, 5.5);
		
		assertEquals(expectedDoubleValue,actualDoubleValue,0);
		
		int expectedNegativeNumber = -1;
		int actualNegativeNumber = (int)objNumber.findGreaterNumber(-99, -1);
		assertEquals(expectedNegativeNumber,actualNegativeNumber,0);
		
		long expectedBigNumber = 999999999;
		long actualBigNumber = (long)objNumber.findGreaterNumber(999999999, 999999998);
		assertEquals(expectedBigNumber,actualBigNumber);
	
		double expectedDecimalNumber = 0.111111111111111111111111111111111111111111111111111111111111111111111111111111111;
		double actualDecimalNumber = objNumber.findGreaterNumber(0.111111111111111111111111111111111111111111111111111111111111111111111111111111111,0.111111111111111111111111111111111111111111111111111111111111111111111111111111110);
		
		assertEquals(expectedDecimalNumber,actualDecimalNumber,0);
		
	}
}
