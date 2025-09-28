package BitManipulation;

public class bitwise_or_of_even_numbers_in_an_array_3688 {
    public int evenNumberBitwiseORs(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 0){
                res = res | nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        bitwise_or_of_even_numbers_in_an_array_3688 solution = new bitwise_or_of_even_numbers_in_an_array_3688();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int result = solution.evenNumberBitwiseORs(nums);
        System.out.println("Bitwise OR of even numbers: " + result);
    }
}
