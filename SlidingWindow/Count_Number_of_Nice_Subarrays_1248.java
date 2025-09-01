
package SlidingWindow;

public class Count_Number_of_Nice_Subarrays_1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        // Exactly k odds = (subarrays with at most k odds) - (subarrays with at most k-1 odds)
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    // Helper function: count subarrays with at most k odd numbers
    private int atMost(int[] nums, int k) {
        if (k < 0) return 0; // No valid subarray if k is negative

        int l = 0, r = 0;   
        int cnt = 0;        
        int sum = 0;      

        while (r < nums.length) {
            // Add nums[r] to the window, convert to 1 if odd, 0 if even
            sum += (nums[r] % 2);

            // If window has more than k odds, shrink from the left
            while (sum > k) {
                sum -= (nums[l] % 2); // remove effect of nums[l]
                l++;                  
            }

            // All subarrays ending at r with valid window count
            // = window size (r - l + 1)
            cnt += (r - l + 1);

            // Expand window
            r++;
        }

        return cnt;
    }


    public static void main(String[] args) {
        Count_Number_of_Nice_Subarrays_1248 solution = new Count_Number_of_Nice_Subarrays_1248();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int result = solution.numberOfSubarrays(nums, k);
        System.out.println("Number of nice subarrays: " + result);  // Expected output: 2
    }
}
