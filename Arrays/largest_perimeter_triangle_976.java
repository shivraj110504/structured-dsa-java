package Arrays;

import java.util.Arrays;

public class largest_perimeter_triangle_976 {
     public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);   // Step 1: Sort the sides (ascending order)

        for(int i = nums.length - 1; i >= 2; i--){   // Step 2: Check from largest side
            // Step 3: Triangle condition
            if(nums[i] < nums[i-1] + nums[i-2]) 
                return nums[i] + nums[i-1] + nums[i-2]; // valid triangle perimeter
        }

        return 0;  // Step 4: No valid triangle
    }


    public static void main(String[] args) {
        largest_perimeter_triangle_976 solution = new largest_perimeter_triangle_976();
        int[] nums = {2,1,2};
        int result = solution.largestPerimeter(nums);
        System.out.println("Largest Perimeter: " + result);
    }
}
