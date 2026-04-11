public class SlidingWindow {
    public static void main(String[] args) {
        //solve optimized sliding window problem
        int arr[] = {5, 2, -1, 0, 3, 6, 1, -2};
        int k = 3;
        int n = arr.length;
        int maxSum = MaxSum.maxSum(arr, n, k);
        System.out.println(maxSum);
    }
}
