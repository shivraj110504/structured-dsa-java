package Arrays;

public class Compute_Alternating_Sum_3701 {
    public static class Solution {
        public int alternatingSum(int[] nums) {
            int n = nums.length;
            int total = 0;
            if (n == 1)
                return nums[0];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    total += nums[i];
                } else {
                    total -= nums[i];
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 3,  5, 7 };
        System.out.println(sol.alternatingSum(nums));  // Output: -4
    }
}
