package Strings;

public class Longest_Common_Prefix_14 {
    public static String longestCommonPrefix(String[] strs) {
       // StringBuilder to store the result (longest common prefix)
        StringBuilder ans = new StringBuilder();

        // Iterate through each character of the first string
        // We assume the common prefix cannot be longer than the first string
        for (int i = 0; i < strs[0].length(); i++) {

            // Take the current character from the first string
            char ch = strs[0].charAt(i);

            // Assume this character is present in all strings
            boolean match = true;

            // Compare this character with the same index of all other strings
            for (int j = 1; j < strs.length; j++) {
                
                // If the current string is shorter than i (index out of bounds),
                // OR the character doesn't match → then it's not a common prefix anymore
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    match = false;
                    break; // stop checking further strings
                }
            }

            // If mismatch found → stop building prefix
            if (!match) {
                break;
            } 
            // If all strings matched at this position → add character to result
            else {
                ans.append(ch);
            }
        }

        // Convert StringBuilder to string and return
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
