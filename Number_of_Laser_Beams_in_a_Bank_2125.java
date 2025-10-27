public class Number_of_Laser_Beams_in_a_Bank_2125 {
    public static class Solution {
        public int numberOfBeams(String[] bank) {
            int prev = 0;
            int ans = 0;

            for (String row : bank) {
                int cur = 0;
                for (char c : row.toCharArray()) {
                    if (c == '1')
                        cur++;
                }

                if (cur > 0) {
                    ans += prev * cur;
                    prev = cur;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] bank1 = {"011001","000000","010100","001000"};
        System.out.println(sol.numberOfBeams(bank1)); // 8

        String[] bank2 = {"000","111","000"};
        System.out.println(sol.numberOfBeams(bank2)); // 0
    }
}
