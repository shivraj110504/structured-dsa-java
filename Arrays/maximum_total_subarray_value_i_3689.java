package Arrays;

public class maximum_total_subarray_value_i_3689 {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];

        for(int i = 0; i< n;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        long diff = max - min;
        return diff * k;
    }


    public static void main(String[] args) {
        maximum_total_subarray_value_i_3689 solution = new maximum_total_subarray_value_i_3689();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        long result = solution.maxTotalValue(nums, k);
        System.out.println("Maximum total subarray value: " + result);
    }
}
