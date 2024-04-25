
// BRUTE FORCE 
// SC - O( n )
// TC -O( n )

// public class MoveZerosToEnd {
//     public static void main(String[] args) {
//         int nums[] = { 1, 0, 2, 3, 0, 4, 0, 1 };
//         int temp[] = new int[nums.length];
//         int k =0;
//         for (int i = 0; i < nums.length; i++) {
//             if(nums[i] != 0)
//             {
//                 temp[k] = nums[i];
//                 k++;
//             }

//         }
//         nums = temp.clone();
//         for (int i = 0; i < nums.length; i++) {
//             System.out.println(nums[i]);
//         }

//     }

// }

// BETTER APPROACH
// TC - O( n )
// SC - O( 1 ) - NO EXTRA SPACE
public class MoveZerosToEnd {
    static void solve(int arr[], int n) {
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1)
            return;

        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 2, 3, 0, 4, 0, 1 };
        int n = nums.length;
        solve(nums, n);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }

    }

}
