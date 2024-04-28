
// RECURSION

// public class SubsetSum {
//     static boolean isSubsetSum(int[] a, int n, int ind) {
//         if (n == 0) {
//             return true;
//         }
//         if (ind == 0) {
//             return a[0] == n ? true : false;
//         }
//         boolean notTake = isSubsetSum(a, n, ind - 1);
//         boolean take = false;
//         if (a[ind] <= n) {
//              take = isSubsetSum(a,n - a[ind], ind - 1);
//         }
//         return take || notTake;

//     }

//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 3, 4 };
//         int sum = 6;
//         System.out.println(isSubsetSum(arr, sum, 3));
//     }

// }

// TABULATION

// import java.util.Arrays;

// public class SubsetSum {
//     static boolean isSubsetSum(int[] a, int n, int ind,boolean dp[][]) {
//         if (n == 0) {
//             return true;
//         }
//         if (ind == 0) {
//             return a[0] == n ? true : false;
//         }
//         if(dp[ind][n] != false){
//             return dp[ind][n];
//         }
//         boolean notTake = isSubsetSum(a, n, ind - 1,dp);
//         boolean take = false;
//         if (a[ind] <= n) {
//              take = isSubsetSum(a,n - a[ind], ind - 1,dp);
//         }
//         return dp[ind][n] =  take || notTake;

//     }

//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 3, 4 };
//         int sum = 6;
//         boolean dp[][] = new boolean[arr.length + 1][sum + 1];
//         for(boolean[] val : dp){
//             Arrays.fill(val, false);
//         }
//         System.out.println(isSubsetSum(arr, sum, 3,dp));
//     }

// }

// TABULATION

import java.util.Arrays;

public class SubsetSum {
    static boolean isSubsetSum(int[] a, int sum, boolean dp[][]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
                if(i > 0 && j > 0){
                    boolean notTake = dp[i - 1][j];
                    boolean take = false;
                    if (a[i] <= j ) {
                        take = dp[i-1][j - a[i]];
                    }
                    dp[i][j] = notTake || take;
                }

            }
        }
        return dp[n-1][sum];

    }

    public static void main(String[] args) {
        int[] arr = { 1,1,8,4,1};
        int sum = 10;
        boolean dp[][] = new boolean[arr.length+1][sum+1];
 
        System.out.println(isSubsetSum(arr, sum, dp));
    }

}