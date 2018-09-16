/**
#907. Sum of Subarray Minimums
Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 

Note:

1 <= A.length <= 30000
1 <= A[i] <= 30000
 
*/

class SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int M = (int) 1e9 + 7;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int left = 0, right = 0;
            //find number of elements > A[i] to the left
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] >= A[i]) {
                    left++;
                } else break;
            }
            //find number of elements > A[i] to the rigth
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > A[i]) {
                    right++;
                } else break;
            }
            sum = (sum + A[i]) % M;
            sum = (sum + A[i]  * (left + (left + 1) * right)) % M;
        }
        return sum % M;
    }

}
