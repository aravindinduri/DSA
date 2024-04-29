
// RECURSION

// public class NumberOfSubsets {
//     static int solve(int arr[], int ind, int sum) {
//         if(sum == 0) return 1;
//         if (ind == 0) {
//             return sum == arr[0] ? 1 : 0;
//         }
//         int notTake = solve(arr, ind - 1, sum);
//         int Take = 0;
//         if (sum >= arr[ind]) {
//             Take = solve(arr, ind - 1, sum - arr[ind]);
//         }
//         return notTake + Take;
//     }

//     public static void main(String[] args) {
//         int arr[] = { 1, 2,3 ,3,2};
//         int sum = 3;
//         int res = solve(arr, 4, sum);
//         System.out.println(res);

//     }

// }

// MEMORISATION

import java.util.Arrays;

// public class NumberOfSubsets {
//     static int solve(int arr[], int ind, int sum,int[][] dp) {
//         if (sum == 0)
//             return 1;
//         if (ind == 0) {
//             return sum == arr[0] ? 1 : 0;
//         }
//         if (dp[ind][sum] != -1)
//             return dp[ind][sum];
//         int notTake = solve(arr, ind - 1, sum,dp);
//         int Take = 0;
//         if (sum >= arr[ind]) {
//             Take = solve(arr, ind - 1, sum - arr[ind],dp);
//         }
//         return  dp[ind][sum] = notTake + Take;
//     }

//     public static void main(String[] args) {
//         int arr[] = { 1, 2, 3, 3, 2 };
//         int sum = 3;
//         int dp[][] = new int[arr.length + 1][sum + 1];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
//         int res = solve(arr, 4, sum,dp);
//         System.out.println(res);

//     }

// }

// TABULATION

public class NumberOfSubsets {
    static int solve(int arr[], int sum, int[][] dp) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    if (sum >= arr[0])
                        dp[i][arr[0]] = 1;
                }

                if (j == 0) {
                    dp[i][j] = 1;
                }
                if (i > 0 && j > 0) {
                    int notTake = dp[i - 1][j];
                    int Take = 0;
                    if (j >= arr[i]) {
                        Take = dp[i - 1][j - arr[i]];
                    }
                    dp[i][j] = notTake + Take;
                }

            }
        }
        return dp[n - 1][sum];

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 2 };
        int sum = 3;
        int dp[][] = new int[arr.length][sum + 1];

        int res = solve(arr, sum, dp);
        System.out.println(res);

    }
}