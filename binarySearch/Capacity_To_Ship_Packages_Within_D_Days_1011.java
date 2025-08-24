package binarySearch;

public class Capacity_To_Ship_Packages_Within_D_Days_1011 {
    class Solution {
    public int sum(int[] weights){
        int sum = 0;
        for(int i = 0; i< weights.length; i++){
            sum += weights[i];
        }
        return sum;
    }
    public int findDays(int[] weights, int capacity){
        int days = 1;
        int maxLoad = 0;
        for(int i = 0; i < weights.length; i++){
            if(maxLoad + weights[i] > capacity){
                days = days + 1;
                maxLoad = weights[i];
            }else{
                maxLoad += weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < weights.length; i++){
            maxi = Math.max(maxi, weights[i]);
        }

        int low = maxi, high = sum(weights);
        while(low <= high){
            int mid = (low + high) / 2;
            int noOfDays = findDays(weights, mid);
            if(noOfDays <= days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}

    public static void main(String[] args) {
        Solution sol = new Capacity_To_Ship_Packages_Within_D_Days_1011().new Solution();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(sol.shipWithinDays(weights, days)); // Output: 9
    }
}
