package binarySearch;

public class koko_Eating_Banana_875 {
    class Solution {
    private int findMax(int[] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxi = Math.max(arr[i], maxi);
        }
        return maxi;
    }
    public int findHr(int[] arr, int hourly){
        int totalTime = 0;
        for(int i = 0; i < arr.length; i++){
            totalTime += Math.ceil((double) arr[i] /(double) hourly);
        }
        return totalTime;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = findMax(piles);
        while(low <= high){
            int mid = (low + high) / 2;

            int totalHr = findHr(piles, mid);
            
            if(totalHr <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}

public static void main(String[] args) {
    Solution sol = new koko_Eating_Banana_875().new Solution();
    int[] piles = {3, 6, 7, 11};
    int h = 8;
    System.out.println(sol.minEatingSpeed(piles, h)); // Output: 4
}
}
