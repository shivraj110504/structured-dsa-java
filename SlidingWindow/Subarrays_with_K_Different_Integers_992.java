package SlidingWindow;

import java.util.HashMap;

public class Subarrays_with_K_Different_Integers_992 {
     public int subarraysWithKDistinct(int[] nums, int k) {
        // Number of subarrays with exactly k distinct numbers
        // = (at most k distinct) - (at most k-1 distinct)
        return subArr(nums, k) - subArr(nums, k - 1);
    }

    private int subArr(int[] nums, int k) {
        int l = 0, r = 0, cnt = 0; // l = left pointer, r = right pointer, cnt = total subarrays count
        HashMap<Integer, Integer> mpp = new HashMap<>(); // frequency map for elements in current window

        while (r < nums.length) {
            // Add nums[r] to the window
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);

            // If window has more than k distinct numbers, shrink from the left
            while (mpp.size() > k) {
                mpp.put(nums[l], mpp.get(nums[l]) - 1); // decrease frequency of left element
                if (mpp.get(nums[l]) == 0) {           // if frequency becomes 0, remove it
                    mpp.remove(nums[l]);
                }
                l++; // move left pointer
            }

            // All subarrays ending at r with at most k distinct = (r - l + 1)
            cnt += (r - l + 1);
            r++; // expand right pointer
        }

        return cnt; 
    }


    public static void main(String[] args) {
        Subarrays_with_K_Different_Integers_992 solution = new Subarrays_with_K_Different_Integers_992();
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        int result = solution.subarraysWithKDistinct(nums, k);
        System.out.println("Number of subarrays with exactly " + k + " distinct integers: " + result);
    }
}
