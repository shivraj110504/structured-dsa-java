package SlidingWindow;

import java.util.HashMap;

public class Longest_Repeating_Character_Replacement_424 {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hash = new HashMap<>(26); // store char frequencies
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;

        while (r < s.length()) {
            char c = s.charAt(r);

            // add current character to frequency map
            hash.put(c, hash.getOrDefault(c, 0) + 1);

            // update max frequency of any character in window
            maxFreq = Math.max(maxFreq, hash.get(c));

            // shrink window if replacements needed > k
            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                hash.put(leftChar, hash.get(leftChar) - 1); // decrement count
                l++; // move left pointer
            }

            // update maximum valid window size
            maxLen = Math.max(maxLen, r - l + 1);

            // expand window
            r++;
        }

        return maxLen;
    }



    public static void main(String[] args) {
        Longest_Repeating_Character_Replacement_424 solution = new Longest_Repeating_Character_Replacement_424();
        System.out.println(solution.characterReplacement("AABABBA", 1)); // Output: 4
    }

}
