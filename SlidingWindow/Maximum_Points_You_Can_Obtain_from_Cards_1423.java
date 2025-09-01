package SlidingWindow;

public class Maximum_Points_You_Can_Obtain_from_Cards_1423 {

     public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0, maxSum = 0;

        // Step 1: Take the first k cards from the left as the initial sum
        for (int i = 0; i <= k - 1; i++) {
            lsum = lsum + cardPoints[i];
        }

        // This is the initial maximum (all k cards taken from the left side)
        maxSum = lsum;

        int rindex = n - 1;  // Pointer for taking cards from the right end

        // Step 2: Slide the "window" by gradually removing cards from the left
        // and adding cards from the right
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i];      // Remove one card from the left side
            rsum = rsum + cardPoints[rindex]; // Add one card from the right side
            rindex = rindex - 1;              // Move right pointer leftward

            // Update the maximum score possible
            maxSum = Math.max(maxSum, lsum + rsum);
        }

        // Step 3: Return the maximum score after considering all splits
        return maxSum;
    }
    
    public static void main(String[] args) {
        Maximum_Points_You_Can_Obtain_from_Cards_1423 solution = new Maximum_Points_You_Can_Obtain_from_Cards_1423();
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int result = solution.maxScore(cardPoints, k);
        System.out.println("Maximum points you can obtain from cards: " + result);
    }
}
