public class Maximum_Frequency_of_an_Element_After_Performing_Operations_I_3346 {

    class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            int n = 0;
            for (int num : nums) {
                n = Math.max(n, num);
            }

            n++;
            int[] count = new int[n];
            for (int num : nums) {
                count[num]++;
            }

            // total frequency of current window [i - k, i + k]
            int total = 0;
            for (int i = 0; i < Math.min(k, n); i++) {
                total += count[i];
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                // add the right
                if (i + k < n) {
                    total += count[i + k];
                }
                result = Math.max(result, count[i] + Math.min(numOperations, total - count[i]));
                // remove the left
                if (i - k >= 0) {
                    total -= count[i - k];
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 2, 2, 1, 5, 3, 5 };
        int k = 2;
        int numOperations = 3;
        int result = sol.maxFrequency(nums, k, numOperations);
        System.out.println(result);
    }
}
