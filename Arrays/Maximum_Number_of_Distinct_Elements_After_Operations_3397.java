package Arrays;

import java.util.Arrays;

public class Maximum_Number_of_Distinct_Elements_After_Operations_3397 {
    
    public static int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int minVal = nums[i] - k;

            if (prev < minVal) {
                prev = minVal;
                count++;
            } else if (prev < nums[i] + k) {
                prev = prev + 1;
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        int result = maxDistinctElements(nums, k);
        System.out.println("Maximum number of distinct elements after operations: " + result);
    }
}
