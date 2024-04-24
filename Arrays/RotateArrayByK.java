import java.util.*;
import java.io.*;

// BRUTE FORCE
// SC - O( k ) // Extra Space
// TC - O( n )
// class RotateArrayByK {

//     static int[] rotateArray(int[] arr, int k) {
//         int temp[] = new int[k];
//         for (int i = 0; i < k; i++) {
//             temp[i] = arr[i];
//         }
//         for (int i = k; i <= arr.length - 1; i++) {
//             arr[i - k] = arr[i];

//         }
//         for (int i = k + 1; i <= arr.length - 1; i++) {
//             arr[i] = temp[i - k - 1];
//         }
//         return arr;
//     }

//     public static void main(String[] args) {
//         int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
//         int k = 3;
//         rotateArray(nums, k);
//         for (int i = 0; i < nums.length; i++) {
//             System.out.print(nums[i]);
//         }
//     }
// }

// BETTER APPROACH
// SC - O( 1 ) - NO Extra Space
// TC - O( n ) 
class RotateArrayByK {
    static void rotate(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        rotate(arr, 0, k - 1);
        rotate(arr, k, n - 1);
        rotate(arr, 0, n - 1);

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotateArray(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
