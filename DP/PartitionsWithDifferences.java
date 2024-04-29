
/*
Problem Statement:  Count Partitions with Given Difference
Problem Description:

We are given an array ‘ARR’ with N positive integers and an integer D. We need to count the number of ways we can partition the given array into two subsets, S1 and S2 such that S1 - S2 = D and S1 is always greater than or equal to S2.

S1 + S2 = D   – (i)

S1 >= S2     – (ii)

 If we calculate the total sum of elements of the array (say totSum), we can say that,

S1 = totSum - S2      – (iii)

Now solving for equations (i) and (iii), we can say that 

S2 = (totSum - D)/2    – (iv)

Therefore the question “Count Partitions with a difference D” is modified to “Count Number of subsets with sum (totSum - D)/2 ”. This is exactly what we had discussed in the article  Count Subsets with Sum K.

Sample Input 1 :
2
4 3
5 2 6 4
4 0
1 1 1 1


 */
import java.util.*;
import java.io.*;

public class PartitionsWithDifferences {
	static int solve(int[] arr, int ind, int d) {

		if (ind == 0) {
			if (d == 0 && arr[0] == 0)
				return 2;
			if (d == 0 || d == arr[0])
				return 1;
			return 0;
		}
		int notTake = solve(arr, ind - 1, d);
		int take = 0;
		if (d >= arr[ind]) {
			take = solve(arr, ind - 1, d - arr[ind]);
		}
		return take + notTake;

	}

	public static void main(String[] args) {
		int arr[] = {5,2,6,4};
		int d = 0, s2 = 0;
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++)
			totalSum += arr[i];
		if (totalSum - d > 0) {
			s2 = (totalSum - d) / 2;
			if (s2 % 2 != 0) {
				s2 = 0;
			}

		}
		if (s2 != 0) {
			System.out.println(solve(arr, arr.length - 1, s2));
		}
	}

}

// MEMORISATION
