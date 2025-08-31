package SlidingWindow;

public class max_Consecutice_ones_III_1004 {
    public int longestOnes(int[] nums, int k) {
        // Sliding window approach
        int l = 0, r = 0;     // Left and right pointers for the window
        int maxLen = 0;       // Stores the maximum length of valid window
        int zero = 0;         // Count of zeros in the current window

        // Expand the window using the right pointer
        while (r < nums.length) {
            // If current element is 0, increase zero count
            if (nums[r] == 0) zero++;

            // If the window has more than k zeros, shrink it from the left
            if (zero > k) {
                // If the element being removed is zero, decrease zero count
                if (nums[l] == 0) zero--;
                l++;  // Move left pointer forward to shrink window
            }

            // If window is valid (zeros ≤ k), calculate its length
             if (zero <= k) {
                int len = r - l + 1;         // Current window length
                maxLen = Math.max(len, maxLen);  // Update maximum length
            }

            // Move right pointer to expand window
            r++;
        }

        // Return the maximum length of subarray containing at most k zeros
        return maxLen;
    }


    public static void main(String[] args) {
        max_Consecutice_ones_III_1004 obj = new max_Consecutice_ones_III_1004();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = obj.longestOnes(nums, k);
        System.out.println("The maximum length of subarray with at most " + k + " zeros is: " + result);
    }
    
}
