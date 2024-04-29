public class MinimumSubsetDiffrence {
    static int SubsetSumDifference(int[] a, int n) {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += a[i];
        }
        boolean dp[][] = new boolean[n][totalSum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= totalSum; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
                if (i > 0 && j > 0) {
                    boolean notTake = dp[i - 1][j];
                    boolean take = false;
                    if (a[i] <= j) {
                        take = dp[i - 1][j - a[i]];
                    }
                    dp[i][j] = notTake || take;
                }

            }
        }

        int min = Integer.MAX_VALUE;
        int s1 = 0, s2 = 0;
        for (int i = 0; i <= totalSum; i++) {
            if (dp[n - 1][i] == true) {
                s1 = i;
                s2 = totalSum - i;
                min = Math.min(min, Math.abs(s2 - s1));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 7 };
        int n = arr.length;
        System.out.println(SubsetSumDifference(arr, n));

    }

}
