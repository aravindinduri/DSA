/* 

Find the missing number in an array

Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

Example 1:
Input Format:
 N = 5, array[] = {1,2,4,5}
Result:
 3
Explanation: 
In the given array, number 3 is missing. So, 3 is the answer.

Example 2:
Input Format:
 N = 3, array[] = {1,3}
Result:
 2
Explanation: 
In the given array, number 2 is missing. So, 2 is the answer. 
 */


// SOLUTION - 1 ( if array is sorted )

// TC - O( n )
// SC - O( 1 )

//  class MissingNumber {
//     public static void main(String[] args) {
//         int arr[] = {1,2,4,5,6,7,8};
//         int k = 1;
//         for(int i = 0 ; i < arr.length; i++){
//             if( k == arr[i]){
//                 k++;
//             }
//             else{
//                 break;
//             }
//         }
//         System.out.println(k);
//     }

// }

// USING HASH_ARRAY / HASH_MAP

// SC - O ( n )
// TC - O ( n + n )

// class MissingNumber {
//     public static int missingNumber(int[] a, int N) {

//         int hash[] = new int[N + 1];
//         for (int i = 0; i < N - 1; i++)
//             hash[a[i]]++;

//         for (int i = 1; i <= N; i++) {
//             if (hash[i] == 0) {
//                 return i;
//             }
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         int arr[] = { 1, 2, 3, 4, 5, 6, 7};
//         int N = 8;
//         int res = missingNumber(arr, N);
//         System.out.println(res);
//     }

// }


// N Natural Number Sum 

// SC - O ( 1 )
// TC - O ( n )

// class MissingNumber {
//     public static int missingNumber(int[] a, int N) {
//         int sum = ( N * (N + 1) )/ 2;
//         for (int i = 0; i < a.length; i++) {
//              sum -=a[i];
//         }
 
//         return sum;
//     }

//     public static void main(String[] args) {
//         int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
//         int N = 8;
//         int res = missingNumber(arr, N);
//         System.out.println(res);

//     }
// }

// USING XOR( ^ ) OPERATOR
// XOR WITH SAME NUMBER = 0
// XOR WITH WILL GIVE NUMBER

/*
Assume the given array is: {1, 2, 4, 5} and N = 5.
XOR of (1 to 5) i.e. xor1 = (1^2^3^4^5)
XOR of array elements i.e. xor2 = (1^2^4^5)
XOR of xor1 and xor2 = (1^2^3^4^5) ^ (1^2^4^5)
			= (1^1)^(2^2)^(3)^(4^4)^(5^5)
			= 0^0^3^0^0 = 0^3 = 3.
The missing number is 3.

 */


import java.util.*;

 class MissingNumber {
    public static int missingNumber(int []a, int N) {

        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]

        return (xor1 ^ xor2); // the missing number
    }

    public static void main(String args[]) {
        int N = 5;
        int a[] = {1, 2, 4, 5};

        int ans = missingNumber(a, N);
        System.out.println("The missing number is: " + ans);
    }
}



