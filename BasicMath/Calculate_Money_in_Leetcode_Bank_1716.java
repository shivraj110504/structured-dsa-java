package BasicMath;

public class Calculate_Money_in_Leetcode_Bank_1716 {

    public static class Solution {
        public int totalMoney(int n) {
            int total = 0;
            int week = 0;

            while (n > 0) {
                for (int day = 0; day < 7 && n > 0; day++) {
                    total += week + day + 1;
                    n--;
                }
                week++;
            }

            return total;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalMoney(10));  // output = 37
        System.out.println(solution.totalMoney(20));  // output = 96
        System.out.println(solution.totalMoney(30));  // output = 171
    }
}
