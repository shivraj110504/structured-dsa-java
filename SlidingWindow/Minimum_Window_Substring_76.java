package SlidingWindow;

import java.util.HashMap;

public class Minimum_Window_Substring_76 {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        // If target string is longer than source, no valid window exists
        if (n < m) return "";

        int l = 0, r = 0; // Left and right pointers for sliding window
        int minLen = Integer.MAX_VALUE; // Minimum window length found so far
        int sIndex = -1; // Starting index of the minimum window substring
        int cnt = 0; // Number of characters from t matched so far

        // HashMap to store frequency of characters in t
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
        }

        // Expand the window with the right pointer
        while (r < n) {
            char ch = s.charAt(r);
            // If current character is in t, decrease its required frequency
            if (hash.containsKey(ch)) {
                hash.put(ch, hash.get(ch) - 1);
                // If after decrement it’s still >= 0, it means we matched one needed char
                if (hash.get(ch) >= 0) cnt++;
            }

            // When all characters of t are matched (cnt == m)
            while (cnt == m) {
                // Update minimum window if current window is smaller
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                // Try shrinking the window from the left
                char left = s.charAt(l);
            if (hash.containsKey(left)) {
                    // Put the character back (increase its count)
                    hash.put(left, hash.get(left) + 1);
                    // If count becomes > 0, that means this character is now missing from window
                    if (hash.get(left) > 0) cnt--;
                }
                l++; // Move left pointer forward
            }

            r++; // Expand the window by moving right pointer
        }

        // If no valid window was found, return ""
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }   

    public static void main(String[] args) {
        Minimum_Window_Substring_76 solution = new Minimum_Window_Substring_76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println("Minimum window substring: " + result); // Expected output: "BANC"
    }
}
