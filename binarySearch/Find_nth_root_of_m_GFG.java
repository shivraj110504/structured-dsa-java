package binarySearch;

public class Find_nth_root_of_m_GFG {
    public static int nthRoot(int m, int n){
        int low = 1, high = m;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if (Math.pow(m, n) == mid){
                return mid;
            }else if(Math.pow(m, n) < mid){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int m = 16;
        int n = 4;
        System.out.println(nthRoot(m, n));
        // Output: 2
        m = 27;
        n = 3;
        System.out.println(nthRoot(m, n));  
        // Output: 3
        m = 81;
        n = 4;
        System.out.println(nthRoot(m, n));
        // Output: 3
    }
}
