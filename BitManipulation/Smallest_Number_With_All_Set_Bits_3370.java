package BitManipulation;

public class Smallest_Number_With_All_Set_Bits_3370 {

    // Approach 1: Check if number + 1 is power of 2
    public static class Solution {
        private boolean isBitsSet(int x) {
            return (x & (x + 1)) == 0;
        }

        public int smallestNumber(int n) {
            int result = n;
            while (!isBitsSet(result)) {
                result++;
            }
            return result;
        }
    }

    // Approach 2: Bit manipulation
    // public static class Solution {
    //     public int smallestNumber(int n) {
    //         int result = 1;
    //         while (result < n) {
    //             result = 2 * result + 1;
    //         }
    //         return result;
    //     }
    // }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.smallestNumber(5)); // 7
        System.out.println(sol.smallestNumber(8)); // 15
        System.out.println(sol.smallestNumber(1)); // 1
    }
}
