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

// BRUTE FORCE
//
 class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6,7,8};
        int k = 1;
        for(int i = 0 ; i < arr.length; i++){
            if( k == arr[i]){
                k++;
            }
            else{
                break;
            }
        }
        System.out.println(k);
        
        
    }

}
