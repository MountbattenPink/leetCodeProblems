/**
#922. Sort Array By Parity II
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
You may return any answer array that satisfies this condition.
Example 1:
Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Note:
2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
*/

package com.olsh;
class SortArrayByParityII {
 public int[] sortArrayByParityII(int[] A) {
  for (int i = 0, j = 1; i < A.length && j < A.length;) {
   if (A[i] % 2 == 1) {
    if (A[j] % 2 == 0) {
     int t = A[i];
     A[i] = A[j];
     A[j] = t;
     i += 2;
    }
    j += 2;
   } else {
    if (A[j] % 2 == 1) {
     j += 2;
    }
    i += 2;
   }
  }
  return A;
 }
}
