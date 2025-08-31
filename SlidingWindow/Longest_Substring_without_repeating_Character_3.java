package SlidingWindow;

import java.util.HashMap;

public class Longest_Substring_without_repeating_Character_3 {
    public static   int lengthOfLongestSubstring(String s) {
        int n = s.length();
    
        // Left and right pointers for the sliding window
        int l = 0, r = 0;
    
        // Stores the maximum length of substring found so far
        int maxLen = 0;
    
        // HashMap to store the last index of each character seen
        // Key = character, Value = last index where it appeared
        HashMap<Character, Integer> hash = new HashMap<>(255);

        // Iterate using right pointer
        while (r < n) {
            char c = s.charAt(r);

        // If current character already exists in map AND
            // its last occurrence is inside the current window
            if (hash.containsKey(c) && hash.get(c) >= l) {
                // Move the left pointer just after the last occurrence
                l = hash.get(c) + 1;
            }

            // Update the last seen index of current character
            hash.put(c, r);

            // Current window length = (right - left + 1)
            int len = r - l + 1;

            // Update maximum length
            maxLen = Math.max(len, maxLen);

            // Expand the window by moving right pointer
            r++;
        }

        // Return the length of the longest substring without repeating characters
        return maxLen;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }

}
