package SlidingWindow;

public class Binary_Sub_Aray_With_Sum_930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        // Trick: 
        // #subarrays with sum == goal 
        // = #subarrays with sum <= goal − #subarrays with sum <= goal - 1
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    // Helper function: counts number of subarrays with sum <= goal
    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;   // edge case: no subarrays possible if goal is negative

        int l = 0, r = 0;         
        int cnt = 0;              
        int sum = 0;             
        // Expand window with right pointer
        while (r < nums.length) {
            sum += nums[r];       // include nums[r] in the window

            // If window sum exceeds goal, shrink from the left
            while (sum > goal) {
                sum -= nums[l];  
                l++;             
            }

            // At this point, all subarrays ending at index r 
            // and starting from any index in [l..r] are valid
            cnt += (r - l + 1);

            r++;                 
        }

        return cnt;  
    }


    public static void main(String[] args) {
        Binary_Sub_Aray_With_Sum_930 solution = new Binary_Sub_Aray_With_Sum_930();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(solution.numSubarraysWithSum(nums, goal));  // Output: 4
    }
    
}
