package BasicMath;

public class Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers_1317 {
    public int[] getNoZeroIntegers(int n) {
        for(int a = 1; a < n; a++){
            int b = n - a;
            if(isNotZero(a) && isNotZero(b)){
                return new int[]{a,b};
            }
        }
        return new int[]{};
    }
    private boolean isNotZero(int n){
        while(n > 0){
            if(n % 10 == 0)return false;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers_1317 obj = new Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers_1317();
        int[] result = obj.getNoZeroIntegers(101);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // Expected output: [2, 99] or any other valid pair
    }
}
