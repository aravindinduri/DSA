public class EqualSumPartion {
    static boolean isPartion(int[] a, int sum) {
        boolean dp[][] = new boolean[a.length + 1][sum + 1];
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
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
        return dp[n - 1][sum];

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3,5, 8 };
        int TotalSum = 0;
        boolean isPartion = false;
        for (int i : arr)
            TotalSum += i;
        if (TotalSum / 2 != 0)
            isPartion = false;
        TotalSum = TotalSum / 2;
         isPartion = isPartion(arr, TotalSum) ;
        System.out.println(isPartion);
    }

}
