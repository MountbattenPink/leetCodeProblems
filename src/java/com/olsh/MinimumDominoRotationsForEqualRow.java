/*
1007. Minimum Domino Rotations For Equal Row
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
We may rotate the i-th domino, so that A[i] and B[i] swap values.
Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
If it cannot be done, return -1.
Example 1:
Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, 
as indicated by the second figure.
Example 2:
Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
*/

package com.olsh;
import java.util.Math;

class MinimumDominoRotationsForEqualRow {
    int min = Integer.MAX_VALUE;
    public int minDominoRotations(int[] A, int[] B) {
        minDominoRotations(A,B,A[0]); 
        minDominoRotations(A,B,B[0]); 
        minDominoRotations(B,A,A[0]);
        minDominoRotations(B,A,B[0]);
        return min==Integer.MAX_VALUE?-1:min;
    }
    
    public void minDominoRotations(int[] A, int[] B, int n) {
        int sum = 0;
        for (int i=0;i<A.length;i++){
            if (A[i]!=n && B[i]!=n)return;
            else if (A[i]!=n && B[i]==n)sum++;
        }
        min = Math.min(min, sum);
    }
}
