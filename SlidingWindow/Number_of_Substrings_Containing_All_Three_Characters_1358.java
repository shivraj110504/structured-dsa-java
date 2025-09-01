package SlidingWindow;

public class Number_of_Substrings_Containing_All_Three_Characters_1358 {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        
        // Array to store the last seen index of 'a', 'b', and 'c'
        // lastSeen[0] -> last index of 'a'
        // lastSeen[1] -> last index of 'b'
        // lastSeen[2] -> last index of 'c'
        int[] lastSeen = new int[]{-1, -1, -1};

        int cnt = 0; // total count of substrings that contain 'a', 'b', and 'c'

        // Traverse each character in the string
        for (int i = 0; i < n; i++) {
            // Update the last seen index of the current character
            lastSeen[s.charAt(i) - 'a'] = i;

            // Check if we have seen all three characters at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the earliest index among last seen of 'a', 'b', 'c'
                // Any substring starting from index 0..min(lastSeen) and ending at i 
                // will contain all three characters
                cnt += (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }

        return cnt; // Return the total number of valid substrings
    }

    public static void main(String[] args) {
        Number_of_Substrings_Containing_All_Three_Characters_1358 solution = new Number_of_Substrings_Containing_All_Three_Characters_1358();
        String s = "abcabc";
        int result = solution.numberOfSubstrings(s);
        System.out.println("Number of substrings containing all three characters: " + result);
    }
}
