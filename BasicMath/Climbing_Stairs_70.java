package BasicMath;

public class Climbing_Stairs_70 {
    public static class Solution {
        public int climbStairs(int n) {
            if (n <= 2)
                return n;
            int fir = 1; // total ways of step 1st
            int sec = 2; // total ways of step 2nd
            for (int i = 3; i <= n; i++) {
                int thr = fir + sec; // total ways of step 3rd
                fir = sec; // swap
                sec = thr; // swap
            }
            return sec; // sec holding latest value of third also.
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(4));  // Output: 5
    }
}
