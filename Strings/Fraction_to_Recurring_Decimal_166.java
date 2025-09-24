package Strings;

import java.util.HashMap;
import java.util.Map;

public class Fraction_to_Recurring_Decimal_166 {
    
    public String fractionToDecimal(int numerator, int denominator) {
        // If numerator is 0, result is always "0"
        if(numerator == 0) return "0";

        // StringBuilder to build the result step by step
        StringBuilder result = new StringBuilder();

        // Check the sign of the result. If numerator * denominator < 0 → negative result
        if((long) numerator * (long)denominator < 0){
            result.append("-");
        }

        // Convert numerator & denominator to positive values (as long to avoid overflow)
        long absNumerator = Math.abs((long)numerator);
        long absDenominator = Math.abs((long)denominator);

        // Append the integer part of the division
        long integerPart = absNumerator / absDenominator;
        result.append(integerPart);

        // Find the remainder after integer division
        long remain = absNumerator % absDenominator;

        // If no remainder → division is exact → return integer result
        if(remain == 0) return result.toString();

        // Otherwise, add the decimal point
        result.append(".");

        // Map to track remainders and their positions in the result string
        // Helps detect repeating cycles in the decimal part
        Map<Long, Integer> map = new HashMap<>();

        // Process fractional part until remainder becomes 0 or cycle is found
        while(remain != 0){
            // If remainder already seen, it means cycle detected
            if(map.containsKey(remain)){
                // Insert "(" at the position where remainder first appeared
                int insertPos = map.get(remain);
                result.insert(insertPos, "(");
                // Append ")" at the end to close repeating cycle
                result.append(")");
                break;
            }

            // Store remainder with its position in result
            map.put(remain, result.length());

            // Multiply remainder by 10 (simulate long division step)
            remain *= 10;

            // Get the next digit of the fractional part
            long digit = remain / absDenominator;
            result.append(digit);

            // Update remainder
            remain %= absDenominator;
        }

        // Return the final fraction result in decimal form
        return result.toString();
    }





// ╔══╦═══╦═╗─╔╦═══╦═══╦═══╗╔═══╦═══╦═══╦════╗
// ╚╣╠╣╔═╗║║╚╗║║╔═╗║╔═╗║╔══╝║╔═╗║╔═╗║╔═╗║╔╗╔╗║
// ─║║║║─╚╣╔╗╚╝║║─║║╚═╝║╚══╗║╚═╝║║─║║╚═╝╠╝║║╚╝
// ─║║║║╔═╣║╚╗║║║─║║╔╗╔╣╔══╝║╔══╣╚═╝║╔╗╔╝─║║
// ╔╣╠╣╚╩═║║─║║║╚═╝║║║╚╣╚══╗║║──║╔═╗║║║╚╗─║║
// ╚══╩═══╩╝─╚═╩═══╩╝╚═╩═══╝╚╝──╚╝─╚╩╝╚═╝─╚╝



//  /$$$$$$  /$$$$$$  /$$   /$$  /$$$$$$  /$$$$$$$  /$$$$$$$$      /$$$$$$$   /$$$$$$  /$$$$$$$  /$$$$$$$$
// |_  $$_/ /$$__  $$| $$$ | $$ /$$__  $$| $$__  $$| $$_____/     | $$__  $$ /$$__  $$| $$__  $$|__  $$__/
//   | $$  | $$  \__/| $$$$| $$| $$  \ $$| $$  \ $$| $$           | $$  \ $$| $$  \ $$| $$  \ $$   | $$   
//   | $$  | $$ /$$$$| $$ $$ $$| $$  | $$| $$$$$$$/| $$$$$ /$$$$$$| $$$$$$$/| $$$$$$$$| $$$$$$$/   | $$   
//   | $$  | $$|_  $$| $$  $$$$| $$  | $$| $$__  $$| $$__/|______/| $$____/ | $$__  $$| $$__  $$   | $$   
//   | $$  | $$  \ $$| $$\  $$$| $$  | $$| $$  \ $$| $$           | $$      | $$  | $$| $$  \ $$   | $$   
//  /$$$$$$|  $$$$$$/| $$ \  $$|  $$$$$$/| $$  | $$| $$$$$$$$     | $$      | $$  | $$| $$  | $$   | $$   
// |______/ \______/ |__/  \__/ \______/ |__/  |__/|________/     |__/      |__/  |__/|__/  |__/   |__/ 



    public static void main(String[] args) {
        Fraction_to_Recurring_Decimal_166 solution = new Fraction_to_Recurring_Decimal_166();
        int numerator = 4;
        int denominator = 333;
        String result = solution.fractionToDecimal(numerator, denominator);
        System.out.println(result); // Output: "0.(012)"
    }
}
