/**
# 910. Smallest Range II
Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.

Example 1:

Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
Example 2:

Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]
Example 3:

Input: A = [1,3,6], K = 3
Output: 3
Explanation: B = [4,6,3]
 

Note:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000
*/

package com.olsh;

import java.util.Arrays;

public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);

        int maxDiff = A[A.length - 1] - A[0];
        for (int i = 0; i < A.length - 1; ++i) {
            int current = A[i];
            int next = A[i + 1];
            int maxExtremum = Math.max(A[A.length - 1] - K, current + K);
            int minExtremum = Math.min(A[0] + K, next - K);
            maxDiff = Math.min(maxDiff, maxExtremum - minExtremum);
        }
        return maxDiff;
    }
}
