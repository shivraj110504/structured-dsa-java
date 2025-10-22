import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class String_After_Applying_Operations_1625 {
    
    class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> vis = new HashSet<>();
        String smallest = s;
        Deque<String> q = new ArrayDeque<>();
        q.offer(s);
        vis.add(s);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(smallest) < 0) smallest = cur;

            StringBuilder sb = new StringBuilder(cur);
            for (int i = 1; i < sb.length(); i += 2)
                sb.setCharAt(i, (char) ((sb.charAt(i) - '0' + a) % 10 + '0'));
            String added = sb.toString();
            if (vis.add(added)) q.offer(added);

            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (vis.add(rotated)) q.offer(rotated);
        }
        return smallest;
    }
}


    public static void main(String[] args) {
        Solution sol = new String_After_Applying_Operations_1625().new Solution();
        String s = "5525";
        int a = 9;
        int b = 2;
        String result = sol.findLexSmallestString(s, a, b);
        System.out.println(result);
    }
}
