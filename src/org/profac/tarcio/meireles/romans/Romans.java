package org.profac.tarcio.meireles.romans;

import java.util.HashMap;
import java.util.Map;

public class Romans {
	
	
	/**
	 * Main method to test
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i<=3999; i++){
			String roman = intToRoman(i);
			int number = romanToInt(roman);
			System.out.println(i + ". " + roman + "=" + number);
		}
	}

    /**
     * Converts a Roman Numeral String to a Hindu-Arabic numeral between 1(I) and 3999(MMMCMXCIX)
     * @param number - hindu-arabic integer numeral
     * @return Roman Numeral as String
     */
    public static int romanToInt(String roman) {
    	if (roman == null || roman.length() == 0) 
    		return 0;
    	
        Map<Character, Integer> dictonary = new HashMap<>();
        dictonary.put('I', 1);
        dictonary.put('V', 5);
        dictonary.put('X', 10);
        dictonary.put('L', 50);
        dictonary.put('C', 100);
        dictonary.put('D', 500);
        dictonary.put('M', 1000);   	    	
         
        int number = 0;
         
        for (int i = 0; i < roman.length(); i++) {
            if (i <= roman.length() - 2 && dictonary.get(roman.charAt(i)) < dictonary.get(roman.charAt(i + 1))) {
                number -= dictonary.get(roman.charAt(i));
            } else {
                number += dictonary.get(roman.charAt(i));
            }
        }
        return number;
    }
    
    /**
     * Converts a Hindu-Arabic numeral to a Roman Numeral String between 1 and 3999
     * 
     * @param number - hindu-arabic integer numeral
     * @return Roman Numeral as String
     */
    public static String intToRoman(int number){
    	if (number <= 0 || number > 3999){
    		System.err.print("Out of range:" + number);
    		return "";
    	}
        StringBuilder sb = new StringBuilder();
        int multiple = 0;
        
        String[] romansDict = new String[] { 
        		"I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C", "CD", "D", "CM", "M" };
        
        int[] arabicsDict = new int[] { 1, 4, 5, 9, 10, 40, 50, 
        		90, 100, 400, 500, 900, 1000 };
        
        for (int i = arabicsDict.length - 1; i >= 0; i--) {
        	multiple = number / arabicsDict[i];
            number %= arabicsDict[i];
            while (multiple > 0) {
                sb.append(romansDict[i]);
                multiple--;
            }
        }
        
        return sb.toString();
    }

}
