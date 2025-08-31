package Strings;

public class Index_of_the_First_Occurrence_in_a_String_28 {
     public static int strStr(String haystack, String needle) {
       int n = haystack.length();  
        int m = needle.length();   

        // Loop over haystack with a sliding window of size "m"
        // We only need to check until (n - m), otherwise substring would go out of bounds
        for (int i = 0; i <= n - m; i++) {

            // Take substring of length m starting at index i
            // Compare it with needle
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
}
