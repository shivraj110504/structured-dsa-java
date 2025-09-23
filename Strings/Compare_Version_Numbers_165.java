package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// Using StringTokenizer

public class Compare_Version_Numbers_165 {
     public int compareVersion(String version1, String version2) {
        // Split version strings into tokens (substrings separated by '.')
        List<String> v1 = getTokens(version1);
        List<String> v2 = getTokens(version2);

        int m = v1.size(); // number of tokens in version1
        int n = v2.size(); // number of tokens in version2
        int i = 0;

        // Compare tokens one by one
        while (i < m || i < n) {
            // If one version has fewer tokens, treat missing tokens as 0
            int a = i < m ? Integer.parseInt(v1.get(i)) : 0;
            int b = i < n ? Integer.parseInt(v2.get(i)) : 0;

            // Compare the numeric values of corresponding tokens
            if (a > b) {
                return 1;  // version1 > version2
            } else if (b > a) {
                return -1; // version1 < version2
            } else {
                // If equal, move to the next token
                i++;
            }
        }

        // All tokens are equal → versions are the same
        return 0;
    }

    // Helper method: split version string into tokens by "."
    private List<String> getTokens(String version) {
        StringTokenizer tokenizer = new StringTokenizer(version, ".");
        List<String> versionTokens = new ArrayList<>();

        // Extract all tokens and add them to the list
        while (tokenizer.hasMoreTokens()) {
            versionTokens.add(tokenizer.nextToken());
        }

        return versionTokens;
    }






    // using Split() function

    //  public int compareVersion(String version1, String version2) {
    //     List<String> v1 = getTokens(version1);
    //     List<String> v2 = getTokens(version2);
        
    //     int m = v1.size();
    //     int n = v2.size();
        
    //     int i = 0;
    //     while (i < m || i < n) {
    //         int a = i < m ? Integer.parseInt(v1.get(i)) : 0;
    //         int b = i < n ? Integer.parseInt(v2.get(i)) : 0;
            
    //         if (a > b)
    //             return 1;
    //         else if (b > a)
    //             return -1;
    //         else
    //             i++;
    //     }
    //     return 0;
    // }
    
    // private List<String> getTokens(String version) {
    //     String[] tokens = version.split("\\.");             -------> only change in this line
    //     List<String> versionTokens = new ArrayList<>();
    //     for (String token : tokens) {
    //         versionTokens.add(token);
    //     }
    //     return versionTokens;
    // }


    public static void main(String[] args) {
        Compare_Version_Numbers_165 solution = new Compare_Version_Numbers_165();
        String version1 = "1.01";
        String version2 = "1.001";
        int result = solution.compareVersion(version1, version2);
        System.out.println("Comparison result: " + result); // Output: 0 (versions are equal)
    }
}
