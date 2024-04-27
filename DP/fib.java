// RECURSION
// TC - O( n^2 )
// SC - Recursion Stack Space - O (n)
// class Fib {
// public static int solve(int n) {

// if (n <= 1)
// return 1;
// else
// return solve(n - 1) + solve(n - 2);
// }

// public static void main(String[] args) {
// System.out.println(solve(5));
// }
// }

// MEMORISATION

// class Fib {
// public static int solve(int n, int[] dp) {
// if (n <= 1)
// return 1;
// if (dp[n] != -1)
// return dp[n];
// return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
// }

// public static void main(String[] args) {
// int dp[] = new int[6];
// for (int i = 0; i < dp.length; i++) {
// dp[i] = -1;
// }
// System.out.println(solve(5, dp));
// }
// }

// TABULATION
// TC - O (n)
// SC - O (n)

// class Fib {
//     public static int solve(int n) {
//         int dp[] = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = 1;

//         for (int i = 2; i < dp.length; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }

//     public static void main(String[] args) {

//         System.out.println(solve(5));
//     }
// }

// SPACE OPTIMISATION
// SC - O(1)
// TC - O(n)
// 

class Fib {

    public static void main(String[] args) {
        int f0 = 0;
        int f1 = 1;
        int f2 = f1 + f0;
        int n = 5;
        for (int i = 2; i < n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        System.out.println(f2);
    }
}
