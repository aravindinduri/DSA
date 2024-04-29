/*
Count Maximum Consecutive One's in the array

Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.
Example 1:

Input: prices = {1, 1, 0, 1, 1, 1}

Output: 3

Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.

Input: prices = {1, 0, 1, 1, 0, 1} 

Output: 2

Explanation: There are two consecutive 1's in the array. 

 */

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int arr[] = { 1,1,1, 0, 0, 1, 0, 1, 1};
        int count = 0, maxcount = -1;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 1)
              count++;
            else
              count = 0;
            maxcount = Math.max(count,maxcount);
        }
        System.out.println(maxcount);
    }

}
