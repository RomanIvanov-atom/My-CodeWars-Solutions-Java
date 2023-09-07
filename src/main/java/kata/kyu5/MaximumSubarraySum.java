package kata.kyu5;

public class MaximumSubarraySum {
    public static int sequence(int[] arr) {

        if (arr.length == 0) {    // Empty list is considered to have zero greatest sum
            return 0;
        }


        int count = 0;
        for (int x : arr) {     // If the list is made up of only negative numbers, return 0 instead

            if (x < 0) {
                count++;
            } else {
                break;
            }

            if (count == arr.length) return 0;
        }


        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentSum < 0) {
                currentSum = arr[i];
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
