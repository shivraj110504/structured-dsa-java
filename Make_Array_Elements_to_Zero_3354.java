public class Make_Array_Elements_to_Zero_3354 {

    public static class Solution {
        public int countValidSelections(int[] nums) {
            int n = nums.length;
            int valid = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] != 0)
                    continue;

                if (simulate(nums.clone(), i, 1))
                    valid++;
                if (simulate(nums.clone(), i, -1))
                    valid++;
            }

            return valid;
        }

        private boolean simulate(int[] arr, int curr, int dir) {
            int n = arr.length;
            while (curr >= 0 && curr < n) {
                if (arr[curr] == 0) {
                    curr += dir;
                } else {
                    arr[curr]--;
                    dir = -dir;
                    curr += dir;
                }
            }

            for (int val : arr)
                if (val != 0)
                    return false;

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1,0,2,0,3};
        System.out.println(sol.countValidSelections(nums1)); // 2

        int[] nums2 = {2,3,4,0,4,1,0};
        System.out.println(sol.countValidSelections(nums2)); // 0

        int[] nums3 = {4, 0, 2, 3};
        System.out.println(sol.countValidSelections(nums3)); // 1
    }
}
