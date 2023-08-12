public class Questoin3a {
    public static int maxPoints(int[] a) {
        int n = a.length;
        int[] paddedArray = new int[n + 2];
        paddedArray[0] = 1;
        System.arraycopy(a, 0, paddedArray, 1, n);
        paddedArray[n + 1] = 1;

        int[][] DP = new int[n + 2][n + 2];

        // Dynamic programming
        for (int len = 1; len<=n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                for (int k = start; k <= end; k++) {
                    DP[start][end] = Math.max(DP[start][end], 
                        DP[start][k - 1] + paddedArray[start - 1] * paddedArray[k] * paddedArray[end + 1] + DP[k + 1][end]);
                }
            }
        }

        return DP[1][n];
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        int[] b = {5, 1, 4, 8, 6};
        int output = maxPoints(a);
        int output2 = maxPoints(b);
        System.out.println(output);  // Output: 167
        System.out.println(output2);
    }
}
