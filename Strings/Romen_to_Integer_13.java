package Strings;

import java.util.HashMap;

public class Romen_to_Integer_13 {
    public static int romanToInt(String s) {
        // Step 1: Create a map of Roman numerals to their integer values
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        // Step 2: Start from the last character of the string
        // Initialize result with the value of the last Roman numeral
        int result = hm.get(s.charAt(s.length() - 1));

        // Step 3: Traverse the string from right to left (second-last → first)
        for (int i = s.length() - 2; i >= 0; i--) {
        
            // If the current value is less than the value to its right,
            // it means we need to subtract (e.g., IV = 5 - 1 = 4).
            if (hm.get(s.charAt(i)) < hm.get(s.charAt(i + 1))) {
                result = result - hm.get(s.charAt(i));
            } 
            // Otherwise, just add the value (e.g., VI = 5 + 1 = 6).
            else {
                result = result + hm.get(s.charAt(i));
            }
        }

        // Step 4: Return the final computed integer
        return result;
    }


    public static void main(String[] args) {
        String roman = "MCMXCIV";
        int result = romanToInt(roman);
        System.out.println("The integer value of Roman numeral " + roman + " is: " + result);
    }
}
