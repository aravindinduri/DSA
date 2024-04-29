import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

// public class KnapSack {
//     public static int solve(int val[], int weight[], int ind, int W) {
//         if (ind == 0) {
//             if (W >= weight[ind]) {
//                 return val[0];
//             } else
//                 return 0;
//         }
//         int take = Integer.MIN_VALUE;
//         int notTake = solve(val, weight, ind-1, W);
//         if (W >= weight[ind]) {
//             take = val[ind] + solve(val, weight, ind - 1, W - weight[ind]);

//         }
//         return Math.max(take, notTake);
//     }

//     public static void main(String[] args) {
//         int value[] = { 40, 50, 20, 11, 50, 90 };
//         int weight[] = { 5, 1, 2, 2, 4, 7 };
//         int n = solve(value, weight,5, 8);
//         System.out.println(n);

//     }
// }

// MEMORISATION

// public class KnapSack {
//     public static int solve(int val[], int weight[], int ind, int W, int[][] dp) {
//         if (ind == 0) {
//             if (W >= weight[ind]) {
//                 return val[0];
//             } else
//                 return 0;
//         }

//         if (dp[ind][W] != -1) {
//             return dp[ind][W];

//         }
//         int take = Integer.MIN_VALUE;
//         int notTake = solve(val, weight, ind - 1, W, dp);
//         if (W >= weight[ind]) {
//             take = val[ind] + solve(val, weight, ind - 1, W - weight[ind], dp);

//         }
//         return dp[ind][W] = Math.max(take, notTake);
//     }

//     public static void main(String[] args) {
//         int value[] = { 40, 50, 20, 11, 50, 90 };
//         int weight[] = { 5, 1, 2, 2, 4, 7 };

//         int dp[][] = new int[6][9];

//         for (int row[] : dp) {
//             Arrays.fill(row, -1);
//         }

//         int n = solve(value, weight, 5, 8, dp);
//         System.out.println(n);

//     }
// }

// TABULATION

public class Knapscak {
    public static int solve(int val[], int Weight[], int W, int[][] dp) {
        int n = val.length;

        for (int i = Weight[0]; i <= W; i++)
            dp[0][i] = val[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                    int take = 0;
                    int notTake = dp[i - 1][j];
                    if (j >= Weight[i]) {
                        take = val[i] + dp[i - 1][j - Weight[i]];
                        
                    }
                    dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][W];

    }

    public static void main(String[] args) {
        int[] val = { 40, 50, 20, 11, 50, 90 };
        int[] wt = { 5, 1, 2, 2, 4, 7 };
        int n = val.length;
        int dp[][] = new int[n][9];
        int max_value = solve(val, wt, 8, dp);
        System.out.println("Max value :" + max_value);
    }
}