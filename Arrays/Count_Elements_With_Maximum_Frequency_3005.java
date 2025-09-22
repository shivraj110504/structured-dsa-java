package Arrays;

public class Count_Elements_With_Maximum_Frequency_3005 {
     public int maxFrequencyElements(int[] nums) {
        // Array to count occurrences of each number (constraint: nums[i] <= 100)
        int[] count = new int[101];

        // Tracks the maximum frequency of any element so far
        int maxFreq = 0;

        // Tracks the total number of elements that appear with the maximum frequency
        int total = 0;

        // Iterate over each number in the input array
        for (int num : nums) {
            // Increment the frequency count of this number
            count[num]++;

            // Current frequency of this number
            int freq = count[num];

            // If this number now has a higher frequency than all previous numbers
            if (freq > maxFreq) {
                maxFreq = freq;     // update max frequency
                total = maxFreq;    // reset total to this new frequency
            } 
            // If this number’s frequency matches the current maximum
            else if (freq == maxFreq) {
                total += maxFreq;   // add this frequency to the total
            }
        }

        // Return the sum of frequencies of all elements 
        // that appear with the maximum frequency
        return total;
    }

    public static void main(String[] args) {
        Count_Elements_With_Maximum_Frequency_3005 solution = new Count_Elements_With_Maximum_Frequency_3005();
        int[] nums = {1, 2, 2, 3, 1, 4};
        int result = solution.maxFrequencyElements(nums);
        System.out.println("Total elements with maximum frequency: " + result); // Output: 4
    }
}
