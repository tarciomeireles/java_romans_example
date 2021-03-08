package org.profac.tarcio.meireles.romans.test;

import org.profac.tarcio.meireles.romans.Romans;

import junit.framework.TestCase;

public class RomanosTest extends TestCase{
	
	public void testExecute(){
		for (int i = 1; i<=20; i++){
			String roman = Romans.intToRoman(i);
			int number = Romans.romanToInt(roman);
			assertEquals(i, number);
		}
		
		
	}

}
